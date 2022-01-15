package com.example.restaurant_app.model.dao;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "auth_role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auth_role_id")
    private int id;

    @Column(name = "role_name")
    private String role;

    @Column(name = "role_desc")
    private String desc;




}
