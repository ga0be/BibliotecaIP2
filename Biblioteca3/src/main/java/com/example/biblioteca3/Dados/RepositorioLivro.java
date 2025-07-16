package com.example.biblioteca3.Dados;


import com.example.biblioteca3.Exceptions.Livro.LivroNaoEncontradoException;
import com.example.biblioteca3.Exceptions.Livro.LivrojaExisteException;
import com.example.biblioteca3.Exceptions.RepositorioCheioException;
import com.example.biblioteca3.Interfaces.RepositorioLivroInterface;
import com.example.biblioteca3.Negocio.ClassesBasicas.Livro;

public class RepositorioLivro implements RepositorioLivroInterface {

    private static RepositorioLivro instancia = null;

    private Livro[] livros;
    private int proxima;
    private final int tamanho = 100;

    private RepositorioLivro() {
        this.livros = new Livro[tamanho];
        this.proxima = 0;
    }

    public static RepositorioLivro getInstance() {
        if (instancia == null) {
            instancia = new RepositorioLivro();
        }
        return instancia;
    }





    // Procurar Livro:
    public Livro procurar(int IdLivro) throws LivroNaoEncontradoException {
        int i = 0;
        boolean achou = false;

        while ((!achou) && (i < this.proxima)) {
            if (IdLivro == this.livros[i].getIdLivro()) {
                achou = true;

            } else {
                i++;
            }
        }

        if (!achou) {
            throw new LivroNaoEncontradoException();
        }

        return this.livros[i];
    }


    public void adicionar(Livro livro) throws RepositorioCheioException, LivrojaExisteException {
        if (this.proxima >= this.livros.length) {
            throw new RepositorioCheioException();
        }

        try {
            procurar(livro.getIdLivro());

            throw new LivrojaExisteException(livro.getIdLivro());
        } catch (LivroNaoEncontradoException e) {

            this.livros[this.proxima] = livro;
            this.proxima++;
        }
    }

    // Procurar Indice Livro:
    public int procurarIndice(int IdLivro) throws LivroNaoEncontradoException {
        int i = 0;
        boolean achou = false;

        while ((!achou) && (i < this.proxima)) {
            if (IdLivro == this.livros[i].getIdLivro()) {
                achou = true;
            } else {
                i++;
            }
        }

        if (!achou) {
            throw new LivroNaoEncontradoException();
        }

        return i;
    }
    //  Remover Livro:
    public void remover(int IdLivro) throws LivroNaoEncontradoException{
        int i = this.procurarIndice(IdLivro);

        this.livros[i] = this.livros[this.proxima - 1];
        this.livros[this.proxima - 1] = null;
        this.proxima--;
    }

    public void atualizarLivro(Livro livroAtualizado) throws LivroNaoEncontradoException {
        int aux = this.procurarIndice(livroAtualizado.getIdLivro());
        if (aux != -1) {
            this.livros[aux] = livroAtualizado;
        }
    }


    public boolean repositorioVazio() {
        return this.proxima == 0;
    }

    //
    public boolean repositorioCheio() {
        return this.proxima >= this.livros.length;
    }


}
