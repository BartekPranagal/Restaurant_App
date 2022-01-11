package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dto.OrderRequest;
import com.example.restaurant_app.model.dto.OrderResponse;
import com.example.restaurant_app.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(path = "/placement")
    public OrderResponse addNewOrder(@RequestBody OrderRequest orderRequest) {
        return  orderService.createOrder(orderRequest);
    }

    @GetMapping(path = "/{id}")
    public OrderResponse getOrderById(@PathVariable(name = "id")Long orderId){
        return orderService.getById(orderId);
    }

    @GetMapping
    public List<OrderResponse> getAllOrders(){
        return orderService.getAllOrders();
    }

    @DeleteMapping(path = "/{id}")
    public Long deleteOrder(@PathVariable(name = "id") Long orderId){
        return orderService.deleteOrderById(orderId);
    }

    @PutMapping(path = "/{id}")
    public OrderResponse modifyOrder(@PathVariable(name = "id") Long orderId, @RequestBody OrderRequest orderRequest){
        return orderService.updateOrder(orderId,orderRequest);
    }


}
