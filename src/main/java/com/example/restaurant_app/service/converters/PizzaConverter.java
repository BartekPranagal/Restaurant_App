package com.example.restaurant_app.service.converters;

import com.example.restaurant_app.model.dao.PizzaEntity;
import com.example.restaurant_app.model.dto.PizzaResponse;

public class PizzaConverter implements Convertable<Object, PizzaEntity, PizzaResponse> {
    @Override
    public PizzaEntity fromDto(Object o) {
        return null;
    }

    @Override
    public PizzaResponse toDto(PizzaEntity pizzaEntity) {
        return PizzaResponse.builder()
                .id(pizzaEntity.getId())
                .name(pizzaEntity.getName())
                .description(pizzaEntity.getDescription())
                .build();
    }
}
