package com.event_driven.orders_api.service;

import com.event_driven.orders_api.entity.OrderEntity;
import com.event_driven.orders_api.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderEntityServiceImpl implements OrderEntityService {

    private final OrderRepository orderRepository;

    public OrderEntityServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }
}
