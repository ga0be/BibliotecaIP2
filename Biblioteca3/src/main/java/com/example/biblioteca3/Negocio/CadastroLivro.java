package com.example.biblioteca3.Negocio;

import com.example.biblioteca3.Dados.RepositorioLivro;
import com.example.biblioteca3.Exceptions.Livro.LivroNaoEncontradoException;
import com.example.biblioteca3.Exceptions.Livro.LivrojaExisteException;
import com.example.biblioteca3.Exceptions.RepositorioCheioException;
import com.example.biblioteca3.Negocio.ClassesBasicas.Livro;


public class CadastroLivro {

    private RepositorioLivro repositorio;
    private int ultimoId;
    private static CadastroLivro Instancia;

    public CadastroLivro() {
        this.repositorio = repositorio;
        this.ultimoId = 0;
    }

    protected static CadastroLivro getInstancia() {
        if (Instancia == null) {
            Instancia = new CadastroLivro();
        }

        return Instancia;
    }

    public void cadastrarLivro(String Titulo, String Autor, String Categoria, String ISBN, int qtdDisponivel, int anoLancamento, boolean disponivel)
            throws LivrojaExisteException, RepositorioCheioException {
        Livro livro = new Livro(Titulo, Autor, Categoria, ultimoId + 1, ISBN, qtdDisponivel, anoLancamento, disponivel);
        ultimoId++;
        this.repositorio.adicionar(livro);
    }

    public void removerLivro(int id) throws LivroNaoEncontradoException {
        this.repositorio.remover(id);
    }

    public Livro buscarLivro(int id) throws LivroNaoEncontradoException{
        return this.repositorio.procurar(id);
    }

    public void atualizarLivro(String Titulo, String Autor, String Categoria, int IdLivro, String ISBN, int qtdDisponivel, int anoLancamento, boolean disponivel) throws LivroNaoEncontradoException {

        Livro auxLivro= this.repositorio.procurar(IdLivro);

        if (auxLivro!= null) {
            Livro livro  = new Livro(Titulo, Autor, Categoria, IdLivro, ISBN, qtdDisponivel, anoLancamento, disponivel);
            repositorio.atualizarLivro(livro);
        }
    }

    public String listarLivros(){
        return this.repositorio.toString();
    }
}


