package com.example.restaurant_app.service.converters;

public interface Convertable <DTO_INPUT, ENTITY, DTO_OUTPUT> {

    ENTITY fromDto(DTO_INPUT input);

    DTO_OUTPUT toDto(ENTITY entity);
}
