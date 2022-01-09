package com.example.restaurant_app.service;

import com.example.restaurant_app.model.dao.PizzaEntity;
import com.example.restaurant_app.model.dto.OrderRequest;
import com.example.restaurant_app.model.dto.OrderResponse;
import com.example.restaurant_app.repository.OrderRepository;
import com.example.restaurant_app.repository.PizzaRepository;
import com.example.restaurant_app.service.converters.OrderConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;
    private final OrderConverter orderConverter;

    public OrderResponse addPizza(OrderRequest request) {
        List<PizzaEntity> pizzaEntityList = pizzaRepository.findById(request.getPizzaId())
                .stream().collect(Collectors.toList());
        OrderResponse orderResponse = OrderResponse.builder()
                .orderType(request.getOrderType())
                .orderList(pizzaEntityList)
                .build();
        orderRepository.save(orderConverter.fromDto(orderResponse));
        return orderResponse;
    }
}
