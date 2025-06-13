package com.event_driven.orders_api.controller;

import com.event_driven.orders_api.entity.OrderEntity;
import com.event_driven.orders_api.service.OrderEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderEntityController {

    private final OrderEntityService orderEntityService;

    public OrderEntityController(OrderEntityService orderEntityService) {
        this.orderEntityService = orderEntityService;
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAllOrders() {
        List<OrderEntity> orders = orderEntityService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

}
