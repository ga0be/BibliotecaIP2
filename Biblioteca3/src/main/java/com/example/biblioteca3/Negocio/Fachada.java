package com.example.biblioteca3.Negocio;

import com.example.biblioteca3.Exceptions.Conta.ContaJaExisteException;
import com.example.biblioteca3.Exceptions.Conta.ContaNaoExisteException;
import com.example.biblioteca3.Exceptions.DataInvalidaException;
import com.example.biblioteca3.Exceptions.Emprestimo.NenhumEmprestimoException;
import com.example.biblioteca3.Exceptions.Livro.LivroNaoEncontradoException;
import com.example.biblioteca3.Exceptions.Livro.LivrojaExisteException;
import com.example.biblioteca3.Exceptions.RepositorioCheioException;
import com.example.biblioteca3.Negocio.ClassesBasicas.Cliente;
import com.example.biblioteca3.Negocio.ClassesBasicas.Emprestimo;
import com.example.biblioteca3.Negocio.ClassesBasicas.Funcionario;
import com.example.biblioteca3.Negocio.ClassesBasicas.Livro;

import java.time.LocalDate;


public class Fachada {

    private CadastroFuncionario funcionarios;
    private CadastroCliente clientes;
    private CadastroLivro livros;
    private CadastroEmprestimo emprestimos;
    private static Fachada instance;

    private Fachada() {
        this.funcionarios = CadastroFuncionario.getInstance();
        this.clientes = CadastroCliente.getInstancia();
        this.livros = CadastroLivro.getInstancia();
        this.emprestimos = CadastroEmprestimo.getInstance();
    }

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }


    //-------  MÉTODOS DE FUNCIONÁRIO--------//


    public void cadastrarAtendente(String nome, String cargo, String login, String senha, String cpf, String turno, double remuneracao, double horas) throws
            ContaJaExisteException, RepositorioCheioException {
        funcionarios.cadastrarAtendente(nome, cargo, login, senha, cpf, turno, remuneracao, horas);
    }

    public void cadastrarAdministrador(String nome, String cargo, String login, String senha, String cpf, double salario) throws
            ContaJaExisteException, RepositorioCheioException {
        funcionarios.cadastrarAdministrador(nome, cargo, login, senha, cpf, salario);
    }

    public void removerFuncionario(int funcionarioId) throws ContaNaoExisteException {
        funcionarios.removerFuncionario(funcionarioId);
    }

    public Funcionario buscarFuncionario(int FuncionarioId) throws ContaNaoExisteException {
        return funcionarios.buscarFuncionario(FuncionarioId);
    }

    public void atualizarAdm(String nome, String cargo, String login, String senha, String cpf, int idFuncionario, double salario) throws ContaNaoExisteException, RepositorioCheioException {

        funcionarios.atualizarAdm(nome, cargo, login, senha, cpf, idFuncionario, salario);
    }

    public void atualizarAtendente(String nome, String cargo, String login, String senha, String cpf, int idFuncionario, String turno, double comicao, double horas) throws ContaNaoExisteException {
        funcionarios.atualizarAtendente(nome, cargo, login, senha, cpf, idFuncionario, turno, comicao, horas);
    }

    public String listarContas() {
        return funcionarios.listarContas();
    }


    //--------MÉTODOS DE CLIENTE-----------//


    public void cadastrarCliente(String nome, String cpf, String telefone, String endereco, String email)
            throws ContaJaExisteException, RepositorioCheioException {
        clientes.cadastrarCliente(nome, cpf, telefone, endereco, email);
    }

    public void removerCliente(int id) throws ContaNaoExisteException {
        clientes.removerCliente(id);
    }

    public Cliente buscarCliente(int id) throws ContaNaoExisteException {
        return clientes.buscarCliente(id);
    }

    public void atualizarCliente(String nome, int idCliente, String cpf, String telefone, String endereco, String email) throws ContaNaoExisteException {
        clientes.atualizarCliente(nome, idCliente, cpf, telefone, endereco, email);
    }

    public String listarClientes() {
        return clientes.listarClientes();
    }


    //--------MÉTODOS DE LIVRO-----------//


    public void cadastrarLivro(String Titulo, String Autor, String Categoria, String ISBN, int qtdDisponivel, int anoLancamento, boolean disponivel)
            throws LivrojaExisteException, RepositorioCheioException {
        livros.cadastrarLivro(Titulo, Autor, Categoria, ISBN, qtdDisponivel, anoLancamento, disponivel);
    }

    public void removerLivro(int id) throws LivroNaoEncontradoException {
        livros.removerLivro(id);
    }

    public Livro buscarLivro(int id) throws LivroNaoEncontradoException {
        return livros.buscarLivro(id);
    }

    public void atualizarLivro(String Titulo, String Autor, String Categoria, int IdLivro, String ISBN, int qtdDisponivel, int anoLancamento, boolean disponivel) throws LivroNaoEncontradoException {

        livros.atualizarLivro(Titulo, Autor, Categoria, IdLivro, ISBN, qtdDisponivel, anoLancamento, disponivel);

    }

    public String listarLivros() {
        return livros.listarLivros();
    }


    //--------MÉTODOS DE EMPRÉSTIMO-----------//

    public void cadastrarEmprestimo(Livro livro, Cliente cliente, LocalDate DataEmprestimo, LocalDate DataDevolucao) throws DataInvalidaException, LivroNaoEncontradoException {
        emprestimos.cadastrarEmprestimo(livro, cliente, DataEmprestimo, DataDevolucao);
    }

    public void removerEmprestimo(int idEmprestimo) {
        emprestimos.removerEmprestimo(idEmprestimo);
    }

    public Emprestimo buscarEmprestimo(int idReserva) {

        return emprestimos.buscarEmprestimo(idReserva);
    }

    public void atualizarEmprestimo(int idReserva, Livro livro, Cliente cliente, LocalDate dataInicio,
                                    LocalDate dataFinal)
            throws LivroNaoEncontradoException {

        emprestimos.atualizarEmprestimo(idReserva, livro, cliente, dataInicio, dataFinal);
    }

    public String buscarEmprestimosCliente(int idCliente) throws NenhumEmprestimoException {
       return emprestimos.buscarEmprestimosCliente(idCliente);
    }

    public String buscarLivrosPorEmprestimo(int IdLivro) throws NenhumEmprestimoException {
       return emprestimos.buscarLivrosPorEmprestimo(IdLivro);
    }

    public String buscarLivrosPeriodo(LocalDate dataEmprestimo, LocalDate dataDevcolucao) throws NenhumEmprestimoException {
        return emprestimos.buscarLivrosPeriodo(dataEmprestimo, dataDevcolucao);
    }

    public String ListarEmprestimos(){
        return emprestimos.toString();
    }

    public String gerarRelatorio(int IdCliente) throws NenhumEmprestimoException {

        return emprestimos.gerarRelatorioCompleto(IdCliente);
    }

}
