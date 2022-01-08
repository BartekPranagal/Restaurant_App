package com.example.restaurant_app.repository;

import com.example.restaurant_app.model.dao.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository  extends JpaRepository<PizzaEntity, Long> {

    @Query("select pizza from PizzaEntity pizza " +
            "where pizza.name like %:query% ")
    List<PizzaEntity> searchByQuery(String query);
}
