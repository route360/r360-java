package net.motionintelligence.client.api.request;

import net.motionintelligence.client.api.TravelOptions;
import net.motionintelligence.client.api.exception.Route360ClientException;
import net.motionintelligence.client.api.geo.Coordinate;
import net.motionintelligence.client.api.request.config.RequestConfigurator;
import net.motionintelligence.client.api.response.OverpassResponse;
import net.motionintelligence.client.api.response.PointOfInterestResponse;
import net.motionintelligence.client.api.util.IOUtil;
import net.motionintelligence.client.api.util.JsonUtil;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.message.GZipEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Find reachable openstreetmap pois with this class.
 * Only accepts {@link HttpMethod} POST.
 */
public class OverpassRequest {

	private static final Logger LOGGER = LoggerFactory.getLogger(OverpassRequest.class);

	private Client client;
	private TravelOptions travelOptions;
	private static final String CALLBACK = "callback";

	/**
	 * Use default client implementation with specified options and method
	 * Default client uses {@link ClientBuilder} with a {@link GZipEncoder} attached.
	 * @param travelOptions Options to be used
	 */
	public OverpassRequest(TravelOptions travelOptions) {

		this.client	= ClientBuilder.newClient();
		this.client.property(ClientProperties.CONNECT_TIMEOUT, Integer.MAX_VALUE);
		this.client.property(ClientProperties.READ_TIMEOUT,    Integer.MAX_VALUE);
		this.client.register(GZipEncoder.class);
		this.travelOptions = travelOptions;
	}

	/**
	 * Use a custom client implementation with specified options and method
	 * @param client Client implementation to be used
	 * @param travelOptions Options to be used
	 */
	public OverpassRequest(Client client, TravelOptions travelOptions){
		
		this.client	= client;
		this.travelOptions = travelOptions;
	}

	public static void main(String[] args) throws Route360ClientException {

		TravelOptions tp = new TravelOptions();
		tp.setOverpassServiceUrl("https://api5.eu.route360.net:8081/");
		tp.setOverpassQuery("[maxsize:12147483648][timeout:3600][out:json]\n" +
				"[bbox:47.2701115,5.8663425,55.0815,15.0418962];\n" +
				"(\n" +
				"  node['tourism'='hotel'];\n" +
				"  way['tourism'='hotel'];\n" +
				");\n" +
				"out center;");

		long start = System.currentTimeMillis();
		try {

			final OverpassResponse overpassResponse = new OverpassRequest(tp).get();
			final Map<String, Coordinate> targets = overpassResponse.getTargets();
			System.out.println(String.format("Targets: %s", targets.size()));
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println(String.format("Failed after: %sms", System.currentTimeMillis() - start));
		}

	}

	/**
	 * Execute request
	 * @return point of interest response
	 * @throws Route360ClientException In case of error other than Gateway Timeout
	 */
	public OverpassResponse get() throws Route360ClientException {
		
		long requestStart = System.currentTimeMillis();
		
		WebTarget target = client.target(travelOptions.getOverpassServiceUrl()).path("/api/interpreter");

        LOGGER.info(String.format("%s", target.getUri()));

		if (travelOptions.getOverpassQuery() == null || travelOptions.getOverpassQuery().isEmpty())
			throw new Route360ClientException("Empty query");

		final Entity<String> entity = Entity.entity(travelOptions.getOverpassQuery(), MediaType.APPLICATION_JSON_TYPE);

		LOGGER.debug(String.format("Executing overpass query to URI: '%s'", target.getUri()));

		Response response = target.request().post(entity);

		return validateResponse(response, requestStart);
	}

	/**
	 * Validate HTTP response and return a OverpassResponse
	 * @param response HTTP response
	 * @param requestStart Beginning of execution in milliseconds
	 * @return OverpassResponse
	 * @throws Route360ClientException In case of errors other than GatewayTimeout
	 */
	private OverpassResponse validateResponse(final Response response, final long requestStart) throws Route360ClientException {

		// compare the HTTP status codes, NOT the route 360 code
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {
			// consume the results
			return new OverpassResponse(travelOptions, JsonUtil.parseString(IOUtil.getResultString(response)), requestStart);
		}
		else {
			throw new Route360ClientException(response.readEntity(String.class), null);
		}
	}
}
