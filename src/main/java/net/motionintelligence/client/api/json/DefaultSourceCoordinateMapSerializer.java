package net.motionintelligence.client.api.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.motionintelligence.client.api.geo.DefaultSourceCoordinate;

import java.io.IOException;
import java.util.Map;

/**
 * Created by gerb on 01/03/2017.
 */
public class DefaultSourceCoordinateMapSerializer extends JsonSerializer {
    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

        jsonGenerator.writeStartArray(); // [

        for ( Map.Entry<String, DefaultSourceCoordinate> entry : ((Map<String, DefaultSourceCoordinate>) o).entrySet())  {

            jsonGenerator.writeStartObject(); // {
            jsonGenerator.writeStringField("id", entry.getKey());
            if ( entry.getValue().getTravelType() != null ) jsonGenerator.writeStringField("tm", entry.getValue().getTravelType().toString());
            jsonGenerator.writeNumberField("y", entry.getValue().getY());
            jsonGenerator.writeNumberField("x", entry.getValue().getX());
            jsonGenerator.writeEndObject(); // {
        }

        jsonGenerator.writeEndArray(); // ]
    }
}
