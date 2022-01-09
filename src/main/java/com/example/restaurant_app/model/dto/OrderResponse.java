package com.example.restaurant_app.model.dto;

import com.example.restaurant_app.model.dao.OrderType;
import com.example.restaurant_app.model.dao.PizzaEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class OrderResponse {

    private Long id;
    private OrderType orderType;
    private List<PizzaEntity> orderList;
}
