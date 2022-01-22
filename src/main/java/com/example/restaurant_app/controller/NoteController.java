package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dao.NoteEntity;
import com.example.restaurant_app.model.dto.NoteRequest;
import com.example.restaurant_app.model.dto.NoteResponse;
import com.example.restaurant_app.service.NoteService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NoteController {

    private final NoteService noteService;

    @GetMapping(path = "/getPizzaRating/{id}")
    public List<NoteResponse> getNotesForPizza(@PathVariable(name = "id")Long pizzaId) {
        return noteService.getNotesForPizza(pizzaId);
    }

    @PostMapping(path = "/addRating")
    public NoteResponse addNewComment(@RequestBody NoteRequest noteRequest, Principal principal) {
        return noteService.createNewComment(noteRequest,principal.getName());
    }

    @PutMapping(path = "/comments/{noteId}")
    public NoteResponse modifyNote(@PathVariable(name = "noteId") Long noteId,
                                   @RequestBody NoteRequest noteRequest, Principal principal){
        principal.getName(); //tutaj laduje id (w naszym przypadku mail) uzytkownika zalogowanego
        return noteService.updateNote(noteId,noteRequest);
    }

}
