package com.event_driven.orders_api.service;

import com.event_driven.orders_api.entity.OrderEntity;
import java.util.List;

public interface OrderEntityService {
    List<OrderEntity> getAllOrders();
}
