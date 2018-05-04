package de.ite.dus.quotes;

import de.ite.dus.quotes.model.QuotesSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class QuotesConsumer {
    private KafkaTemplate<String, QuotesSet> kafkaTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(QuotesConsumer.class);

    @KafkaListener(topics = "${kafka.topic.quotes.consumer}")
    public void receive(QuotesSet quotes) {
        LOGGER.info("received quotes='{}'", quotes);
    }
}
