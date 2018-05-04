package de.ite.dus.quotes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.ite.dus.quotes.model.MonthProduct;
import de.ite.dus.quotes.model.QuarterProduct;
import de.ite.dus.quotes.model.QuotesSet;
import de.ite.dus.quotes.model.YearProduct;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.Year;
import java.util.function.Consumer;

import static de.ite.dus.quotes.QuotesSetTestJsonExample.*;
import static de.ite.dus.quotes.model.Country.DE;
import static de.ite.dus.quotes.model.QuarterProduct.Quarter.Q2;
import static java.time.Month.MAY;
import static org.assertj.core.api.Assertions.assertThat;


public class QuotesSetDeserializerTest {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void configureObjectMapper() {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }


    @Test
    public void deserializeQuotesSet_singleMonthProduct() throws IOException {
        executeDeserializeQuotesSet(QUOTESET_MONTHPRODUCT, this::assertSingleMonthProduct);
    }

    private void assertSingleMonthProduct(QuotesSet quotesSet) {
        assertThat(quotesSet.getMonthProducts()).hasSize(1);
        assertMonthProduct(quotesSet.getMonthProducts().get(0));
    }

    @Test
    public void deserializeQuotesSet_singleQuarterProduct() throws IOException {
        executeDeserializeQuotesSet(QUOTESET_QUARTERPRODUCT, this::assertSingleQuarterProduct);
    }

    private void assertSingleQuarterProduct(QuotesSet quotesSet) {
        assertThat(quotesSet.getQuarterProducts()).hasSize(1);
        assertQuarterProduct(quotesSet.getQuarterProducts().get(0));
    }

    @Test
    public void deserializeQuotesSet_singleYearProduct() throws IOException {
        executeDeserializeQuotesSet(QUOTESET_YEARPRODUCT, this::assertSingleYearProduct);
    }

    private void assertSingleYearProduct(QuotesSet quotesSet) {
        assertThat(quotesSet.getYearProducts()).hasSize(1);
        assertYearProduct(quotesSet.getYearProducts().get(0));
    }

    @Test
    public void deserializeQuotesSet_monthQuartAndYearProducts() throws IOException {
        executeDeserializeQuotesSet(QUOTESET_MONTH_QUARTER_YEAR_PRODUCTS,
                this::assertMonthQuarterAndYearProducts);
    }

    private void assertMonthQuarterAndYearProducts(QuotesSet quotesSet) {
        assertSingleMonthProduct(quotesSet);
        assertSingleQuarterProduct(quotesSet);
        assertSingleYearProduct(quotesSet);
    }

    private void executeDeserializeQuotesSet(String jsonString, Consumer<QuotesSet> specificAsserter) throws IOException {
        QuotesSet quotesSet = objectMapper.readValue(jsonString, QuotesSet.class);
        assertThat(quotesSet).isNotNull();
        assertThat(quotesSet.getTimestamp()).isNotNull();
        assertThat(quotesSet.getCountry()).isEqualTo(DE);
        specificAsserter.accept(quotesSet);
    }

    private void assertMonthProduct(MonthProduct product) {
        assertThat(product).isNotNull();
        assertThat(product).isExactlyInstanceOf(MonthProduct.class);
        assertThat(product.getMonth()).isEqualTo(MAY);
        assertThat(product.getYear()).isEqualTo(Year.of(2021));
        assertThat(product.getBase().getBid().getValue().doubleValue()).isEqualTo(0.5001);
        assertThat(product.getBase().getAsk().getValue().doubleValue()).isEqualTo(0.5201);
        assertThat(product.getPeak().getBid().getValue().doubleValue()).isEqualTo(2.0001);
        assertThat(product.getPeak().getAsk().getValue().doubleValue()).isEqualTo(2.0201);
    }

    private void assertQuarterProduct(QuarterProduct product) {
        assertThat(product).isNotNull();
        assertThat(product).isExactlyInstanceOf(QuarterProduct.class);
        assertThat(product.getQuarter()).isEqualTo(Q2);
        assertThat(product.getYear()).isEqualTo(Year.of(2021));
        assertThat(product.getBase().getBid().getValue().doubleValue()).isEqualTo(0.4999);
        assertThat(product.getBase().getAsk().getValue().doubleValue()).isEqualTo(0.5099);
        assertThat(product.getPeak().getBid().getValue().doubleValue()).isEqualTo(1.9998);
        assertThat(product.getPeak().getAsk().getValue().doubleValue()).isEqualTo(2.0999);
    }

    private void assertYearProduct(YearProduct product) {
        assertThat(product).isNotNull();
        assertThat(product).isExactlyInstanceOf(YearProduct.class);
        assertThat(product.getYear()).isEqualTo(Year.of(2021));
        assertThat(product.getBase().getBid().getValue().doubleValue()).isEqualTo(0.4899);
        assertThat(product.getBase().getAsk().getValue().doubleValue()).isEqualTo(0.4998);
        assertThat(product.getPeak().getBid().getValue().doubleValue()).isEqualTo(1.9898);
        assertThat(product.getPeak().getAsk().getValue().doubleValue()).isEqualTo(2.0899);
    }
}