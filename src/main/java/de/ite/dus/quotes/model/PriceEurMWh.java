package de.ite.dus.quotes.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.ite.dus.quotes.json.PriceEurMWhSerializer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonSerialize(using = PriceEurMWhSerializer.class)
public class PriceEurMWh {
    private BigDecimal value;

    public PriceEurMWh(double value) {
        this.value = BigDecimal.valueOf(value);
    }

    public String getUnit() {
        return "Eur/MWh";
    }

    @Override
    public String toString() {
        return getValue() + " " + getUnit();
    }
}
