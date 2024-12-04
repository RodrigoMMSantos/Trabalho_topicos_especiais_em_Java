package com.example.trabalhoTADS.controller;

import com.example.trabalhoTADS.DTO.DisciplinaRequestDTO;
import com.example.trabalhoTADS.model.Disciplina;
import com.example.trabalhoTADS.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {
    @Autowired
    private DisciplinaRepository repository;
    @GetMapping
    public List<Disciplina> findAll(){
        return this.repository.findAll();
    }
    @GetMapping("/{id}")
    public Disciplina findById(@PathVariable Integer id){
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrado!"));
    }
    @PostMapping
    public Disciplina save(@RequestBody DisciplinaRequestDTO dto){
        Disciplina disciplina = new Disciplina();

        disciplina.setNome(dto.nome());
        disciplina.setCodigo(dto.codigo());
        disciplina.setCurso(dto.curso());
        disciplina.setProfessor(dto.professor());

        return this.repository.save(disciplina);
    }
    @PutMapping("/{id}")
    public Disciplina update(@PathVariable Integer id,
                             @RequestBody DisciplinaRequestDTO dto){
        Disciplina disciplina = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrado!"));
        disciplina.setNome(dto.nome());
        disciplina.setCodigo(dto.codigo());
        disciplina.setCurso(dto.curso());
        disciplina.setProfessor(dto.professor());

        return this.repository.save(disciplina);
    }
    public void delete(@PathVariable Integer id){
        Disciplina disciplina = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrado!"));

        this.repository.delete(disciplina);
    }
}
