package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dto.pizza.PizzaResponse;
import com.example.restaurant_app.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping(path = "/menu")
    public List<PizzaResponse> getDynamicPizzaName(@RequestParam(required = false) String query){
        return pizzaService.getMenu(query);
    }
}
