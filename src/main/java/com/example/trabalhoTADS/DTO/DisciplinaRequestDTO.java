package com.example.trabalhoTADS.DTO;

import com.example.trabalhoTADS.model.Curso;
import com.example.trabalhoTADS.model.Professor;

public record DisciplinaRequestDTO(String nome, String codigo, Curso curso, Professor professor) {
}
