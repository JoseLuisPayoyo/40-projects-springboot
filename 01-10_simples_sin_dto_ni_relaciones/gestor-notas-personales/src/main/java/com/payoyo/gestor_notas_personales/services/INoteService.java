package com.payoyo.gestor_notas_personales.services;

import java.util.List;

import com.payoyo.gestor_notas_personales.models.Note;

public interface INoteService {
    
    Note create(Note note);

    Note update(Long id, Note note);

    List<Note> getAllNotes();

    Note getById(Long id);

    void deleteNoteById(Long id);

}
