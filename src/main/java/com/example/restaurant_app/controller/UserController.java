package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dao.users.UserEntity;
import com.example.restaurant_app.model.dto.user.UserRequest;
import com.example.restaurant_app.model.dto.user.UserResponse;
import com.example.restaurant_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/addUser")
    public UserEntity saveUser(@RequestBody UserRequest user) {
        return userService.saveUser(user);
    }

    @RequestMapping(path = "editUser/{userId}", method = RequestMethod.PUT)
        public UserResponse updateUser(@RequestBody UserRequest request, @PathVariable Long userId){
        return userService.updateUser(userId, request);

    }
}
