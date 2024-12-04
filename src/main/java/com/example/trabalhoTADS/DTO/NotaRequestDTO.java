package com.example.trabalhoTADS.DTO;

import com.example.trabalhoTADS.model.Disciplina;
import com.example.trabalhoTADS.model.Matricula;

import java.math.BigDecimal;
import java.util.Date;

public record NotaRequestDTO(Matricula matricula, Disciplina disciplina, BigDecimal nota, Date dataLancamento) {
}
