package com.example.restaurant_app.service;

import com.example.restaurant_app.model.dao.NoteEntity;
import com.example.restaurant_app.model.dto.NoteRequest;
import com.example.restaurant_app.model.dto.NoteResponse;
import com.example.restaurant_app.repository.NoteRepository;
import com.example.restaurant_app.repository.UserRepository;
import com.example.restaurant_app.service.converters.NoteConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteConverter noteConverter;
    private final UserRepository userRepository;

    public List<NoteResponse> getNotesForPizza(Long pizzaId) {
        return noteRepository.findAllByPizzaId(pizzaId).orElseThrow(RuntimeException::new).stream()
                .map(noteEntity -> noteConverter.toDto(noteEntity))
                .collect(Collectors.toList());
    }

    public NoteResponse createNewComment(NoteRequest noteRequest, String username ) {
        NoteEntity entityToAdd = noteConverter.fromDto(noteRequest);
        entityToAdd.setUser(userRepository.findByMail(username).orElseThrow(RuntimeException::new));
        NoteEntity savedNote = noteRepository.save(entityToAdd);
        return noteConverter.toDto(entityToAdd);
    }

    public NoteResponse updateNote(Long noteId, NoteRequest noteRequest) {
        NoteEntity noteToChange = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Element o podanym ID nie istneiej"));
        noteToChange.setRatio(noteRequest.getGrade());
        noteToChange.setComment(noteRequest.getContent());

        return noteConverter.toDto(noteToChange);
    }
}
