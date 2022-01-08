package com.example.restaurant_app.service;

import com.example.restaurant_app.model.dto.PizzaResponse;
import com.example.restaurant_app.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public List<PizzaResponse> getMenu() {
        pizzaRepository.findAll().stream()
                .map()
    }

    private
}
