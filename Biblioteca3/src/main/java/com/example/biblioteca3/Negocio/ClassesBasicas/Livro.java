package com.example.biblioteca3.Negocio.ClassesBasicas;

import java.util.Objects;

public class Livro {
   private String Titulo;
   private String Autor;
   private String Categoria;
   private String ISBN;
   private int IdLivro;
   private int qtdDisponivel;
   private int anoLancamento;
   private boolean disponivel;


    public Livro(){
        this.Titulo = "defaultTitulo";
        this.Autor = "defaultAutor";
        this.Categoria = "defaultCategoria";
        this.ISBN = "defaultISBN";
        this.IdLivro = 0;
        this.qtdDisponivel = 0;
        this.anoLancamento = 0;
        this.disponivel = false;
    }


    public Livro(String Titulo, String Autor, String Categoria, int IdLivro, String ISBN, int qtdDisponivel, int anoLancamento, boolean disponivel) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Categoria = Categoria;
        this.IdLivro = IdLivro;
        this.ISBN = ISBN;
        this.qtdDisponivel = qtdDisponivel;
        this.anoLancamento = anoLancamento;
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getCategoria() {
        return Categoria;
    }


    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getIdLivro(){return IdLivro;}

    public void setIdLivro(int IdLivro){this.IdLivro = IdLivro;}

    @Override
    public String toString() {
        return "Titulo: " + this.Titulo +
                "\nAutor: " + this.Autor +
                "\nCategoria: " + this.Categoria +
                "\nISBN: " + this.ISBN +
                "\nqtd Disponivel: " + this.qtdDisponivel +
                "\nAno de lançamento: "  + this.anoLancamento +
                "\nDisponibilidade: " + this.disponivel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livro livro)) return false;
        return getQtdDisponivel() == livro.getQtdDisponivel() && getAnoLancamento() == livro.getAnoLancamento() && isDisponivel() == livro.isDisponivel() && Objects.equals(getTitulo(), livro.getTitulo()) && Objects.equals(getAutor(), livro.getAutor()) && Objects.equals(getCategoria(), livro.getCategoria()) && Objects.equals(getISBN(), livro.getISBN());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitulo(), getAutor(), getCategoria(), getISBN(), getQtdDisponivel(), getAnoLancamento(), isDisponivel());
    }
}
