package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dao.users.UserEntity;
import com.example.restaurant_app.model.dto.user.UserRequest;
import com.example.restaurant_app.model.dto.user.UserResponse;
import com.example.restaurant_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public UserEntity saveUser(@RequestBody UserRequest user) {
        return userService.saveUser(user);
    }

    @PutMapping(path = "/{userId}")
    public UserResponse updateUser(@RequestBody UserRequest request, @PathVariable Long userId, Principal principal) {
        return userService.updateUser(principal.getName(), userId, request);
    }

    @GetMapping("/current")
    public UserEntity currentUser(Principal principal) {
        return userService.getUser(principal.getName());
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
