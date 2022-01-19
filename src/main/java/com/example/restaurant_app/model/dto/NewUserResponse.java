package com.example.restaurant_app.model.dto;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class NewUserResponse {

    private String mail;
    private String password;
    private String first_name;
    private String last_name;
    private String username;
    private String street;
    private Integer street_number;
    private String postal_code;
    private String city;
    private Integer phoneNumber;

}
