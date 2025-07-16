package com.example.biblioteca3.Exceptions.Conta;

public class ContaNaoExisteException extends Exception {
    public ContaNaoExisteException() {
        super("Conta não encontrada.");
    }
}

