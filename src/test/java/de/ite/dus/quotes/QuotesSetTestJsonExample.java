package de.ite.dus.quotes;

public class QuotesSetTestJsonExample {
    private static final String EMPTY_PRODUCT_ARRAY = "null";
    private static final String MONTH_PRODUCT = "{" +
            "\"year\":\"2021\"," +
            "\"month\":\"MAY\"," +
            "\"base\":{\"bid\":\"0.5001 Eur/MWh\",\"ask\":\"0.5201 Eur/MWh\"}," +
            "\"peak\":{\"bid\":\"2.0001 Eur/MWh\",\"ask\":\"2.0201 Eur/MWh\"}" +
            "}";

    private static final String QUARTER_PRODUCT = "{" +
            "\"year\":\"2021\"," +
            "\"quarter\":\"Q2\"," +
            "\"base\":{\"bid\":\"0.4999 Eur/MWh\",\"ask\":\"0.5099 Eur/MWh\"}," +
            "\"peak\":{\"bid\":\"1.9998 Eur/MWh\",\"ask\":\"2.0999 Eur/MWh\"}" +
            "}";

    private static final String YEAR_PRODUCT = "{" +
            "\"year\":\"2021\"," +
            "\"base\":{\"bid\":\"0.4899 Eur/MWh\",\"ask\":\"0.4998 Eur/MWh\"}," +
            "\"peak\":{\"bid\":\"1.9898 Eur/MWh\",\"ask\":\"2.0899 Eur/MWh\"}" +
            "}";

    private static final String DEFAULT_QUOTESET_TEMPLATE =
            "{\"timestamp\":\"2018-05-01T14:08:17.135\"," +
                    "\"country\":\"DE\"," +
                    "\"monthProducts\":%s," +
                    "\"quarterProducts\":%s," +
                    "\"yearProducts\":%s" +
                    "}";

    static final String QUOTESET_MONTHPRODUCT = String.format(DEFAULT_QUOTESET_TEMPLATE,
            "[" + MONTH_PRODUCT + "]",
            EMPTY_PRODUCT_ARRAY,
            EMPTY_PRODUCT_ARRAY);

    static final String QUOTESET_QUARTERPRODUCT = String.format(DEFAULT_QUOTESET_TEMPLATE,
            EMPTY_PRODUCT_ARRAY,
            "[" + QUARTER_PRODUCT + "]",
            EMPTY_PRODUCT_ARRAY);

    static final String QUOTESET_YEARPRODUCT = String.format(DEFAULT_QUOTESET_TEMPLATE,
            EMPTY_PRODUCT_ARRAY,
            EMPTY_PRODUCT_ARRAY,
            "[" + YEAR_PRODUCT + "]");

    static final String QUOTESET_MONTH_QUARTER_YEAR_PRODUCTS = String.format(DEFAULT_QUOTESET_TEMPLATE,
            "[" + MONTH_PRODUCT + "]",
            "[" + QUARTER_PRODUCT + "]",
            "[" + YEAR_PRODUCT + "]");

}
