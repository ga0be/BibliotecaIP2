package com.example.biblioteca3.Negocio.ClassesBasicas;

import java.util.Objects;

public class Cliente {
    private String Nome;
    private String Cpf;
    private String Endereco;
    private String Telefone;
    private String Email;
    private int IdCliente;


    public Cliente(String nome, String cpf, String telefone, String endereco, String email, int idCliente) {
        this.Nome = nome;
        this.Cpf = cpf;
        this.Telefone = telefone;
        this.Endereco = endereco;
        this.Email = email;
        this.IdCliente = idCliente;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getIdCliente() {return IdCliente;}

    public void setIdCliente(int idCliente) {IdCliente = idCliente;}

    @Override
    public String toString() {
        return "Cliente: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nTelefone: " + this.getTelefone() + "\nEndereço: " + this.getEndereco() + "\nEmail: " + this.getEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(getNome(), cliente.getNome()) && Objects.equals(getCpf(), cliente.getCpf()) && Objects.equals(getEndereco(), cliente.getEndereco()) && Objects.equals(getTelefone(), cliente.getTelefone()) && Objects.equals(getEmail(), cliente.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getCpf(), getEndereco(), getTelefone(), getEmail());
    }
}
