package com.example.restaurant_app.model.dto;

import lombok.Data;

@Data
public class LoginUserRequest {

    private String login;
    private String password;
}
