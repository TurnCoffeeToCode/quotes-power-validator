package de.ite.dus.quotes.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Quote {
    private PriceEurMWh bid;
    private PriceEurMWh ask;
}
