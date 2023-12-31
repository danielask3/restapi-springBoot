package com.example.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
    
}
