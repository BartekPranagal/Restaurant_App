package com.example.restaurant_app.service;

import java.util.Arrays;
import java.util.HashSet;

import com.example.restaurant_app.model.dao.RoleEntity;
import com.example.restaurant_app.model.dao.UserEntity;
import com.example.restaurant_app.repository.RoleRepository;
import com.example.restaurant_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImp implements UserService {

    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(UserEntity user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatus("VERIFIED");
        RoleEntity userRole = roleRepository.findByRole("SITE_USER");
        user.setRoles(new HashSet<RoleEntity>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public boolean isUserAlreadyPresent(UserEntity user) {
        // Try to implement this method, as assignment.
        return false;
    }

}