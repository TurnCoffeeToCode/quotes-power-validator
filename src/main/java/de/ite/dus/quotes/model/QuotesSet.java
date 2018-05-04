package de.ite.dus.quotes.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class QuotesSet {
    private LocalDateTime timestamp;
    private Country country;
    private List<MonthProduct> monthProducts;
    private List<QuarterProduct> quarterProducts;
    private List<YearProduct> yearProducts;
}
