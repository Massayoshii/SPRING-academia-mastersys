package com.example.academia.dto;

public record AlunoFiltroRequest(
        String nome,
        String email,
        String celular,
        String cidade,
        String estado
) {
}
