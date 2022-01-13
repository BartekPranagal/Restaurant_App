package com.example.restaurant_app.service;

import com.example.restaurant_app.repository.NoteRepository;
import com.example.restaurant_app.service.converters.NoteConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteConverter noteConverter;

}
