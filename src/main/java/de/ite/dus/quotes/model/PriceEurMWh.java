package de.ite.dus.quotes.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.ite.dus.quotes.json.PriceEurMWhDeserializer;
import de.ite.dus.quotes.json.PriceEurMWhSerializer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonSerialize(using = PriceEurMWhSerializer.class)
@JsonDeserialize(using = PriceEurMWhDeserializer.class)
public class PriceEurMWh {
    private BigDecimal value;

    public PriceEurMWh(double value) {
        this.value = BigDecimal.valueOf(value);
    }

    @Override
    public String toString() {
        return getValue() + " " + getUnit();
    }

    public static String getUnit() {
        return "Eur/MWh";
    }
}
