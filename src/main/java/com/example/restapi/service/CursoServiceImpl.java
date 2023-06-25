package com.example.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.Curso;
import com.example.restapi.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso save(Curso curso) {
        cursoRepository.save(curso);
        return curso;
    }

    @Override
    public Curso findById(Long id) {
        if(cursoRepository.findById(id).isPresent()){
            return cursoRepository.findById(id).get();
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        Curso curso = findById(id);
        cursoRepository.delete(curso);

    }
    
}
