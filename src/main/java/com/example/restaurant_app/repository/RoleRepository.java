package com.example.restaurant_app.repository;

import com.example.restaurant_app.model.dao.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    public RoleEntity findByRole(String role);
}