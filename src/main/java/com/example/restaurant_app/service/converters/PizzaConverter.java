package com.example.restaurant_app.service.converters;

import com.example.restaurant_app.model.dao.PizzaEntity;
import com.example.restaurant_app.model.dto.PizzaRequest;
import com.example.restaurant_app.model.dto.PizzaResponse;
import org.springframework.stereotype.Service;

@Service
public class PizzaConverter implements Convertable<PizzaRequest, PizzaEntity, PizzaResponse> {

    @Override
    public PizzaEntity fromDto(PizzaRequest request) {
        PizzaEntity pizzaEntity = new PizzaEntity();
        pizzaEntity.setName(request.getName());
        pizzaEntity.setDescription(request.getDescription());
        pizzaEntity.setSmallPrice(request.getSmallPrice());
        pizzaEntity.setMediumPrice(request.getMediumPrice());
        pizzaEntity.setBigPrice(request.getBigPrice());
        return pizzaEntity;
    }

    @Override
    public PizzaResponse toDto(PizzaEntity pizzaEntity) {
        return PizzaResponse.builder()
                .id(pizzaEntity.getId())
                .name(pizzaEntity.getName())
                .description(pizzaEntity.getDescription())
                .smallPrice(pizzaEntity.getSmallPrice())
                .mediumPrice(pizzaEntity.getMediumPrice())
                .bigPrice(pizzaEntity.getBigPrice())
                .build();
    }
}
