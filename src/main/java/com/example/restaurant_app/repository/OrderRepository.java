package com.example.restaurant_app.repository;

import com.example.restaurant_app.model.dao.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
