package com.example.restaurant_app.repository;

import com.example.restaurant_app.model.dao.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {

}
