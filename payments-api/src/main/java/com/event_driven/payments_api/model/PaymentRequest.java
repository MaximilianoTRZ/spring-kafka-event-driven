package com.event_driven.payments_api.model;

public record PaymentRequest (String paymentId, String userId, double amount, String product) {}
