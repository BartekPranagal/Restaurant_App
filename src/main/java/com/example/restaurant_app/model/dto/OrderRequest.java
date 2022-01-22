package com.example.restaurant_app.model.dto;

import com.example.restaurant_app.model.dao.OrderedPizzaEntity;
import com.example.restaurant_app.model.dao.PizzaEntity;
import lombok.Data;

import java.util.List;


@Data
public class OrderRequest {
    
    private OrderType orderType;
    //private List<PizzaEntity> orderedPizza;// id pizzy i w serwisie je wyciągąć z repoPizzy z walidacją czy pizza znajduje sie w menu
    private List<OrderedPizzaEntity> pizzaList;
}
