package com.example.restapi.service;

import java.util.List;

import com.example.restapi.model.Curso;

public interface CursoService {
    
    List<Curso> findAll();

    Curso save(Curso curso);

    Curso findById(Long id);

    void delete(Long id);
}
