package com.example.restaurant_app.service;

import com.example.restaurant_app.model.dao.UserEntity;
import com.example.restaurant_app.model.dto.NewUserRequest;
import com.example.restaurant_app.repository.AuthorityRepository;
import com.example.restaurant_app.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {
    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(NewUserRequest newUserRequest){
        UserEntity newUser = new UserEntity();
        newUser.setMail(newUserRequest.getMail());
        newUser.setPassword(passwordEncoder.encode(newUserRequest.getPassword()));
        newUser.setActive(true);
        newUser.setAuthorities(Collections.singletonList(authorityRepository.getById(1L)));
        userRepository.save(newUser);
    }

    public void getUserByLogin(String userName) {

    }

}
