package org.example.orderstatusserver.listeners;


import org.example.orderservice.models.OrderEvent;
import org.example.orderstatusserver.models.OrderStatusEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderListener {

    @Autowired
    private KafkaTemplate<String, OrderStatusEvent> kafkaTemplate;

    @KafkaListener(topics = "order-topic", groupId = "order-status-service")
    public void listen(OrderEvent orderEvent) {
        OrderStatusEvent orderStatusEvent = new OrderStatusEvent();
        orderStatusEvent.setStatus("CREATED");
        orderStatusEvent.setDate(LocalDateTime.now());
        kafkaTemplate.send("order-status-topic", orderStatusEvent);
    }
}
