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
    private String first_name;

    @NotEmpty
    private String last_name;

    @NotEmpty
    private  String username;

    @NotEmpty
    private String street;

    @NotEmpty
    private Integer street_number;

    @NotEmpty
    private String postal_code;

    @NotEmpty
    private Integer phoneNumber;




}
// mail, haslo, nazwa uzytkownika, imie nazwisko, adres.