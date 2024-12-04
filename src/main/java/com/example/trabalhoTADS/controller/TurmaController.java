package com.example.trabalhoTADS.controller;

import com.example.trabalhoTADS.DTO.TurmaRequestDTO;
import com.example.trabalhoTADS.model.Aluno;
import com.example.trabalhoTADS.model.Turma;
import com.example.trabalhoTADS.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {
    @Autowired
    private TurmaRepository repository;
    @GetMapping
    public List<Turma> findAll() {
        return this.repository.findAll();
    }
    @GetMapping("/{id}")
    public Turma findById(@PathVariable Integer id){
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada!"));
    }
    @PostMapping
    public Turma save(@RequestBody TurmaRequestDTO dto){
        Turma turma = new Turma();
        turma.setAno(dto.ano());
        turma.setSemestre(dto.semestre());
        turma.setCurso(dto.curso());

        return this.repository.save(turma);
    }
    @PutMapping("/{id}")
    public Turma update(@PathVariable Integer id,
                        @RequestBody TurmaRequestDTO dto){
        Turma turma = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada!"));

        turma.setAno(dto.ano());
        turma.setSemestre(dto.semestre());
        turma.setCurso(dto.curso());


        return this.repository.save(turma);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        Turma turma = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado!"));

        this.repository.delete(turma);
    }
}
