package com.example.restaurant_app.service;

import com.example.restaurant_app.model.dao.OrderEntity;
import com.example.restaurant_app.model.dao.PizzaEntity;
import com.example.restaurant_app.model.dto.OrderRequest;
import com.example.restaurant_app.model.dto.OrderResponse;
import com.example.restaurant_app.model.dto.PizzaResponse;
import com.example.restaurant_app.repository.OrderRepository;
import com.example.restaurant_app.repository.PizzaRepository;
import com.example.restaurant_app.service.converters.PizzaConverter;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final PizzaConverter pizzaConverter;
    private final OrderRepository orderRepository;

    public List<PizzaResponse> getMenu() {
        return pizzaRepository.findAll().stream()
                .map(pizzaEntity -> pizzaConverter.toDto(pizzaEntity))
                .collect(Collectors.toList());
    }

    public PizzaResponse getById(Long pizzaId) {
        PizzaEntity pizzaEntity = pizzaRepository.findById(pizzaId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,"brak szukanego id"));
        return pizzaConverter.toDto(pizzaEntity);
    }

    public List<PizzaResponse> getPizzaByQuery(String query){
        return Optional.ofNullable(query)
                .map(param -> pizzaRepository.searchByQuery(param))
                .orElse(pizzaRepository.findAll())
                .stream()
                .map(pizzaEntity -> pizzaConverter.toDto(pizzaEntity))
                .collect(Collectors.toList());
    }


}
