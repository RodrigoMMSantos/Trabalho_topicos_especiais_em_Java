package com.example.trabalhoTADS.controller;


import com.example.trabalhoTADS.DTO.NotaRequestDTO;
import com.example.trabalhoTADS.model.Nota;
import com.example.trabalhoTADS.repository.NotaRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Entity
@Table(name = "notas")
public class NotaController {
    @Autowired
    private NotaRepository repository;
    @GetMapping
    public List<Nota> findAll(){
        return this.repository.findAll();
    }
    @GetMapping("/{id}")
    public Nota findById(@PathVariable Integer id){
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nota lançada!"));
    }
    @PostMapping
    public Nota save(@RequestBody NotaRequestDTO dto){
        Nota nota = new Nota();
        nota.setMatricula(dto.matricula());
        nota.setDisciplina(dto.disciplina());
        nota.setNota(dto.nota());
        nota.setDataLancamento(dto.dataLancamento());

        return this.repository.save(nota);
    }
    @PutMapping("/{id}")
    public Nota update(@PathVariable Integer id,
                        @RequestBody NotaRequestDTO dto){
        Nota nota = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nota lançada!"));

        nota.setMatricula(dto.matricula());
        nota.setDisciplina(dto.disciplina());
        nota.setNota(dto.nota());
        nota.setDataLancamento(dto.dataLancamento());

        return this.repository.save(nota);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        Nota nota = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nota lançada!"));

        this.repository.delete(nota);
    }
}
