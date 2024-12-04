package com.example.trabalhoTADS.DTO;

import java.util.Date;

public record AlunoRequestDto(String nome, String email, String matricula, Date data_nascimento) {
}
