package com.example.biblioteca3.Exceptions.Livro;

public class LivrojaExisteException extends Exception {
    public LivrojaExisteException(int IdLivro) {
        super("Item com código '" + IdLivro + "' já existe no repositório.");
    }



}
