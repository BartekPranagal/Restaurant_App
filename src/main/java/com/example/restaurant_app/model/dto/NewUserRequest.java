package com.example.restaurant_app.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class NewUserRequest {
    @NotEmpty
    private String mail;

    @NotEmpty
    private String password;
}
