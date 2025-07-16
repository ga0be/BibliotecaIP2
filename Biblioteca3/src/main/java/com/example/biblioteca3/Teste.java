package com.example.biblioteca3;

import com.example.biblioteca3.Negocio.CadastroFuncionario;

public class Teste {
    public static void main(String[] args) {

        //System.out.println("\n\n ---------- LIVRO --------- \n\n");


       // Livro livroDefault = new Livro();
        //System.out.println(livroDefault.getAutor());

        //Livro livroNovo = new Livro("1984", "Fulano de tal", "Ficção Científica", 1, "92829", 5, 1950, true);

        //comparando livros ->
        //System.out.println(livroNovo.equals(livroDefault));

        //mudando o nome do autor->
        // livroDefault.setAutor("Fulano de tal");
        //System.out.println(livroDefault.getAutor());

        //System.out.println("\n\n ---------- CLIENTE --------- \n\n");

        //Cliente cliente1 = new Cliente("Gabriel", "145", "819", "Marte", "gabriel@gmail.com", 1);
        //System.out.println(cliente1);

        //System.out.println("\n\n ---------- FUNCIONARIO --------- \n\n");

        //Funcionario funcionario1 = new Funcionario("Rafaelly@hotmail.com", "Ajudante de livros", "Rafelly" , "123");
        //System.out.println(funcionario1);


        //System.out.println("\n\n ---------- EMPRÉSTIMO ---------");

        //Emprestimo emprestimo1 = new Emprestimo(1, LocalDate.of(2025, 5, 19), LocalDate.of(2025, 6, 19), cliente1, livroNovo);
        //System.out.println(emprestimo1);

        //Emprestimo emprestimoIgual = new Emprestimo(1, LocalDate.of(2025, 5, 19), LocalDate.of(2025, 6, 19), cliente1, livroNovo);
        //System.out.println("\n\n" + emprestimo1.equals(emprestimoIgual));

        //Livro livroNovo2 = new Livro("Fina flor da malandragem", "Carlos Didier", "historiografia", 2, "8790", 3, 2022, true);

        //Cliente cliente2 = new Cliente("Cristina", "111", "219", "Paquetá", "Cristina@gmail.com", 2);

        // Emprestimo emprestimo2 = new Emprestimo(2, LocalDate.of(2024, 12, 23), LocalDate.of(2025, 3, 12), cliente2, livroNovo2);
        //System.out.println(emprestimo2);

        //System.out.println("\n\n" + emprestimo2.equals(emprestimo1));

        //System.out.println(emprestimo2.getLivro());

        //emprestimo2.setLivro(livroNovo);
        //System.out.println("\n\n" + emprestimo2.getLivro());

        //System.out.println("======LIVRO======");
        //RepositorioLivro repositorioLivro = RepositorioLivro.getInstance();
        //Livro Livro1 = new Livro("1984", "George Orwell", "Ficção Científica", 1, "123456789", 1, 2005, true);
        // Livro Livro2 = new Livro("História de fulano", "Fulano de tal", "Biografia", 1, "1444", 1, 2010, true);
        //try {
        //repositorioLivro.adicionar(Livro1);
        //System.out.println("Livro adicionado na posição " + repositorioLivro.procurarIndice(Livro1.getIdLivro()));
        //} catch (Exception e) {
        // print(e.getMessage());
        //}

        // try {repositorioLivro.adicionar(Livro2);
        // System.out.println("Livro adicionado na posição " + repositorioLivro.procurarIndice(Livro2.getIdLivro()));
        // } catch (Exception e) {
        //  print(e.getMessage());}
        // try {repositorioLivro.procurar(Livro2.getIdLivro());
        // System.out.println("Livro " + repositorioLivro.procurar(Livro2.getIdLivro()));
        // } catch (Exception e) {
        //print(e.getMessage());}

        CadastroFuncionario repositorio = CadastroFuncionario.getInstance();

        try{
        repositorio.cadastrarAdministrador("Nelson", "Adm", "Nelson2002", "Neruda", "182927", 1650.0);
        repositorio.cadastrarAdministrador("Angela", "Adm", "Angela145", "Tristezasnaopagamdividas", "1234", 1650.0);
        repositorio.cadastrarAtendente("Seu Bartolomeu", "Atendente", "Bartoz89", "lajescriptograficas", "31415", "Manhã", 40.5, 5.0);
        repositorio.cadastrarAtendente("Dona Carola", "Atendente", "Carororo123", "decamisola", "9265", "tarde", 40.5, 5.0);}
        catch (Exception e){
            print(e.getMessage());
        }

        print("\n----LISTANDO CADASTROS REALIZADOS----");

       print(repositorio.listarContas());

        try{
        repositorio.removerFuncionario(3);}
        catch (Exception e){ print(e.getMessage()); }

        print("\n-------------TESTANDO REMOÇÃO-----------\n");

        print(repositorio.listarContas());

        print("\n----TESTANDO BUSCA----\n");

        try{repositorio.buscarFuncionario(3);}
        catch (Exception e){ print(e.getMessage()); }

       print("\n----TESTANDO Atualizações----\n-");

       try{repositorio.atualizarAtendente("Cristina", "Atendente-chefe", "DiabaLoura23", "Noelary", "121950", 4,"Tarde",65.50, 5.0);}
       catch (Exception e){ print(e.getMessage()); }

       print(repositorio.listarContas());









    }

    public static void print(String line) {
        System.out.println(line);


    }
}