package com.example.restaurant_app.service;

import com.example.restaurant_app.model.dao.OrderEntity;
import com.example.restaurant_app.model.dao.PizzaEntity;
import com.example.restaurant_app.model.dto.OrderRequest;
import com.example.restaurant_app.model.dto.OrderResponse;
import com.example.restaurant_app.repository.OrderRepository;
import com.example.restaurant_app.repository.PizzaRepository;
import com.example.restaurant_app.service.converters.OrderConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;
    private final OrderConverter orderConverter;

    public OrderResponse createOrder(OrderRequest request) {
        OrderEntity toSave = orderConverter.fromDto(request);
        OrderEntity savedOrderEntity = orderRepository.save(toSave);
        return  orderConverter.toDto(toSave);

    }
}
