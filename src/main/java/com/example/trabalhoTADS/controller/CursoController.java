package com.example.trabalhoTADS.controller;

import com.example.trabalhoTADS.DTO.CursoRequestDTO;
import com.example.trabalhoTADS.model.Curso;
import com.example.trabalhoTADS.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoRepository repository;
    @GetMapping
    public List<Curso> findAll(){
        return this.repository.findAll();
    }
    @GetMapping("/{id}")
    public Curso findById(@PathVariable Integer id){
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado!"));
    }
    @PostMapping
    public Curso save(@RequestBody CursoRequestDTO dto){
        Curso curso = new Curso();

        curso.setNome(dto.nome());
        curso.setCodigo(dto.codigo());
        curso.setCarga_horaria(dto.carga_horaria());

        return this.repository.save(curso);
    }
    @PutMapping("/{id}")
    public Curso update(@PathVariable Integer id,
                        @RequestBody CursoRequestDTO dto){
        Curso curso = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado!"));

        curso.setNome(dto.nome());
        curso.setCodigo(dto.codigo());
        curso.setCarga_horaria(dto.carga_horaria());

        return this.repository.save(curso);
    }
    public void delete(@PathVariable Integer id){
        Curso curso = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado!"));

        this.repository.delete(curso);
    }
}
