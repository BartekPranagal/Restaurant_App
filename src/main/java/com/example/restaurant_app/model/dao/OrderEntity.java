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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "order_pizza",
            joinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "order_id",
                    referencedColumnName = "id"))
    private List<PizzaEntity> orderedPizza;

//    @OneToMany(fetch = FetchType.EAGER,mappedBy = "order")
//    private List<PizzaEntity> orderedPizza = new ArrayList<>();

}
