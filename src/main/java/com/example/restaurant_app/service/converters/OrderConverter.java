package com.example.restaurant_app.service.converters;

import com.example.restaurant_app.model.dao.OrderEntity;
import com.example.restaurant_app.model.dao.PizzaEntity;
import com.example.restaurant_app.model.dto.Item;
import com.example.restaurant_app.model.dto.OrderRequest;
import com.example.restaurant_app.model.dto.OrderResponse;
import com.example.restaurant_app.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderConverter implements Convertable<OrderRequest, OrderEntity, OrderResponse> {

    private final PizzaRepository pizzaRepository;

    @Override
    public OrderEntity fromDto(OrderRequest request) {

        OrderEntity result = new OrderEntity();
        result.setOrderType(request.getOrderType());
        List<PizzaEntity> cart = new ArrayList<>();
        float price = 0.0F;
        request.getCart()
                .forEach(item -> cart.add(pizzaRepository.findById(item.getId()).orElseThrow(RuntimeException::new)));
        result.setOrderedPizza(cart);

        for(Item item : request.getCart()) {
            price += pizzaRepository.findById(item.getId()).orElseThrow(RuntimeException::new).getPriceBySize(item.getSize());
            System.out.println("zliczam" + price);
        }
        result.setTotalPrice(price);
        return result;
    }

    @Override
    public OrderResponse toDto(OrderEntity orderEntity) {
        return OrderResponse.builder()
                .id(orderEntity.getId())
                .orderType(orderEntity.getOrderType())
                .orderList(orderEntity.getOrderedPizza())
                .totalPrice(orderEntity.getTotalPrice())
                .build();
    }

}
