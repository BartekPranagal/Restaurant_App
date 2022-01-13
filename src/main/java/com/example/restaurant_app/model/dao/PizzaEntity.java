package com.example.restaurant_app.model.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Pizza")
@Data
public class PizzaEntity {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price")
    private Float price;

    @Column(name = "Sale")
    private Boolean isOnSale;

    @Column(name = "Vege")
    private  Boolean isVege;

}
