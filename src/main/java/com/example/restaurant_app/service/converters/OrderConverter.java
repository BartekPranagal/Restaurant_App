package com.example.restaurant_app.service.converters;

import com.example.restaurant_app.model.dao.OrderEntity;
import com.example.restaurant_app.model.dto.OrderRequest;
import com.example.restaurant_app.model.dto.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderConverter implements Convertable<OrderRequest, OrderEntity, OrderResponse> {



    @Override
    public OrderEntity fromDto(OrderRequest request) {
        OrderEntity result = new OrderEntity();

        result.setOrderType(request.getOrderType());
        result.setOrderedPizza(request.getOrderedPizza());

        return result;
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
