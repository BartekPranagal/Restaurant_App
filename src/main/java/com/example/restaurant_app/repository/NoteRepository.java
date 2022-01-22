package com.example.restaurant_app.repository;

import com.example.restaurant_app.model.dao.NoteEntity;
import com.example.restaurant_app.model.dto.NoteResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface NoteRepository extends JpaRepository<NoteEntity,Long> {


    Optional<List<NoteEntity>> findAllByPizzaId(Long pizzaId);

}
