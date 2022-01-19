package com.example.restaurant_app.repository;

import com.example.restaurant_app.model.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    @Query("select user from UserEntity user where user.username = ?1 or user.mail = ?1")
    Optional<UserEntity> findByNicknameOrMail(String username);
}
