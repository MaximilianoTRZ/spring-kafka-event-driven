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

    @KafkaListener(topics = "payment.confirmed", groupId = "orders-group")
    public void consume(String message) {

        JsonObject json = gson.fromJson(message, JsonObject.class);
        System.out.println("🟢 Mensaje recibido de Kafka: " + message);

        OrderEntity order = new OrderEntity(
                json.get("paymentId").getAsString(),
                json.get("userId").getAsString(),
                json.get("product").getAsString(),
                json.get("amount").getAsDouble(),
                LocalDateTime.now()
        );
        orderRepository.save(order);
        System.out.println("✅ Orden persistida: " + order.getPaymentId());
    }
}