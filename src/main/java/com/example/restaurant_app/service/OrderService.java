package com.example.restaurant_app.service;

import com.example.restaurant_app.model.dao.PizzaEntity;
import com.example.restaurant_app.model.dto.OrderRequest;
import com.example.restaurant_app.model.dto.OrderResponse;
import com.example.restaurant_app.repository.OrderRepository;
import com.example.restaurant_app.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;
    private PizzaRepository pizzaRepository;

    public OrderResponse addPizza(OrderRequest request) {
        OrderResponse orderResponse = orderRepository.findById()
        PizzaEntity pizzaEntity = pizzaRepository.getById(request.getPizzaId());

    }
}
