package de.ite.dus.quotes.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import de.ite.dus.quotes.model.PriceEurMWh;

import java.io.IOException;

public class PriceEurMWhSerializer extends JsonSerializer<PriceEurMWh>{
    @Override
    public void serialize(PriceEurMWh price, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(price.toString());
    }
}
