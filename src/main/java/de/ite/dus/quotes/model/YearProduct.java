package de.ite.dus.quotes.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
public class YearProduct {

    private Year year;

    private Quote base;
    private Quote peak;

}
