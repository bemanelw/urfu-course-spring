package org.example.orderservice.controllers;

import org.example.orderservice.models.Order;
import org.example.orderservice.models.OrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    @PostMapping("/orders")
    public void createOrder(@RequestBody Order order) {
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setProduct(order.getProduct());
        orderEvent.setQuantity(order.getQuantity());
        kafkaTemplate.send("order-topic", orderEvent);
    }
}
