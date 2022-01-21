package com.example.restaurant_app.model.dto;

import lombok.Data;
import org.springframework.data.repository.NoRepositoryBean;

import javax.validation.constraints.NotEmpty;

@Data
public class NewUserRequest {
    @NotEmpty
    private String mail;

    @NotEmpty
    private String password;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @NotEmpty
    private  String username;

    @NotEmpty
    private String street;

    @NotEmpty
    private String streetNumber;

    @NotEmpty
    private String postalCode;

    @NotEmpty
    private String city;

    @NotEmpty
    private String phoneNumber;




}
