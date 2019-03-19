package ru.crealex.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {
    public static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public Sender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, String payload) {
        LOGGER.info("Send into kafka topic : " + topic + " message : " + payload);
        kafkaTemplate.send(topic, payload);
    }
}
