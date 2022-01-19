package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dto.LoginUserRequest;
import com.example.restaurant_app.model.dto.NewUserRequest;
import com.example.restaurant_app.model.dto.NewUserResponse;
import com.example.restaurant_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Transactional
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/api/register")
    public NewUserResponse createNewUser(@RequestBody NewUserRequest userRequest){
        return userService.addUser(userRequest);
    }

    //getAllUsers
    //activateUser
    //deactivateUser
    //changepassword
    //deleteuser
    @PostMapping(path = "/api/login")
    public void login(@RequestBody LoginUserRequest user){
    }
}
