package com.example.biblioteca3.Dados;


import com.example.biblioteca3.Exceptions.Conta.ContaJaExisteException;
import com.example.biblioteca3.Exceptions.Conta.ContaNaoExisteException;
import com.example.biblioteca3.Exceptions.RepositorioCheioException;
import com.example.biblioteca3.Interfaces.RepositorioFucionarioInterface;
import com.example.biblioteca3.Negocio.ClassesBasicas.Funcionario;

public class RepositorioFuncionario implements RepositorioFucionarioInterface {

    private Funcionario[] funcionarios;
    private int funcionariosIndex;
    private int tamanho;
    private static RepositorioFuncionario repositorio;

    private RepositorioFuncionario(int tamanho){
        this.funcionarios = new Funcionario[tamanho];
        this.tamanho = tamanho;
        this.funcionariosIndex = 0;
    }

    public static RepositorioFuncionario getInstance(){
        if(repositorio == null){
            repositorio = new RepositorioFuncionario(100);
        }
        return repositorio;
    }

    public void adicionarFuncionario(Funcionario conta) throws RepositorioCheioException, ContaJaExisteException{
        this.buscarCpfFuncionario(conta.getCpf());

        if(funcionariosIndex < this.tamanho) {
            this.funcionarios[this.funcionariosIndex] = conta;
            this.funcionariosIndex++;
        } else{
            throw new RepositorioCheioException();
        }
    }

    private void buscarCpfFuncionario(String cpf) throws ContaJaExisteException {
        for(int i = 0; i < this.funcionariosIndex; i++){
            if(this.funcionarios[i].getCpf().equals(cpf)){
                throw new ContaJaExisteException();
            }
        }
    }

    private int buscarIndexFuncionario(int id) throws ContaNaoExisteException {
        for (int i = 0; i < this.funcionariosIndex; i++){
            if(funcionarios[i].getIdFuncionario() == id){
                return i;
            }
        }

        throw new ContaNaoExisteException();
    }

    public void removerFuncionario(int idFuncionario) throws ContaNaoExisteException{

        int aux = this.buscarIndexFuncionario(idFuncionario);


        for (int i = 0; i + aux < 10; i++) {
            if (i + aux < 9) {
                funcionarios[i + aux] = this.funcionarios[i + aux + 1];
            } else {
                funcionarios[i + aux] = null;
            }
        }

        this.funcionariosIndex--;

    }

    public Funcionario buscarFuncionario(int idFuncionario) throws ContaNaoExisteException{
        int aux = this.buscarIndexFuncionario(idFuncionario);

        return funcionarios[aux];
    }

    public void atualizarFuncionario(Funcionario conta) throws ContaNaoExisteException {
        int aux = this.buscarIndexFuncionario(conta.getIdFuncionario());

        funcionarios[aux] = conta;
    }

    public String toString(){
        String aux = "\n\nLista de Funcionários:\n\n";

        for(int i = 0; i < this.funcionariosIndex; i++){
            aux += funcionarios[i].toString() + "\n\n";
        }

        return aux;
    }
}

