package com.example.restaurant_app.model.dao;

import lombok.Data;
import org.springframework.context.support.BeanDefinitionDsl;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "auth_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auth_user_id")
    private int id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "status")
    private String status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
    private Set<RoleEntity> roles;
    //lista/enum? authorities?
    //lista ocen/komentarzy?
    //lista zamowien?
}
