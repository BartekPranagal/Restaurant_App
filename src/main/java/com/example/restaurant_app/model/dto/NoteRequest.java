package com.example.restaurant_app.model.dto;

import com.example.restaurant_app.model.dao.PizzaEntity;
import com.example.restaurant_app.model.dao.UserEntity;
import lombok.Data;

@Data
public class NoteRequest {

    private String content;
    private Integer grade;
    private Long pizzaId;
    private String username;

}
