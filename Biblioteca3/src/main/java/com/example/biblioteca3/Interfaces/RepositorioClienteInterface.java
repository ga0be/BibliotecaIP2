package com.example.biblioteca3.Interfaces;


import com.example.biblioteca3.Exceptions.Conta.ContaJaExisteException;
import com.example.biblioteca3.Exceptions.Conta.ContaNaoExisteException;
import com.example.biblioteca3.Exceptions.RepositorioCheioException;
import com.example.biblioteca3.Negocio.ClassesBasicas.Cliente;

public interface RepositorioClienteInterface {

    public void adicionarCliente(Cliente cliente) throws RepositorioCheioException, ContaJaExisteException;

    public void atualizarCliente(Cliente conta) throws ContaNaoExisteException;

    public void removerCliente(int IdCliente) throws ContaNaoExisteException;

    public Cliente buscarCliente(int IdCliente) throws ContaNaoExisteException;
}
