package com.example.biblioteca3.Dados;


import com.example.biblioteca3.Exceptions.Conta.ContaJaExisteException;
import com.example.biblioteca3.Exceptions.Conta.ContaNaoExisteException;
import com.example.biblioteca3.Exceptions.RepositorioCheioException;
import com.example.biblioteca3.Interfaces.RepositorioClienteInterface;
import com.example.biblioteca3.Negocio.ClassesBasicas.Cliente;

public class RepositorioCliente implements RepositorioClienteInterface {

    private Cliente[] clientes;
    private int clientesIndex;
    private int tamanho;
    private static RepositorioCliente repositorio;

    private RepositorioCliente(int tamanho){
        this.clientes = new Cliente[tamanho];
        this.tamanho = tamanho;
        this.clientesIndex = 0;
    }

    public static RepositorioCliente getInstance(){
        if(repositorio == null){
            repositorio = new RepositorioCliente(100);
        }
        return repositorio;
    }

    public void adicionarCliente(Cliente conta) throws RepositorioCheioException, ContaJaExisteException {
        this.buscarCpfCliente(conta.getCpf());

        if(clientesIndex < this.tamanho) {
            this.clientes[this.clientesIndex] = conta;
            this.clientesIndex++;
        } else{
            throw new RepositorioCheioException();
        }
    }

    private void buscarCpfCliente(String cpf) throws ContaJaExisteException{
        for(int i = 0; i < this.clientesIndex; i++){
            if(this.clientes[i].getCpf().equals(cpf)){
                throw new ContaJaExisteException();
            }
        }
    }

    private int buscarIndexCliente(int id) throws ContaNaoExisteException {
        for (int i = 0; i < this.clientesIndex; i++){
            if(clientes[i].getIdCliente() == id){
                return i;
            }
        }

        throw new ContaNaoExisteException();
    }

    public void removerCliente(int IdCliente) throws ContaNaoExisteException{

        int aux = this.buscarIndexCliente(IdCliente);


        for (int i = 0; i + aux < 10; i++) {
            if (i + aux < 9) {
                clientes[i + aux] = this.clientes[i + aux + 1];
            } else {
                clientes[i + aux] = null;
            }
        }

        this.clientesIndex--;

    }

    public Cliente buscarCliente(int idCliente) throws ContaNaoExisteException{
        int aux = this.buscarIndexCliente(idCliente);

        return clientes[aux];
    }

    public void atualizarCliente(Cliente conta) throws ContaNaoExisteException{
        int aux = this.buscarIndexCliente(conta.getIdCliente());

        clientes[aux] = conta;
    }

    public String toString(){
        String aux = "\n\nLista de Clientes:\n\n";

        for(int i = 0; i < this.clientesIndex; i++){
            aux += clientes[i].toString() + "\n\n";
        }

        return aux;
    }
}


