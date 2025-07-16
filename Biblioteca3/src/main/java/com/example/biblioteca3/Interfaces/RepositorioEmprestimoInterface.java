package com.example.biblioteca3.Interfaces;


import com.example.biblioteca3.Exceptions.Emprestimo.NenhumEmprestimoException;
import com.example.biblioteca3.Negocio.ClassesBasicas.Emprestimo;

import java.time.LocalDate;

public interface RepositorioEmprestimoInterface {

    public void adicionarEmprestimo(Emprestimo emprestimo);

    public void removerEmprestimo(int numero);

    public Emprestimo buscarEmprestimo(int numero);

    public void atualizarEmprestimo(Emprestimo emprestimoAtualizado);

    public Emprestimo[] buscarEmprestimosPorCliente(int idCliente) throws NenhumEmprestimoException;

    public Emprestimo[] buscarEmprestimosPorLivro(int idLivro) throws NenhumEmprestimoException;

    public Emprestimo[] buscarEmprestimosPorPeriodo(LocalDate DataEmprestimo, LocalDate DataDevolucaol) throws NenhumEmprestimoException;

    public String gerarRelatorioPorCliente (int idCliente) throws NenhumEmprestimoException;

}
