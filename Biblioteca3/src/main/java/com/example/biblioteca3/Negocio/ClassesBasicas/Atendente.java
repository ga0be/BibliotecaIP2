package com.example.biblioteca3.Negocio.ClassesBasicas;

public class Atendente extends Funcionario {

    private String turno;
    private double remuneracao;
    private double horas;

    public Atendente(String nome, String cargo, String login, String senha, String cpf, int idFuncionario, String turno, double remuneracao, double horas) {
        super(nome, cargo, login, senha, cpf, false, idFuncionario);
        this.turno = turno;
        this.setRemuneracao(remuneracao);
        this.setHoras(horas);
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getRemuneracao() {
        return remuneracao;
    }

    public double getHoras() {
        return horas;
    }

    public void setRemuneracao(double remuneracao) {
        this.remuneracao = remuneracao < 0 ? 0 : remuneracao;
    }

    public void setHoras(double horas) {
        this.horas = horas < 0 ? 0 : horas;
    }


    public double calcularSalario() {
        if (getHoras() >= 30) {
            return getRemuneracao() * getHoras();}
        else {
            return getRemuneracao() * (30 - getHoras()) * 2.0 + getRemuneracao() * 30;}
    }

    public String toString() {
        return super.toString() + "\nTurno: " + getTurno() + "\nHoras de trabalho: " + getHoras() + " horas" + "\nRemuneração: " + getRemuneracao();
    }


}
