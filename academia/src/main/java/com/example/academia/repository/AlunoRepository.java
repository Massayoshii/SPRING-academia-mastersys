package com.example.academia.repository;

import com.example.academia.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno , Long> {
}
