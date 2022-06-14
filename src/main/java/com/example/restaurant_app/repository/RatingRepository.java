package com.example.restaurant_app.repository;

import com.example.restaurant_app.model.dao.rating.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<RatingEntity, Long> {

    List<RatingEntity> findByPizzaId(Long pizzaId);

}
