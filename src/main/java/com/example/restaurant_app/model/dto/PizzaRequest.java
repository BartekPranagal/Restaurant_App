package com.example.restaurant_app.model.dto;

import lombok.Data;

@Data
public class PizzaRequest {
    private String name;
    private String description;
    private Float smallPrice;
    private Float mediumPrice;
    private Float bigPrice;
}
