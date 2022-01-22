package com.example.restaurant_app.service;

import com.example.restaurant_app.model.dao.OrderEntity;
import com.example.restaurant_app.model.dao.PizzaEntity;
import com.example.restaurant_app.model.dto.OrderRequest;
import com.example.restaurant_app.model.dto.OrderResponse;
import com.example.restaurant_app.repository.OrderRepository;
import com.example.restaurant_app.repository.PizzaRepository;
import com.example.restaurant_app.service.converters.OrderConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;
    private final OrderConverter orderConverter;

    public OrderResponse createOrder(OrderRequest request) {
        OrderEntity toSave = orderConverter.fromDto(request);
        OrderEntity savedOrderEntity = orderRepository.save(toSave);
        return  orderConverter.toDto(savedOrderEntity);
    }

    public OrderResponse getById(Long orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Brak szukanego id"));
        return orderConverter.toDto(orderEntity);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderEntity -> orderConverter.toDto(orderEntity))
                .collect(Collectors.toList());
    }

    public Long deleteOrderById(Long orderId) {
        orderRepository.findById(orderId).orElseThrow(
                ()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Brak szukanego id"));
        orderRepository.deleteById(orderId);
        return orderId;
    }

    @Transactional
    public OrderResponse updateOrder(Long orderId, OrderRequest orderRequest){

        OrderEntity orderToChange = orderRepository.findById(orderId)
                .orElseThrow(()->new RuntimeException());
        orderToChange.setOrderType(orderRequest.getOrderType());
        //orderToChange.setOrderedPizza(orderRequest.getOrderedPizza());

        return orderConverter.toDto(orderToChange);
    }


}
