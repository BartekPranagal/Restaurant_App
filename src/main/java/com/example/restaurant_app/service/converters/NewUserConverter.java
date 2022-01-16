package com.example.restaurant_app.service.converters;

import com.example.restaurant_app.model.dao.UserEntity;
import com.example.restaurant_app.model.dto.NewUserRequest;
import com.example.restaurant_app.model.dto.NewUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewUserConverter implements Convertable<NewUserRequest, UserEntity,NewUserResponse> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity fromDto(NewUserRequest newUserRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setMail(newUserRequest.getMail());
        userEntity.setPassword(passwordEncoder.encode(newUserRequest.getPassword()));
        userEntity.setLogin(newUserRequest.getLogin());
        userEntity.setFirstName(newUserRequest.getFirst_name());
        userEntity.setLastName(newUserRequest.getLast_name());
        userEntity.setCity(newUserRequest.getCity());
        userEntity.setStreet(newUserRequest.getStreet());
        userEntity.setStreet_number(newUserRequest.getStreet_number());
        userEntity.setPostal_code(newUserRequest.getPostal_code());
        userEntity.setPhoneNumber(newUserRequest.getPhoneNumber());
        userEntity.setActive(newUserRequest.isActive());
        userEntity.setAuthorities(newUserRequest.getAuthority());
        return userEntity;
    }

    @Override
    public NewUserResponse toDto(UserEntity userEntity) {
        return NewUserResponse.builder()
                .id(userEntity.getId())
                .mail(userEntity.getMail())
                .password(userEntity.getPassword())
                .first_name(userEntity.getFirstName())
                .last_name(userEntity.getLastName())
                .login(userEntity.getLogin())
                .street(userEntity.getStreet())
                .street_number(userEntity.getStreet_number())
                .postal_code(userEntity.getPostal_code())
                .city(userEntity.getCity())
                .phoneNumber(userEntity.getPhoneNumber())
                .isActive(userEntity.isActive())
                .authority(userEntity.getAuthorities())
                .build();
    }
}
