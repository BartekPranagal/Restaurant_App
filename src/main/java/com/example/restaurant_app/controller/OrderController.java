package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dao.order.OrderEntity;
import com.example.restaurant_app.model.dto.order.OrderRequest;
import com.example.restaurant_app.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(path = "/addOrder")
    public void addOrder(@RequestBody OrderRequest order) {
        orderService.saveOrder(order);
    }

    @Transactional
    @GetMapping(path = "/orders")
    public List<OrderEntity> getOrdersByUsername(Principal principal){
        return orderService.getOrderHistoryFromUser(principal.getName());
    }

    @GetMapping(path = "/allOrders")
    public List<OrderEntity> getAllOrders(){
        return orderService.getOrderHistory();
    }



}
