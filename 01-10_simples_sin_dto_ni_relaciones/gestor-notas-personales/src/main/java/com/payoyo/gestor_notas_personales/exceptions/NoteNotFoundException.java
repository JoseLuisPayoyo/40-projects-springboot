package com.payoyo.gestor_notas_personales.exceptions;

public class NoteNotFoundException extends RuntimeException{
    
    public NoteNotFoundException(Long id) {
        super("Nota no encontrada con id: " + id);
    }
    
}
