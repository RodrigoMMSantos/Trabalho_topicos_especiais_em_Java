package com.example.trabalhoTADS.controller;


import com.example.trabalhoTADS.DTO.MatriculaRequestDTO;
import com.example.trabalhoTADS.model.Matricula;
import com.example.trabalhoTADS.repository.MatriculaRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Entity
@Table(name = "matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaRepository repository;
    @GetMapping
    public List<Matricula> findAll(){
        return this.repository.findAll();
    }
    @GetMapping("/{id}")
    public Matricula findById(@PathVariable Integer id){
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matricula não encontrada!"));
    }
    @PostMapping
    public Matricula save(@RequestBody MatriculaRequestDTO dto){
        Matricula matricula = new Matricula();
        matricula.setAluno(dto.aluno());
        matricula.setTurma(dto.turma());

        return this.repository.save(matricula);
    }
    @PutMapping("/{id}")
    public Matricula update(@PathVariable Integer id,
                        @RequestBody MatriculaRequestDTO dto){
        Matricula matricula = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matricula não encontrada!"));

        matricula.setAluno(dto.aluno());
        matricula.setTurma(dto.turma());

        return this.repository.save(matricula);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        Matricula matricula = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Matricula não encontrada!"));

        this.repository.delete(matricula);
    }
}
