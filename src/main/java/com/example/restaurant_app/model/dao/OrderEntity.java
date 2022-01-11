package com.example.restaurant_app.model.dao;

import com.example.restaurant_app.model.dto.OrderType;
import lombok.Data;
import javax.persistence.*;
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

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "order_pizza",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id"))
    private List<PizzaEntity> orderedPizza;
}
