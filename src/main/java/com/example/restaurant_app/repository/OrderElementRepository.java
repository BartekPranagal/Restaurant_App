package com.example.restaurant_app.repository;

import com.example.restaurant_app.model.dao.order.OrderedPizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderElementRepository extends JpaRepository<OrderedPizzaEntity, Long> {
}
