package com.event_driven.payments_api.kafka;

import com.google.gson.Gson;
import com.event_driven.payments_api.model.PaymentRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPaymentProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson gson = new Gson();

    public KafkaPaymentProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPayment(PaymentRequest request) {
        String message = gson.toJson(request);
        kafkaTemplate.send("payment.confirmed", request.paymentId(), message);
    }
}