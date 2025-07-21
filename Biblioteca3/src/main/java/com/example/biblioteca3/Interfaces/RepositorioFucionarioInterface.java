package com.example.biblioteca3.Interfaces;


import com.example.biblioteca3.Exceptions.Conta.ContaJaExisteException;
import com.example.biblioteca3.Exceptions.Conta.ContaNaoExisteException;
import com.example.biblioteca3.Exceptions.RepositorioCheioException;
import com.example.biblioteca3.Negocio.ClassesBasicas.Funcionario;

public interface RepositorioFucionarioInterface {

    public void adicionarFuncionario(Funcionario conta) throws RepositorioCheioException, ContaJaExisteException;

    public void removerFuncionario(int idFuncionario) throws ContaNaoExisteException;

    public Funcionario buscarFuncionario(int idFuncionario) throws ContaNaoExisteException;

    public Funcionario buscarPeloLogin(String login) throws ContaNaoExisteException;

    public void atualizarFuncionario(Funcionario conta) throws ContaNaoExisteException;


}
