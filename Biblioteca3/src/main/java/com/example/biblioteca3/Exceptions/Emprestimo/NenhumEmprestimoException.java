package com.example.biblioteca3.Exceptions.Emprestimo;

public class NenhumEmprestimoException extends Exception {
  public NenhumEmprestimoException(){
    super("Nenhum emprestimo encontrado!");
  }
}
