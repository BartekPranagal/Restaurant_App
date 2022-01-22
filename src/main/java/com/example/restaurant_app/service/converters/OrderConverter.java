package com.example.restaurant_app.service.converters;

import com.example.restaurant_app.model.dao.OrderEntity;
import com.example.restaurant_app.model.dao.OrderedPizzaEntity;
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
        List<PizzaEntity> cart = new ArrayList<>();


        result.setOrderType(request.getOrderType());
        request.getPizzaList()
                .forEach(item -> {

                    PizzaEntity e = pizzaRepository.findById(item.getPizzaId()).orElseThrow(RuntimeException::new);
                    cart.add(e);
                    result.setTotalPrice(result.getTotalPrice()+e.getPriceBySize(item.getSize()));//zaokrąglić

                });
        result.setOrderedPizza(cart);

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
