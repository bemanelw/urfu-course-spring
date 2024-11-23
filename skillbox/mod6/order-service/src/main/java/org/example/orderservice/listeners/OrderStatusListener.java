package org.example.orderservice.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class OrderStatusListener {

    private static final Logger log = LoggerFactory.getLogger(OrderStatusListener.class);

    @KafkaListener(topics = "order-status-topic", groupId = "order-service")
    public void listen(String message, String key, int partition, String topic, long timestamp) {
        log.info("Received message: {}", message);
        log.info("Key: {}; Partition: {}; Topic: {}, Timestamp: {}", key, partition, topic, timestamp);
    }
}
