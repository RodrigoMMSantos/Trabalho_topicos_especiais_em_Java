package com.example.trabalhoTADS.DTO;

import com.example.trabalhoTADS.model.Aluno;
import com.example.trabalhoTADS.model.Turma;

public record MatriculaRequestDTO(Aluno aluno, Turma turma) {
}
