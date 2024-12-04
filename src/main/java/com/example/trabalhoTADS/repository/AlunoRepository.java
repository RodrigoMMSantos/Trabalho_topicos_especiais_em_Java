package com.example.trabalhoTADS.repository;

import com.example.trabalhoTADS.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
