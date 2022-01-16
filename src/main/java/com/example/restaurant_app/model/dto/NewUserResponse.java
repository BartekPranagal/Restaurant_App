package com.example.restaurant_app.model.dto;

import com.example.restaurant_app.model.dao.AuthorityEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class NewUserResponse {

    private Long id;
    private String mail;
    private String password;
    private String first_name;
    private String last_name;
    private  String login;
    private String street;
    private String street_number;
    private String postal_code;
    private String city;
    private Integer phoneNumber;
    private boolean isActive;
    List<AuthorityEntity> authority;
}
