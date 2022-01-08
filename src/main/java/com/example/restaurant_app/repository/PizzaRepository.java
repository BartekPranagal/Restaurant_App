package com.example.restaurant_app.repository;

import com.example.restaurant_app.model.dao.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository  extends JpaRepository<PizzaEntity, Long> {
}
