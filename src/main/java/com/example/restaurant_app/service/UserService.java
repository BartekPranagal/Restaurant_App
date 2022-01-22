package com.example.restaurant_app.service;

import com.example.restaurant_app.model.dao.UserEntity;
import com.example.restaurant_app.model.dto.NewUserRequest;
import com.example.restaurant_app.model.dto.NewUserResponse;
import com.example.restaurant_app.repository.AuthorityRepository;
import com.example.restaurant_app.repository.UserRepository;
import com.example.restaurant_app.service.converters.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserConverter userConverter;



    public NewUserResponse addUser(NewUserRequest newUserRequest){
        UserEntity newUser = userConverter.fromDto(newUserRequest);
        UserEntity registeredUser = userRepository.save(newUser);
//        newUser.setMail(newUserRequest.getMail());
//        newUser.setPassword(passwordEncoder.encode(newUserRequest.getPassword()));
//        newUser.setActive(true);
//        newUser.setAuthorities(Collections.singletonList(authorityRepository.getById(1L)));
//        userRepository.save(newUser);
        return userConverter.toDto(newUser);
    }

    public void getUserByLogin(String userName) {

    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}
