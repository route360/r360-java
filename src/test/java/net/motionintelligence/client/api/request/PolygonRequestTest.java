package net.motionintelligence.client.api.request;

import net.motionintelligence.client.api.TravelOptions;
import net.motionintelligence.client.api.enums.TravelType;
import net.motionintelligence.client.api.exception.Route360ClientException;
import net.motionintelligence.client.api.geo.DefaultSourceCoordinate;
import net.motionintelligence.client.api.response.PolygonResponse;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class PolygonRequestTest extends RequestTest {

    @Test
    public void get_success() throws Exception {
        // Mock success response
        when(sampleResponse.getStatus()).thenReturn(Response.Status.OK.getStatusCode());

        // Get sample json when success response is queried
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("data/PolygonResponse.json");
        String sampleJson = IOUtils.toString(resourceAsStream, Charset.forName("UTF-8"));
        when(sampleResponse.readEntity(String.class)).thenReturn(sampleJson);

        // Make the call
        PolygonRequest polygonRequest = new PolygonRequest(mockClient, getTravelOptions());
        polygonRequest.setMethod(HttpMethod.GET);
        PolygonResponse polygonResponse = polygonRequest.get();

        // Check result
        assertEquals("ok", polygonResponse.getCode());
        assertEquals(2314, polygonResponse.getRequestTimeMillis());

        assertNotNull(polygonResponse.getResult());
    }

    @Test
    public void get_gateway_timeout() throws Exception {
        when(sampleResponse.getStatus()).thenReturn(Response.Status.GATEWAY_TIMEOUT.getStatusCode());

        TravelOptions options = getTravelOptions();
        PolygonRequest polygonRequest = new PolygonRequest(mockClient, options);
        polygonRequest.setMethod(HttpMethod.GET);
        PolygonResponse polygonResponse = polygonRequest.get();
        assertEquals("gateway-time-out", polygonResponse.getCode());
    }

    @Test(expected = Route360ClientException.class)
    public void get_exception() throws Exception {
        when(sampleResponse.getStatus()).thenReturn(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());

        TravelOptions options = getTravelOptions();
        PolygonRequest polygonRequest = new PolygonRequest(mockClient, options);
        polygonRequest.setMethod(HttpMethod.GET);
        polygonRequest.get();
    }

    private TravelOptions getTravelOptions() {
        TravelOptions options = new TravelOptions();
        options.setTravelTimes(Arrays.asList(600, 1200, 1800, 2400, 3000, 3600));
        options.setTravelType(TravelType.TRANSIT);
        options.addSource(new DefaultSourceCoordinate("id1", -73.976636, 40.608155));
        options.setServiceKey("INSERT_YOUR_KEY_HERE");
        options.setServiceUrl("https://service.route360.net/na_northeast/");
        options.setDate(20161020);
        options.setTime(55852);
        return options;
    }

}