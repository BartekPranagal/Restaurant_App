package com.example.restaurant_app.service.converters;


import com.example.restaurant_app.model.dao.NoteEntity;
import com.example.restaurant_app.model.dto.NoteRequest;
import com.example.restaurant_app.model.dto.NoteResponse;
import org.springframework.stereotype.Service;

@Service
public class NoteConverter implements Convertable<NoteRequest, NoteEntity, NoteResponse>{
    @Override
    public NoteEntity fromDto(NoteRequest noteRequest) {
        NoteEntity noteEntity = new NoteEntity();
//        noteEntity.setUser(noteRequest.getUser());
        noteEntity.setComment(noteRequest.getComment());
//        noteEntity.setPizza(noteRequest.getPizza());
        noteEntity.setRatio(noteRequest.getRatio());

        return noteEntity;
    }

    @Override
    public NoteResponse toDto(NoteEntity noteEntity) {
        return NoteResponse.builder()
                .id(noteEntity.getId())
                .comment(noteEntity.getComment())
                .ratio(noteEntity.getRatio())
                .build();
    }
}
