package org.example.orderstatusserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class OrderStatusServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderStatusServerApplication.class, args);
    }

}
