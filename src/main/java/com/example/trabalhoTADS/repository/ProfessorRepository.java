package com.example.trabalhoTADS.repository;

import com.example.trabalhoTADS.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
