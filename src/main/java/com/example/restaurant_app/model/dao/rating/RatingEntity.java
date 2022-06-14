package com.example.restaurant_app.model.dao.rating;

import com.example.restaurant_app.model.dao.Idenficable;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
@Data
public class RatingEntity implements Idenficable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pizzaId;
    private Long grade;
    private String content;
    private String user;

}
