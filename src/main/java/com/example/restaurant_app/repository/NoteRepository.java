package com.example.restaurant_app.repository;

import com.example.restaurant_app.model.dao.NoteEntity;
import com.example.restaurant_app.model.dto.NoteResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteRepository extends JpaRepository<NoteEntity,Long> {


    List<NoteEntity> findAllByPizzaId(Long pizzaId);

}
