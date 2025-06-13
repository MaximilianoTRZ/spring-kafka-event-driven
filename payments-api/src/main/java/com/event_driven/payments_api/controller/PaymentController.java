package com.event_driven.payments_api.controller;

import com.event_driven.payments_api.kafka.KafkaPaymentProducer;
import com.event_driven.payments_api.model.PaymentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final KafkaPaymentProducer producer;

    public PaymentController(KafkaPaymentProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<Void> createPayment(@RequestBody PaymentRequest request) {
        producer.sendPayment(request);
        return ResponseEntity.accepted().build();
    }
}
