package com.example.restaurant_app.service;

import com.example.restaurant_app.model.dao.UserEntity;

public interface UserService {

    public void saveUser(UserEntity user);

    public boolean isUserAlreadyPresent(UserEntity user);
}