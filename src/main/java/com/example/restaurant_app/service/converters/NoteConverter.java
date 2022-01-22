package com.example.restaurant_app.service.converters;


import com.example.restaurant_app.model.dao.NoteEntity;
import com.example.restaurant_app.model.dto.NoteRequest;
import com.example.restaurant_app.model.dto.NoteResponse;
import com.example.restaurant_app.repository.PizzaRepository;
import com.example.restaurant_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteConverter implements Convertable<NoteRequest, NoteEntity, NoteResponse>{

    private final PizzaRepository pizzaRepository;


    @Override
    public NoteEntity fromDto(NoteRequest noteRequest) {
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setComment(noteRequest.getContent());
        noteEntity.setPizza(pizzaRepository.findById(noteRequest.getPizzaId()).orElseThrow(RuntimeException::new));
        noteEntity.setRatio(noteRequest.getGrade());
        return noteEntity;
    }

    @Override
    public NoteResponse toDto(NoteEntity noteEntity) {
        System.out.println(noteEntity.toString());
        return NoteResponse.builder()
                .id(noteEntity.getId())
                .comment(noteEntity.getComment())
                .ratio(noteEntity.getRatio())
                .username(noteEntity.getUser().getUsername())
                .build();
    }
}
