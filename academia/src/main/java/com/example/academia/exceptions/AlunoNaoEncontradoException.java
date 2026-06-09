package com.example.academia.exceptions;

public class AlunoNaoEncontradoException extends RuntimeException {
    public AlunoNaoEncontradoException(Long id) {
        super("Aluno com id "+ id +" não encontrado");
    }
}
