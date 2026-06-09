package com.example.academia.exceptions;

public class EmailJaCadastradoException extends RuntimeException {
    public EmailJaCadastradoException() {
        super("Esse email ja foi cadastrado");
    }
}
