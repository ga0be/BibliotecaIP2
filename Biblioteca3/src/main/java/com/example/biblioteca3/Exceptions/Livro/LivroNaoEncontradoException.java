package com.example.biblioteca3.Exceptions.Livro;

public class LivroNaoEncontradoException extends Exception {
    public LivroNaoEncontradoException() {
        super("Livro não encontrado!");
    }
}
