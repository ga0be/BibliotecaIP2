package com.example.biblioteca3.Exceptions;

public class RepositorioCheioException extends Exception{
       public RepositorioCheioException() {
           super("Repositório está cheio. Não é possível cadastrar mais itens.");}
}

