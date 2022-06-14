package com.example.restaurant_app.model.dao.order;

import com.example.restaurant_app.model.dao.Idenficable;
import com.example.restaurant_app.model.dao.PizzaEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "orderedPizza")
@Data
public class OrderedPizzaEntity implements Idenficable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    PizzaEntity pizza;
    String name;
    String size;
    Double price;
}
