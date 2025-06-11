package com.event_driven.orders_api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Order {
    @Id
    private String paymentId;
    private String userId;
    private String product;
    private double amount;
    private LocalDateTime createdAt;

    public Order() {}

    public Order(String paymentId, String userId, String product, double amount, LocalDateTime createdAt) {
        this.paymentId = paymentId;
        this.userId = userId;
        this.product = product;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    // Getters y Setters

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}