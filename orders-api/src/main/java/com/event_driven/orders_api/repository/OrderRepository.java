package com.event_driven.orders_api.repository;

import com.event_driven.orders_api.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {}
