package com.example.restaurant_app.model.dao.order;

import com.example.restaurant_app.model.dao.users.UserEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deliveryType;
    private String name;
    private String surname;
    private String street;
    private String streetNumber;
    private String City;
    private String postalCode;
    private String phoneNumber;
    private Long price;

    @ManyToMany(cascade = CascadeType.ALL)
    List<OrderedPizzaEntity> orderedPizzas;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}