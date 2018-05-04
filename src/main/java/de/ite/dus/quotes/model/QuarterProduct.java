package de.ite.dus.quotes.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
public class QuarterProduct {
    public enum Quarter {
        Q1, Q2, Q3, Q4
    }

    private Year year;
    private Quarter quarter;

    private Quote base;
    private Quote peak;
}
