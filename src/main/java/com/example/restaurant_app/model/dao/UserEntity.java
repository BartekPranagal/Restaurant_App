package com.example.restaurant_app.model.dao;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Users")
@Data
public class UserEntity {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "adress")
    private String adress;

    @Column(name = "active")
    private Boolean isActive;

    //lista/enum? authorities?
    //lista ocen/komentarzy?
    //lista zamowien?
}
