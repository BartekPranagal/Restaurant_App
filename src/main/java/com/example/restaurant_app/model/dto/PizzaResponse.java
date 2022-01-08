package com.example.restaurant_app.model.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PizzaResponse {

    private Long id;
    private String name;
    private String description;
}
