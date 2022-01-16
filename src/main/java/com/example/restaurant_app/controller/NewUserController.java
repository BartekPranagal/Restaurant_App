package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dto.NewUserRequest;
import com.example.restaurant_app.model.dto.NewUserResponse;
import com.example.restaurant_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class NewUserController {

    private final UserService userService;

    @PostMapping
    public NewUserResponse addNewUser(@RequestBody NewUserRequest newUserRequest){
        return userService.addUser(newUserRequest);
    }


}
