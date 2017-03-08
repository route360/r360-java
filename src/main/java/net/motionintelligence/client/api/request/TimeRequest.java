package net.motionintelligence.client.api.request;

import net.motionintelligence.client.api.TravelOptions;
import net.motionintelligence.client.api.exception.Route360ClientException;
import net.motionintelligence.client.api.request.config.RequestConfigurator;
import net.motionintelligence.client.api.response.TimeResponse;
import net.motionintelligence.client.api.util.IOUtil;
import net.motionintelligence.client.api.util.JsonUtil;
import org.apache.log4j.ConsoleAppender;
import org.glassfish.jersey.message.GZipEncoder;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Calculates travel times from each source point to each target.
 * Only accepts {@link HttpMethod} POST.
 */
public class TimeRequest {

	private static final String CALLBACK = "callback";

	private Client client;
	private TravelOptions travelOptions;

	/**
	 * Use default client implementation with specified options and method
	 * Default client uses {@link ClientBuilder} with a {@link GZipEncoder} attached.
	 * @param travelOptions Options to be used
	 */
	public TimeRequest(TravelOptions travelOptions) {
		this.client	= ClientBuilder.newClient();
		client.register(GZipEncoder.class);
		
		this.travelOptions = travelOptions;
	}

	/**
	 * Use a custom client implementation with specified options and method
	 * @param client Client implementation to be used
	 * @param travelOptions Options to be used
	 */
	public TimeRequest(Client client, TravelOptions travelOptions) {
		this.client	= client;
		this.travelOptions = travelOptions;
	}

	/**
	 * Execute request
	 * @return Time response
	 * @throws Route360ClientException In case of error other than Gateway Timeout
	 */
	public TimeResponse get() throws Route360ClientException, ProcessingException {
		
		long requestStart = System.currentTimeMillis();
		
		WebTarget target = client.target(travelOptions.getServiceUrl()).path("v1/time")
				.queryParam("cb", CALLBACK)
				.queryParam("key", travelOptions.getServiceKey());

		Response response;
		String config = RequestConfigurator.getConfig(travelOptions);
		// Execute POST request
		response = target.request().post(Entity.entity(config, MediaType.APPLICATION_JSON_TYPE));

		long roundTripTime = System.currentTimeMillis() - requestStart;

		return validateResponse(response, requestStart, roundTripTime);
	}

	/**
	 * Validate HTTP response and return a TimeResponse
	 * @param response HTTP response
	 * @param requestStart Beginning of execution in milliseconds
	 * @param roundTripTime Execution time in milliseconds
	 * @return TimeResponse
	 * @throws Route360ClientException In case of errors other than GatewayTimeout
	 */
	private TimeResponse validateResponse(final Response response, final long requestStart, final long roundTripTime)
			throws Route360ClientException {

		// compare the HTTP status codes, NOT the route 360 code
		if (response.getStatus() == Response.Status.OK.getStatusCode()) {

			String res = IOUtil.getResultString(response);

			// consume the results
			return new TimeResponse(travelOptions, JsonUtil.parseString(res), requestStart);
		} else if (response.getStatus() == Response.Status.GATEWAY_TIMEOUT.getStatusCode() )
			return new TimeResponse(travelOptions, "gateway-time-out", roundTripTime, requestStart);
		else {
			throw new Route360ClientException(response.readEntity(String.class), null);
		}
	}
}
