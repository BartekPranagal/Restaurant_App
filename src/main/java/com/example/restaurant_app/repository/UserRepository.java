package com.example.restaurant_app.repository;



import com.example.restaurant_app.model.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}