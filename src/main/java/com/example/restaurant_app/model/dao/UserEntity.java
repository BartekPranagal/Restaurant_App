package com.example.restaurant_app.model.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "city")
    private String city;

    @Column(name = "password")
    private String password;

    @Column(name = "adress")
    private String adress;

    @Column(name = "street")
    private String street;

    @Column(name = "street_number")
    private String street_number;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "phonenumber")
    private Integer phoneNumber;

    @Column(name = "active")
    private boolean isActive;

    @ManyToMany
    List<AuthorityEntity> authorities;


//    @OneToMany(mappedBy = "owner")
//    List<OrderEntity> orderEntityList;


    //lista/enum? authorities?
    //lista ocen/komentarzy?
    //lista zamowien?
}
