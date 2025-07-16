package com.example.biblioteca3.Negocio.ClassesBasicas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Emprestimo {
   private int numero;
   private LocalDate DataEmprestimo;
   private LocalDate DataDevolucao;
   private Cliente cliente;
   private Livro livro;


    public Emprestimo(int numero, LocalDate DataEmprestimo, LocalDate DataDevolucao, Cliente cliente, Livro livro){
        this.numero = numero;
        this.DataEmprestimo = DataEmprestimo;
        this.DataDevolucao = DataDevolucao;
        this.cliente = cliente;
        this.livro = livro;
    }

    public int getNumero() {return numero;}

    public void setNumero(int numero) {this.numero = numero;}

    public LocalDate getDataEmprestimo() {
        return DataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.DataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return DataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.DataDevolucao = dataDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String resultado = "\nEmprestimo numero " + this.numero + ": \n\n";
        resultado += "-Dados do cliente --> \n\n" + this.cliente.toString();
        resultado += "\n\n- Livro emprestado --> \n\n" + this.livro.toString();
        resultado += " \n\nData de emprestimo: " + this.DataEmprestimo.format(formatter);
        resultado += " \nData de devolução: " + this.DataDevolucao.format(formatter);

        return resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Emprestimo that)) return false;
        return Objects.equals(getDataEmprestimo(), that.getDataEmprestimo()) && Objects.equals(getDataDevolucao(), that.getDataDevolucao()) && Objects.equals(getCliente(), that.getCliente()) && Objects.equals(getLivro(), that.getLivro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDataEmprestimo(), getDataDevolucao(), getCliente(), getLivro());
    }

    public String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder("Relatório de reservas do cliente: " + this.cliente.getNome());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        relatorio.append("\n\n").append("Número da reserva: ").append(numero).append("\n");
        relatorio.append("Cliente: ").append(cliente.getNome()).append(" (CPF: ").append(cliente.getCpf()).append(")\n");
        relatorio.append("Livro: ").append(livro.getTitulo()).append(" (Id do livro: ").append(livro.getIdLivro()).append(")\n");
        relatorio.append("Período de emprestimo: ").append(DataEmprestimo.format(formatter)).append(" a ").append(DataDevolucao.format(formatter)).append("\n");



        return relatorio.toString();
    }
}



