package com.example.restaurant_app.model.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "orderedPizzas")
@Data
public class OrderedPizzaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Long pizzaId;
    String name;
    String size;
    Long price;
}
