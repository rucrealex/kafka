package ru.crealex.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class Receiver {

    public static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.roles}")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        LOGGER.info("topic: " + consumerRecord.topic() + ", readed message: " + consumerRecord.toString());
        latch.countDown();
    }
}
