package com.example.restaurant_app.model.dto;

import com.example.restaurant_app.model.dao.PizzaEntity;
import com.example.restaurant_app.model.dao.UserEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteResponse {

    private Long id;
    private String comment;
    private Integer ratio;
    private String username;

}
