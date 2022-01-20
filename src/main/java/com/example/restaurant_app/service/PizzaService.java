package com.example.restaurant_app.service;

import com.example.restaurant_app.model.dto.pizza.PizzaResponse;
import com.example.restaurant_app.repository.PizzaRepository;
import com.example.restaurant_app.service.converters.PizzaConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaConverter pizzaConverter;

    public List<PizzaResponse> getMenu(String query) {
        return pizzaRepository.searchByQuery(query).stream()
                .map(pizzaEntity -> pizzaConverter.toDto(pizzaEntity))
                .collect(Collectors.toList());
    }
}
