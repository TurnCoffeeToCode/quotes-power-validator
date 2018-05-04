package de.ite.dus.quotes.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Month;
import java.time.Year;

@Getter
@Setter
public class MonthProduct {

    private Year year;
    private Month month;

    private Quote base;
    private Quote peak;

}
