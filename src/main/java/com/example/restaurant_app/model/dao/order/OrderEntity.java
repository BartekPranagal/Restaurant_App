package com.example.restaurant_app.model.dao.order;

import com.example.restaurant_app.model.dao.Idenficable;
import com.example.restaurant_app.model.dao.users.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity implements Idenficable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deliveryType;
    private String name;
    private String surname;
    private String street;
    private String streetNumber;
    private String city;
    private String postalCode;
    private String phoneNumber;
    private Double price;

    @ManyToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    List<OrderedPizzaEntity> orderedPizzas;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
