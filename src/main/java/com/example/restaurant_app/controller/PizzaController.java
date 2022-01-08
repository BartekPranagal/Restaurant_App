package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dto.PizzaResponse;
import com.example.restaurant_app.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping(path = "/menu")
    public List<PizzaResponse> getMenu(){
        return pizzaService.getMenu();
    }

    @GetMapping(path = "/menu/{id}")
    public PizzaResponse getPizzaById(@PathVariable(name = "id") Long pizzaId){
        return pizzaService.getById(pizzaId);
    }

}
