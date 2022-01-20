package com.example.restaurant_app.model.dao.users;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String phoneNumber;
    private String mail;
    private String name;
    private String surname;
    private String street;
    private String streetNumber;
    private String city;
    private String postalCode;
    private boolean active;

    @ManyToMany
    List<AuthorityEntity> authorities;
}
