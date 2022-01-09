package com.example.restaurant_app.model.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Pizza")
@Data
public class PizzaEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
//    private OrderEntity order;
}
