package com.example.restaurant_app.model.dto;

import com.example.restaurant_app.model.dao.PizzaEntity;
import lombok.Data;

import java.util.List;


@Data
public class OrderRequest {
    
    private OrderType orderType;
    private List<PizzaEntity> orderedPizza;

}
