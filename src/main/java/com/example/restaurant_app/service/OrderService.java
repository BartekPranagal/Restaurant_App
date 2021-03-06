package com.example.restaurant_app.service;

import com.example.restaurant_app.model.dao.order.OrderEntity;
import com.example.restaurant_app.model.dao.order.OrderedPizzaEntity;
import com.example.restaurant_app.model.dao.users.UserEntity;
import com.example.restaurant_app.model.dto.order.OrderRequest;
import com.example.restaurant_app.model.dto.order.OrderedPizza;
import com.example.restaurant_app.repository.OrderRepository;
import com.example.restaurant_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;


    public OrderEntity saveOrder(OrderRequest orderRequest) {

        Double price = 0.0;

        UserEntity user = userRepository.findByUsername(orderRequest.getUsername())
                .orElseThrow(() -> new RuntimeException());

        for (OrderedPizza el: orderRequest.getPizzaList()) {
            price += el.getPrice();
        }

        if(LocalDate.now().getDayOfWeek().name().equalsIgnoreCase("Tuesday")) {
            price*=0.8;
        }

        if(LocalDate.now().getDayOfWeek().name().equalsIgnoreCase("Thursday")) {
            price*=0.9;
        }


        List<OrderedPizzaEntity> orderedPizzas = orderRequest.getPizzaList().stream()
                .map(x -> {
                    OrderedPizzaEntity orderedPizzaEntity = new OrderedPizzaEntity();
                    orderedPizzaEntity.setPizzaId(x.getPizzaId());
                    orderedPizzaEntity.setName(x.getName());
                    orderedPizzaEntity.setSize(x.getSize());
                    orderedPizzaEntity.setPrice(x.getPrice());
                    return orderedPizzaEntity;
                }).collect(Collectors.toList());

        OrderEntity order = new OrderEntity();
        order.setOrderedPizzas(orderedPizzas);
        order.setDeliveryType(orderRequest.getOrderType());
        order.setName(user.getName());
        order.setSurname(user.getSurname());
        order.setStreet(user.getStreet());
        order.setStreetNumber(user.getStreetNumber());
        order.setCity(user.getCity());
        order.setPostalCode(user.getPostalCode());
        order.setPhoneNumber(user.getPhoneNumber());
        order.setPrice(price);
        order.setUser(user);

        return orderRepository.save(order);
    }

    public List<OrderEntity> getOrderHistoryFromUser(String name) {
        UserEntity user = userRepository.findByUsername(name).orElseThrow(RuntimeException::new);
        return orderRepository.findByUser(user).orElseThrow();
    }

    public List<OrderEntity> getOrderHistory() {
        return orderRepository.findAll();
    }
}
