package com.example.restaurant_app.service.converters;

import com.example.restaurant_app.model.dao.UserEntity;
import com.example.restaurant_app.model.dto.NewUserRequest;
import com.example.restaurant_app.model.dto.NewUserResponse;
import com.example.restaurant_app.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserConverter implements Convertable<NewUserRequest, UserEntity, NewUserResponse> {

    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;

    @Override
    public UserEntity fromDto(NewUserRequest newUserRequest) {
        UserEntity newUser = new UserEntity();
        newUser.setActive(true);

        newUser.setCity(newUserRequest.getCity());
        newUser.setPostalCode(newUserRequest.getPostalCode());
        newUser.setStreet(newUserRequest.getStreet());
        newUser.setStreetNumber(newUserRequest.getStreetNumber());
        newUser.setPhoneNumber(newUserRequest.getPhoneNumber());

        newUser.setUsername(newUserRequest.getUsername());
        newUser.setMail(newUserRequest.getMail());
        newUser.setLogin(newUserRequest.getUsername());
        newUser.setFirstName(newUserRequest.getName());
        newUser.setLastName(newUserRequest.getSurname());
        newUser.setPassword(passwordEncoder.encode(newUserRequest.getPassword()));
        newUser.setAuthorities(Collections.singletonList(authorityRepository
                .findByName("ROLE_USER").orElseThrow(() -> new RuntimeException())));
        return newUser;
    }

    @Override
    public NewUserResponse toDto(UserEntity userEntity) {

        return NewUserResponse.builder()
                .first_name(userEntity.getFirstName())
                .last_name(userEntity.getLastName())
                .mail(userEntity.getMail())
                .password(userEntity.getPassword())
                .city(userEntity.getCity())
                .phoneNumber(userEntity.getPhoneNumber())
                .postal_code(userEntity.getPostalCode())
                .street(userEntity.getStreet())
                .username(userEntity.getUsername())
                .street_number(userEntity.getStreetNumber())
                .build();
    }
}
