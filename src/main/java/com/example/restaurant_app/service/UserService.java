package com.example.restaurant_app.service;

import com.example.restaurant_app.model.dao.UserEntity;
import com.example.restaurant_app.model.dto.NewUserRequest;
import com.example.restaurant_app.model.dto.NewUserResponse;
import com.example.restaurant_app.repository.AuthorityRepository;
import com.example.restaurant_app.repository.UserRepository;
import com.example.restaurant_app.service.converters.NewUserConverter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {
    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private PasswordEncoder passwordEncoder;
    private NewUserConverter  newUserConverter;

    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository,
                       PasswordEncoder passwordEncoder, NewUserConverter newUserConverter) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
        this.newUserConverter = newUserConverter;
    }

    public NewUserResponse addUser(NewUserRequest newUserRequest){
        UserEntity userToAdd = newUserConverter.fromDto(newUserRequest);
        UserEntity savedUser = userRepository.save(userToAdd);

        return newUserConverter.toDto(savedUser);
    }


    public void getUserByLogin(String userName) {

    }

}
