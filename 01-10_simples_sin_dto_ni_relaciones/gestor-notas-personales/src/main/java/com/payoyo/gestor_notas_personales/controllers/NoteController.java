package com.payoyo.gestor_notas_personales.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payoyo.gestor_notas_personales.models.Note;
import com.payoyo.gestor_notas_personales.services.INoteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NoteController {
    
    private final INoteService noteService;

    @PostMapping
    public ResponseEntity<Note> create(@Valid @RequestBody Note note) {
        Note noteCreated = noteService.create(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(noteCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> update(
        @PathVariable long id,
        @Valid @RequestBody Note note
    ){
        Note updatedNote = noteService.update(id, note);

        return ResponseEntity.ok(updatedNote);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAll(){
        List<Note> notes = noteService.getAllNotes();

        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getById(@PathVariable Long id){
        Note note = noteService.getById(id);

        return ResponseEntity.ok(note);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        noteService.deleteNoteById(id);

        return ResponseEntity.noContent().build();
    }
}
