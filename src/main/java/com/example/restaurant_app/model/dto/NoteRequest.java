package com.example.restaurant_app.model.dto;

import com.example.restaurant_app.model.dao.PizzaEntity;
import com.example.restaurant_app.model.dao.UserEntity;
import lombok.Data;

@Data
public class NoteRequest {

    private String comment;
    private Integer ratio;
//    private PizzaEntity pizza;
//    private UserEntity user;

}
