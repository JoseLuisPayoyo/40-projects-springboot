package com.payoyo.gestor_notas_personales.exceptions;

public class NoteNotFoundException extends RuntimeException{
    
    public NoteNotFoundException(String message) {
        super(message);
    }

}
