package com.example.restaurant_app.model.dto;

import com.example.restaurant_app.model.dao.PizzaEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderResponse {

    private Long id;
    private OrderType orderType;
    private List<PizzaEntity> orderList;

}
