package com.example.restaurant_app.model.dto.pizza;

import lombok.Data;

@Data
public class PizzaRequest {

    private String name;
    private String description;
    private Double smallPrice;
    private Double mediumPrice;
    private Double bigPrice;
}
