package com.example.restaurant_app.model.dao;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class OrderEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //user_id

    @Column(name = "orderType")
    private OrderType orderType;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "order")
    private List<PizzaEntity> orderedPizza = new ArrayList<>();

}
