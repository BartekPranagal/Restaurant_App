package com.example.restaurant_app.model.dto;

import com.example.restaurant_app.model.dao.AuthorityEntity;
import lombok.Data;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class NewUserRequest {
    @NotEmpty(message = "To pole nie może być puste!")
    private String mail;

    @NotEmpty(message = "To pole nie może być puste!")
    private String password;

    @NotEmpty(message = "To pole nie może być puste!")
    private String first_name;

    @NotEmpty(message = "To pole nie może być puste!")
    private String last_name;

    @NotEmpty(message = "To pole nie może być puste!")
    private  String login;

    @NotEmpty(message = "To pole nie może być puste!")
    private String street;

    @NotEmpty(message = "To pole nie może być puste!")
    private String street_number;

    @NotEmpty(message = "To pole nie może być puste!")
    private String postal_code;

    @NotEmpty(message = "To pole nie może być puste!")
    private String city;

    @NotEmpty(message = "To pole nie może być puste!")
    private Integer phoneNumber;

    @NotEmpty(message = "To pole nie może być puste!")
    private boolean isActive;


    List<AuthorityEntity> authority;




}
// mail, haslo, nazwa uzytkownika, imie nazwisko, adres.