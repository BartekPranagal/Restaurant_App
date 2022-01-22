package com.example.restaurant_app.service.converters;

import com.example.restaurant_app.model.dao.users.UserEntity;
import com.example.restaurant_app.model.dto.user.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {
    public UserResponse convertUserEntityToDto(UserEntity entity){
        return UserResponse.builder()
                .name(entity.getName())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .phoneNumber(entity.getPhoneNumber())
                .mail(entity.getMail())
                .surname(entity.getSurname())
                .street(entity.getStreet())
                .streetNumber(entity.getStreetNumber())
                .city(entity.getCity())
                .postalCode(entity.getPostalCode())
                .id(entity.getId())
                .build();
    }
}
