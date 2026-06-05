package com.example.academia.repository;

import com.example.academia.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula , Long> {
}
