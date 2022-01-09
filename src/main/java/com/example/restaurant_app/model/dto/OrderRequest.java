package com.example.restaurant_app.model.dto;

import com.example.restaurant_app.model.dao.OrderType;
import lombok.Data;


@Data
public class OrderRequest {
    
    private OrderType orderType;
    private Long pizzaId;
}
