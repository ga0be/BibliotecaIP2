package com.example.biblioteca3.Negocio.ClassesBasicas;

import java.util.Objects;

public abstract class Funcionario {
   private String Nome;
   private String Cargo;
   private String Login;
   private String Senha;
   private String cpf;
   private boolean administrador;
   private int idFuncionario;


    public Funcionario(String nome, String cargo, String login, String senha, String cpf, boolean administrador, int idFuncionario) {
        this.Nome = nome;
        this.Cargo = cargo;
        this.Login = login;
        this.Senha = senha;
        this.cpf = cpf;
        this.administrador = administrador;
        this.idFuncionario = idFuncionario;
    }

    public Funcionario(){}

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public boolean getAdministrador() {return administrador;}

    public void setAdministrador(boolean admin) {this.administrador = admin;}

    public int getIdFuncionario() {return idFuncionario;}

    public void setIdFuncionario(int idFuncionario) {this.idFuncionario = idFuncionario;}

    public abstract double calcularSalario();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario that)) return false;
        return Objects.equals(getNome(), that.getNome()) && Objects.equals(getCargo(), that.getCargo()) && Objects.equals(getLogin(), that.getLogin()) && Objects.equals(getSenha(), that.getSenha());
    }

    public boolean compareTo(Funcionario funcionario){
        if(this.idFuncionario == funcionario.idFuncionario){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getCargo(), getLogin(), getSenha());
    }

    @Override
    public String toString(){
        if(this.administrador) {
            return "Administrador: " + this.getNome() + "\nID: " + this.getIdFuncionario() + "\nCPF: " + this.getCpf() + "\nCargo: " + this.getCargo() + "\nLogin: " + this.getLogin();
        } else {
            return "Atendente: " + this.getNome()+ "\nID: " + this.getIdFuncionario() + "\nCPF: " + this.getCpf() + "\nCargo: " + this.getCargo() + "\nLogin: " + this.getLogin();
        }
    }

    public String adicionarNaLista(){
        if(this.administrador) {
            return "Administrador: " + this.getNome() + " / ID: " + this.getIdFuncionario() + " / CPF: " + this.getCpf();
        } else {
            return "Cliente: " + this.getNome()+ " / ID: " + this.getIdFuncionario() + " / CPF: " + this.getCpf();
        }
    }
}
