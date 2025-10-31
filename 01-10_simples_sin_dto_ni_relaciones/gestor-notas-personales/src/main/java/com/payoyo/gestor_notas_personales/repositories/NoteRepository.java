package com.payoyo.gestor_notas_personales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payoyo.gestor_notas_personales.models.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{}
