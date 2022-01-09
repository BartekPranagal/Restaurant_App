package com.example.restaurant_app.service.converters;

import com.example.restaurant_app.model.dao.OrderEntity;
import com.example.restaurant_app.model.dto.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderConverter implements Convertable<OrderResponse, OrderEntity, OrderResponse> {
    @Override
    public OrderEntity fromDto(OrderResponse request) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderType(request.getOrderType());
        orderEntity.setOrderedPizza(request.getOrderList());
        return orderEntity;
    }

    @Override
    public OrderResponse toDto(OrderEntity orderEntity) {
        return OrderResponse.builder()
                .id(orderEntity.getId())
                .orderType(orderEntity.getOrderType())
                .orderList(orderEntity.getOrderedPizza())
                .build();
    }
}
