package com.example.biblioteca3.Interfaces;

import com.example.biblioteca3.Exceptions.Livro.LivroNaoEncontradoException;
import com.example.biblioteca3.Exceptions.Livro.LivrojaExisteException;
import com.example.biblioteca3.Exceptions.RepositorioCheioException;
import com.example.biblioteca3.Negocio.ClassesBasicas.Livro;

public interface RepositorioLivroInterface {

    public Livro procurar(int IdLivro) throws LivroNaoEncontradoException;

    public void adicionar(Livro livro) throws RepositorioCheioException, LivrojaExisteException;

    public void remover(int IdLivro) throws LivroNaoEncontradoException;

    public void atualizarLivro(Livro livro) throws LivroNaoEncontradoException;
}
