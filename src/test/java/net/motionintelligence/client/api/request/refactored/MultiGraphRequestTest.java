package net.motionintelligence.client.api.request.refactored;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.motionintelligence.client.api.TravelOptions;
import net.motionintelligence.client.api.enums.EdgeWeightType;
import net.motionintelligence.client.api.enums.TravelType;
import net.motionintelligence.client.api.exception.Route360ClientException;
import net.motionintelligence.client.api.geo.DefaultSourceCoordinate;
import net.motionintelligence.client.api.request.RequestTest;
import net.motionintelligence.client.api.request.ssl.SslClientGenerator;
import net.motionintelligence.client.api.response.refactored.MultiGraphResponse;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.message.GZipEncoder;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class MultiGraphRequestTest extends RequestTest {

	@Test
	public void get_success() throws Exception {
		// Mock success response
		when(sampleResponse.getStatus()).thenReturn(Response.Status.OK.getStatusCode());

		// Get sample json when success response is queried
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("data/MultigraphResponseSample.json");
		String sampleJson = IOUtils.toString(resourceAsStream, Charset.forName("UTF-8"));
		when(sampleResponse.readEntity(String.class)).thenReturn(sampleJson);

		// Make the call
		MultiGraphRequest request = new MultiGraphRequest(mockClient, getTravelOptions());
		MultiGraphResponse response = request.get();

		// Check result
		assertEquals("ok", response.getCode());
		assertEquals(374, response.getRequestTimeMillis());

		assertNotNull(response.getData());
	}

	@Test
	public void get_gateway_timeout() throws Exception {
		when(sampleResponse.getStatus()).thenReturn(Response.Status.GATEWAY_TIMEOUT.getStatusCode());

		MultiGraphRequest request = new MultiGraphRequest(mockClient, getTravelOptions());
		MultiGraphResponse response = request.get();

		assertEquals("gateway-time-out", response.getCode());
	}

	@Test(expected = Route360ClientException.class)
	public void get_exception() throws Exception {
		when(sampleResponse.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());

        MultiGraphRequest request = new MultiGraphRequest(mockClient, getTravelOptions());
        request.get();
	}

	private TravelOptions getTravelOptions() {
		TravelOptions options = new TravelOptions();
		options.addSource(new DefaultSourceCoordinate("POI:0", 52.5494892, 13.42883045));
		options.setServiceKey("INSERT_YOUR_KEY_HERE");
		options.setServiceUrl("http://127.0.0.1:8080/");
		options.setEdgeWeightType(EdgeWeightType.TIME);
		options.setMaxEdgeWeight(300);
		options.setTravelType(TravelType.BIKE);
		return options;
	}

    @Test
    @Ignore("System test - needs local R360 server to run")
    public void systemTestLocally() throws Exception {

        Client client = SslClientGenerator.initClient();
        client.register(GZipEncoder.class);
        MultiGraphRequest request = new MultiGraphRequest(client, getTravelOptions());
        MultiGraphResponse response = request.get();

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response.getData()));
    }
}