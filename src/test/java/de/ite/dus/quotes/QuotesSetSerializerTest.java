package de.ite.dus.quotes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.ite.dus.quotes.model.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.Collections;

import static de.ite.dus.quotes.QuotesSetTestJsonExample.*;
import static de.ite.dus.quotes.model.Country.DE;
import static de.ite.dus.quotes.model.QuarterProduct.Quarter.Q2;
import static java.time.Month.MAY;
import static org.assertj.core.api.Assertions.assertThat;

public class QuotesSetSerializerTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void configureObjectMapper() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Test
    public void serializeQuotesSet_singleMonthProduct() throws JsonProcessingException {
        QuotesSet quotesSet = createQuotesSet();
        quotesSet.setMonthProducts(Collections.singletonList(createMonthProduct()));
        String strJson = objectMapper.writeValueAsString(quotesSet);
        assertThat(strJson).isEqualTo(QUOTESET_MONTHPRODUCT);
    }

    @Test
    public void serializeQuotesSet_singleQuarterProduct() throws JsonProcessingException {
        QuotesSet quotesSet = createQuotesSet();
        quotesSet.setQuarterProducts(Collections.singletonList(createQuarterProduct()));
        String strJson = objectMapper.writeValueAsString(quotesSet);
        assertThat(strJson).isEqualTo(QUOTESET_QUARTERPRODUCT);
    }

    @Test
    public void serializeQuotesSet_singleYearProduct() throws JsonProcessingException {
        QuotesSet quotesSet = createQuotesSet();
        quotesSet.setYearProducts(Collections.singletonList(createYearProduct()));
        String strJson = objectMapper.writeValueAsString(quotesSet);
        assertThat(strJson).isEqualTo(QUOTESET_YEARPRODUCT);
    }

    @Test
    public void serializeQuotesSet_MonthQuarterAndYearProduct() throws JsonProcessingException {
        QuotesSet quotesSet = createQuotesSet();
        quotesSet.setMonthProducts(Collections.singletonList(createMonthProduct()));
        quotesSet.setQuarterProducts(Collections.singletonList(createQuarterProduct()));
        quotesSet.setYearProducts(Collections.singletonList(createYearProduct()));
        String strJson = objectMapper.writeValueAsString(quotesSet);
        assertThat(strJson).isEqualTo(QUOTESET_MONTH_QUARTER_YEAR_PRODUCTS);
    }

    private QuotesSet createQuotesSet() {
        QuotesSet quotesSet = new QuotesSet();
        quotesSet.setTimestamp(LocalDateTime.of(2018, 5, 1, 14, 8, 17, 135000000));
        quotesSet.setCountry(DE);
        return quotesSet;
    }

    private MonthProduct createMonthProduct() {
        MonthProduct product = new MonthProduct();
        product.setYear(Year.of(2021));
        product.setMonth(MAY);
        product.setBase(createQuote(0.5001, 0.5201));
        product.setPeak(createQuote(2.0001, 2.0201));
        return product;
    }

    private QuarterProduct createQuarterProduct() {
        QuarterProduct product = new QuarterProduct();
        product.setYear(Year.of(2021));
        product.setQuarter(Q2);
        product.setBase(createQuote(0.4999, 0.5099));
        product.setPeak(createQuote(1.9998, 2.0999));
        return product;
    }

    private YearProduct createYearProduct() {
        YearProduct product = new YearProduct();
        product.setYear(Year.of(2021));
        product.setBase(createQuote(0.4899, 0.4998));
        product.setPeak(createQuote(1.9898, 2.0899));
        return product;
    }

    private Quote createQuote(double bidPrice, double askPrice) {
        Quote quote = new Quote();
        quote.setBid(new PriceEurMWh(bidPrice));
        quote.setAsk(new PriceEurMWh(askPrice));
        return quote;
    }


}