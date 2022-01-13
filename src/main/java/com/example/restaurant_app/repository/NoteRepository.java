package com.example.restaurant_app.repository;

import com.example.restaurant_app.model.dao.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface NoteRepository extends JpaRepository<NoteEntity,Long> {

}
