package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dao.OrderEntity;
import com.example.restaurant_app.model.dto.OrderRequest;
import com.example.restaurant_app.model.dto.OrderResponse;
import com.example.restaurant_app.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(path = "/placement")
    public OrderResponse addNewOrder(@RequestBody OrderRequest orderRequest) {
        return  orderService.createOrder(orderRequest);
    }


}
