package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dto.PizzaRequest;
import com.example.restaurant_app.model.dto.PizzaResponse;
import com.example.restaurant_app.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
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

//    @GetMapping(path = "/menu")
//    public List<PizzaResponse> getDynamicPizzaName(@RequestParam(required = false) String query){
//        return pizzaService.getPizzaByQuery(query);
//    }

    @DeleteMapping(path = "menu/{id}")
    public Long deletePizza(@PathVariable(name = "id") Long pizzaId){
        return pizzaService.deletePizza(pizzaId);
    }

    @PostMapping(path = "/menu")
    public PizzaResponse addNewPizza(@RequestBody PizzaRequest pizzaRequest){
        return pizzaService.createNewPizza(pizzaRequest);
    }

    @PutMapping(path = "/{id}")
    public PizzaResponse modifyPizza(@PathVariable(name = "id") Long pizzaId,@RequestBody PizzaRequest pizzaRequest){
        return pizzaService.updatePizza(pizzaId,pizzaRequest);
    }



}
