package com.example.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.Curso;
import com.example.restapi.service.CursoService;

@CrossOrigin("*") //permite que o a api e cliente se comuniquem mesmo com protocolo http
@RestController //Define que a classe será responsavel pelo controle da restAPI
@RequestMapping("/api")//É a URI padrão
public class CursoController {
    
    @Autowired
    CursoService cursoService;

    @GetMapping("/cursos")
    public ResponseEntity<List<Curso>> get() {
        List<Curso> cursos = cursoService.findAll();
        return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
    }

    @PostMapping("/cursos")
    public ResponseEntity<Curso> save(@RequestBody Curso curso) {
        Curso cursoOne = cursoService.save(curso);
        return new ResponseEntity<Curso>(cursoOne, HttpStatus.OK);
    }

    @GetMapping("/cursos/{id}")
    public ResponseEntity<Curso> get(@PathVariable("id") Long id) {
        Curso curso = cursoService.findById(id);
        return new ResponseEntity<Curso>(curso, HttpStatus.OK);
    }

    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        cursoService.delete(id);
        return new ResponseEntity<String>("Expense is deleted sucessfull", 
        HttpStatus.OK);
    }
}
