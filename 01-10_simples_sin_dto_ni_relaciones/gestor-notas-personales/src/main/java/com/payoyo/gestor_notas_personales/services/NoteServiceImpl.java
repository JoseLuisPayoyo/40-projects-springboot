package com.payoyo.gestor_notas_personales.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.payoyo.gestor_notas_personales.exceptions.NoteNotFoundException;
import com.payoyo.gestor_notas_personales.models.Note;
import com.payoyo.gestor_notas_personales.repositories.NoteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class NoteServiceImpl implements INoteService{

    private final NoteRepository noteRepository;

    @Override
    public Note create(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note update(Long id, Note note) {
        Note noteExisting = noteRepository.findById(id)
            .orElseThrow(() -> new NoteNotFoundException("Nota no encotrada con id: " + id));
        
        noteExisting.setTitle(note.getTitle());
        noteExisting.setContent(note.getContent());

        return noteRepository.save(noteExisting);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getById(Long id) {
        return noteRepository.findById(id)
            .orElseThrow(() -> new NoteNotFoundException("Nota no encontrada con id: " + id));
    }

    @Override
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
    
}
