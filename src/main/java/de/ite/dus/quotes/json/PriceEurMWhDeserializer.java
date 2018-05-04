package de.ite.dus.quotes.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import de.ite.dus.quotes.model.PriceEurMWh;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceEurMWhDeserializer extends JsonDeserializer<PriceEurMWh> {

    private static final Pattern PRICE_PATTERN = Pattern.compile("(\\d+\\.\\d+) " + PriceEurMWh.getUnit());

    @Override
    public PriceEurMWh deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        TextNode priceNode = jsonParser.getCodec().readTree(jsonParser);
        String priceText = priceNode.asText();
        Matcher matcher = PRICE_PATTERN.matcher(priceText);
        if (matcher.matches()) {
            return new PriceEurMWh(Double.valueOf(matcher.group(1)));
        }
        return null;
    }
}
