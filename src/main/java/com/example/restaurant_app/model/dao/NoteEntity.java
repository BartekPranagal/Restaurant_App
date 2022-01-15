package com.example.restaurant_app.model.dao;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;


@Entity
@Table(name = "notes")
@Data
public class NoteEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "ratio")
    private Integer ratio;

    @ManyToOne
    @JoinColumn(name = "pizzaId")
    private PizzaEntity pizza;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;



}
