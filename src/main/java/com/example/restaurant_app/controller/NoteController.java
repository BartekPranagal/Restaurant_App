package com.example.restaurant_app.controller;

import com.example.restaurant_app.model.dao.NoteEntity;
import com.example.restaurant_app.model.dto.NoteRequest;
import com.example.restaurant_app.model.dto.NoteResponse;
import com.example.restaurant_app.service.NoteService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menu/{id}")
public class NoteController {

    private final NoteService noteService;

    @GetMapping(path = "/comments")
    public List<NoteResponse> getNotesForPizza(@PathVariable(name = "id")Long pizzaId) {
        return noteService.getNotesForPizza(pizzaId);
    }

    @PostMapping(path = "/comments")
    public NoteResponse addNewComment(@PathVariable(name = "id")Long pizzaId, @RequestBody NoteRequest noteRequest ) {
        return noteService.createNewComment(pizzaId,noteRequest);
    }

    @PutMapping(path = "/comments/{noteId}")
    public NoteResponse modifyNote(@PathVariable(name = "id") Long pizzaId,@PathVariable(name = "noteId") Long noteId,
                                   @RequestBody NoteRequest noteRequest){
        return noteService.updateNote(pizzaId,noteId,noteRequest);
    }

}
