package com.example.restaurant_app.controller;

import com.example.restaurant_app.service.NoteService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

}
