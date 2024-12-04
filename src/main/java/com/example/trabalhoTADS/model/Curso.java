package com.example.trabalhoTADS.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;
    @Column
    private String codigo;
    @Column
    private Integer carga_horaria;
    @OneToMany(mappedBy = "curso")
    private List<Disciplina> disciplinas;
    @OneToMany(mappedBy = "curso")
    private List<Turma> turmas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(Integer carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
