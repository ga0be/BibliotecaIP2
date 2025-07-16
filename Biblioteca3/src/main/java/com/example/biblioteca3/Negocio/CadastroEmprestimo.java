package com.example.biblioteca3.Negocio;


import com.example.biblioteca3.Dados.RepositorioCliente;
import com.example.biblioteca3.Dados.RepositorioEmprestimo;
import com.example.biblioteca3.Dados.RepositorioLivro;
import com.example.biblioteca3.Exceptions.DataInvalidaException;
import com.example.biblioteca3.Exceptions.Emprestimo.NenhumEmprestimoException;
import com.example.biblioteca3.Exceptions.Livro.LivroNaoEncontradoException;
import com.example.biblioteca3.Negocio.ClassesBasicas.Cliente;
import com.example.biblioteca3.Negocio.ClassesBasicas.Emprestimo;
import com.example.biblioteca3.Negocio.ClassesBasicas.Livro;

import java.time.LocalDate;
import java.util.Arrays;

public class CadastroEmprestimo {


    private int ultimoIdEmprestimo;
    private RepositorioEmprestimo RepositorioEmprestimo;
    private RepositorioCliente RepositorioCliente;
    private RepositorioLivro RepositorioLivro;
    private static CadastroEmprestimo instance;

    private CadastroEmprestimo(){
        this.ultimoIdEmprestimo = 0;
        this.RepositorioEmprestimo = RepositorioEmprestimo.getInstance();
        this.RepositorioCliente = RepositorioCliente.getInstance();
        this.RepositorioLivro = RepositorioLivro.getInstance();
    }

    protected static CadastroEmprestimo getInstance(){
        if(instance == null){
            instance = new CadastroEmprestimo();
        }

        return instance;
    }

    public void cadastrarEmprestimo(Livro livro, Cliente cliente, LocalDate DataEmprestimo, LocalDate DataDevolucao) throws DataInvalidaException, LivroNaoEncontradoException {

        Livro auxLivro = this.RepositorioLivro.procurar(livro.getIdLivro());

        if(auxLivro != null && DataDevolucao.isAfter(DataEmprestimo)){
            Emprestimo emprestimo = new Emprestimo(ultimoIdEmprestimo +1, DataEmprestimo, DataDevolucao, cliente,livro);
            ultimoIdEmprestimo++;
            RepositorioEmprestimo.adicionarEmprestimo(emprestimo);
        }
        else {
            throw new DataInvalidaException();
        }
    }

    public void removerEmprestimo(int idEmprestimo){
        this.RepositorioEmprestimo.removerEmprestimo(idEmprestimo);
    }

    public Emprestimo buscarEmprestimo(int idReserva){
        return this.RepositorioEmprestimo.buscarEmprestimo(idReserva);
    }

    public void atualizarEmprestimo(int idReserva, Livro livro, Cliente cliente, LocalDate dataInicio,
                                 LocalDate dataFinal) throws LivroNaoEncontradoException {

        Livro auxLivro = this.RepositorioLivro.procurar(livro.getIdLivro());
        Emprestimo auxEmprestimo = this.RepositorioEmprestimo.buscarEmprestimo(idReserva);

        if(auxLivro != null && auxEmprestimo!= null){
           Emprestimo emprestimo = new Emprestimo(idReserva, dataInicio, dataFinal, cliente, livro);
            RepositorioEmprestimo.atualizarEmprestimo(emprestimo);
        }
    }

    public String buscarEmprestimosCliente(int idCliente) throws NenhumEmprestimoException {
        Emprestimo[] resultado = this.RepositorioEmprestimo.buscarEmprestimosPorCliente(idCliente);

        return "\n Emprestimos encontrados para esse Id: " + Arrays.toString(resultado);
    }

    public String buscarLivrosPorEmprestimo(int IdLivro) throws NenhumEmprestimoException {
        Emprestimo[] resultado = this.RepositorioEmprestimo.buscarEmprestimosPorLivro(IdLivro);

        return "\n Emprestimos encontrados para esse livro: " + Arrays.toString(resultado);
    }

    public String buscarLivrosPeriodo(LocalDate dataEmprestimo, LocalDate dataDevcolucao) throws NenhumEmprestimoException {
        Emprestimo[] resultado = this.RepositorioEmprestimo.buscarEmprestimosPorPeriodo(dataEmprestimo, dataDevcolucao);

        return "\n Emprestimos encontrados para esse periodo: " + Arrays.toString(resultado);
    }

    public String toString(){
        return RepositorioEmprestimo.toString();
    }

    public String gerarRelatorioCompleto(int IdCliente) throws NenhumEmprestimoException {

        return RepositorioEmprestimo.gerarRelatorioPorCliente(IdCliente);
    }
}
