package com.event_driven.orders_api.kafka;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.event_driven.orders_api.entity.OrderEntity;
import com.event_driven.orders_api.repository.OrderRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaOrderConsumer {

    private final OrderRepository orderRepository;
    private final Gson gson = new Gson();

    public KafkaOrderConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "payment", groupId = "order-group")
    public void consume(String message) {
        System.out.println("🟢 Mensaje recibido de Kafka: " + message);
    }
}