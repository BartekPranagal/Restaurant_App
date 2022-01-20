package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dao.order.OrderEntity;
import com.example.restaurant_app.model.dto.order.OrderRequest;
import com.example.restaurant_app.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(path = "/addOrder")
    public OrderEntity addOrder(@RequestBody OrderRequest order) {
        return orderService.saveOrder(order);
    }

}
