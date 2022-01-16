package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dto.NewUserRequest;
import com.example.restaurant_app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class MvcUserController {

    private UserService userService;

    public MvcUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/mvc/create-user")
    public String createUserForm(Model model, Principal principal){
        model.addAttribute("message", "user: " + principal.getName());
        model.addAttribute("newUserRequest", new NewUserRequest());
        return "create-user";
    }

    @PostMapping("/mvc/create-user")
    public String createUser(@Valid @ModelAttribute NewUserRequest newUserRequest,
                             BindingResult errors){
        if(errors.hasErrors()){
            return "create-user";
        } else {
            userService.addUser(newUserRequest);
            return "user-created";
        }
    }
}
