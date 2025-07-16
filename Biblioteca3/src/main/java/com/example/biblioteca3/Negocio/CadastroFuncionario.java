package com.example.biblioteca3.Negocio;


import com.example.biblioteca3.Dados.RepositorioFuncionario;
import com.example.biblioteca3.Exceptions.Conta.ContaJaExisteException;
import com.example.biblioteca3.Exceptions.Conta.ContaNaoExisteException;
import com.example.biblioteca3.Exceptions.RepositorioCheioException;
import com.example.biblioteca3.Negocio.ClassesBasicas.Administrador;
import com.example.biblioteca3.Negocio.ClassesBasicas.Atendente;
import com.example.biblioteca3.Negocio.ClassesBasicas.Funcionario;

public class CadastroFuncionario {

    private RepositorioFuncionario repositorio;
    private int ultimoId;
    private static CadastroFuncionario instancia;

    private CadastroFuncionario() {
        this.repositorio = RepositorioFuncionario.getInstance();
        this.ultimoId = 0;
    }

    public static CadastroFuncionario getInstance(){
        if(instancia == null){
            instancia = new CadastroFuncionario();
        }
        return instancia;
    }

    public void cadastrarAtendente(String nome, String cargo, String login, String senha, String cpf, String turno, double remuneracao, double horas) throws
            ContaJaExisteException, RepositorioCheioException {

        Funcionario atendente = new Atendente(nome, cargo, login, senha, cpf, ultimoId + 1, turno, remuneracao, horas);
        this.ultimoId++;
        this.repositorio.adicionarFuncionario(atendente);
    }

    public void cadastrarAdministrador(String nome, String cargo, String login, String senha, String cpf, double salario) throws
            ContaJaExisteException, RepositorioCheioException{

        Funcionario administrador = new Administrador(nome, cargo, login, senha, cpf, ultimoId + 1, salario);
        this.ultimoId++;
        this.repositorio.adicionarFuncionario(administrador);
    }

    public void removerFuncionario(int funcionarioId) throws ContaNaoExisteException {
        repositorio.removerFuncionario(funcionarioId);
    }

    public Funcionario buscarFuncionario(int FuncionarioId) throws ContaNaoExisteException{
        return repositorio.buscarFuncionario(FuncionarioId);
    }

    public void atualizarAdm(String nome, String cargo, String login, String senha, String cpf, int idFuncionario, double salario) throws ContaNaoExisteException, RepositorioCheioException {
        Funcionario administrador = new Administrador(nome, cargo, login, senha, cpf, idFuncionario, salario);
        repositorio.atualizarFuncionario(administrador);
    }

    public void atualizarAtendente(String nome, String cargo, String login, String senha, String cpf, int idFuncionario, String turno, double comicao, double horas) throws ContaNaoExisteException{
        Funcionario atendente = new Atendente(nome, cargo, login, senha, cpf, idFuncionario, turno, comicao, horas );
        repositorio.atualizarFuncionario(atendente);
    }

    public String listarContas(){
        return repositorio.toString();
    }
}
