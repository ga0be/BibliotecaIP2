package com.example.biblioteca3.Exceptions;

public class DataInvalidaException extends Exception {
  public DataInvalidaException() {
    super("A data final deve ser posterior à data inicial");
  }
}
