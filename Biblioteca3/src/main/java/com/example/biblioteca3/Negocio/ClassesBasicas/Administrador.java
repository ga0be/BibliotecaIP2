package com.example.biblioteca3.Negocio.ClassesBasicas;

public class Administrador extends Funcionario{

    private double salario;

    public Administrador(String nome, String cargo, String login, String senha, String cpf, int idFuncionario, double salario) {
        super(nome, cargo, login, senha, cpf,true, idFuncionario);
        this.setSalario(salario);
    }


    public double calcularSalario() {
        return getSalario();    }

    public void setSalario(double salario) {
        this.salario = this.salario < 0.0 ? 0.0 : salario;
    }

    public double getSalario() {
        return salario;
    }

    public String toString() {
        return super.toString() + "\nSalario: " + salario;
    }


}
