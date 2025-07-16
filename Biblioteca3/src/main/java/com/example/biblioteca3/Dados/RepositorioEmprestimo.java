package com.example.biblioteca3.Dados;



import com.example.biblioteca3.Exceptions.Emprestimo.NenhumEmprestimoException;
import com.example.biblioteca3.Interfaces.RepositorioEmprestimoInterface;
import com.example.biblioteca3.Negocio.ClassesBasicas.Emprestimo;

import java.time.LocalDate;

public class RepositorioEmprestimo implements RepositorioEmprestimoInterface {

    private Emprestimo[] emprestimos;
    private int contador;
    private int tamanho;
    private static RepositorioEmprestimo instance;

    private RepositorioEmprestimo(int tamanho) {
        this.emprestimos = new Emprestimo[tamanho];
        this.contador = 0;
        this.tamanho = tamanho;
    }

    public static RepositorioEmprestimo getInstance() {
        if (instance == null) {
            instance = new RepositorioEmprestimo(100);
        }
        return instance;
    }


    public void adicionarEmprestimo(Emprestimo emprestimo)  {
        if (contador < this.tamanho) {
            this.emprestimos[contador] = emprestimo;
        }
        contador++;
    }

    private int buscarIndex(int numero) {
        for (int i = 0; i < this.contador; i++) {
            if (this.emprestimos[i].getNumero() == numero) {
                return i;
            }
        }
        return -1;
    }

    public void removerEmprestimo(int numero) {
        int aux = this.buscarIndex(numero);

        if (aux != -1) {
            for (int i = aux; i < contador; i++) {
                if (i < contador - 1) {
                    this.emprestimos[i] = this.emprestimos[i + 1];
                } else {
                    this.emprestimos[i] = null;
                }
            }
        }

        contador--;
    }

    public Emprestimo buscarEmprestimo(int numero) {
        int aux = this.buscarIndex(numero);

        if (aux != -1) {
            return this.emprestimos[aux];
        }
        return null;
    }

    public void atualizarEmprestimo(Emprestimo emprestimoAtualizado) {
        int aux = this.buscarIndex(emprestimoAtualizado.getNumero());
        if (aux != -1) {
            this.emprestimos[aux] = emprestimoAtualizado;
        }
    }

    public Emprestimo[] buscarEmprestimosPorCliente(int idCliente) throws NenhumEmprestimoException {
        Emprestimo[] auxEmprestimos = new Emprestimo[this.tamanho];
        int auxContador = 0;

        for (int i = 0; i < this.tamanho; i++) {
            if (this.emprestimos[i] != null && this.emprestimos[i].getCliente().getIdCliente() == idCliente) {
                auxEmprestimos[auxContador] = this.emprestimos[i];
                auxContador++;
            }
        }
        if (auxContador == 0) {
            throw new NenhumEmprestimoException();
        }

        Emprestimo[] retorno = new Emprestimo[auxContador];

        for (int i = 0; i < auxContador; i++) {
            retorno[i] = auxEmprestimos[i];
        }

        return retorno;
    }

    public Emprestimo[] buscarEmprestimosPorLivro(int IdLivro) throws NenhumEmprestimoException {
        Emprestimo[] resultado = new Emprestimo[this.tamanho];
        int auxj = 0;

        for (int i = 0; i < this.tamanho; i++) {
            if (this.emprestimos[i] != null && this.emprestimos[i].getLivro().getIdLivro() == IdLivro) {
                resultado[auxj] = this.emprestimos[i];
                auxj++;
            }
        }
        if (auxj == 0) {
            throw new NenhumEmprestimoException();
        }

        Emprestimo[] resultado2 = new Emprestimo[auxj];

        for (int i = 0; i < auxj; i++) {
            resultado2[i] = resultado[i];
        }

        return resultado2;
    }

    public Emprestimo[] buscarEmprestimosPorPeriodo(LocalDate DataEmprestimo, LocalDate DataDevolucao) throws NenhumEmprestimoException {

        int encontradas = 0;

        for (int i = 0; i < this.contador; i++) {
            Emprestimo emprestimo = this.emprestimos[i];
            if (emprestimo != null) {
                LocalDate emprestimoDataEmprestimo = emprestimo.getDataEmprestimo();
                LocalDate emprestimoDataDevolucao = emprestimo.getDataDevolucao();

                if ((emprestimoDataEmprestimo.isBefore(DataDevolucao) || emprestimoDataEmprestimo.isEqual(DataDevolucao)) &&
                        (emprestimoDataDevolucao.isAfter(DataEmprestimo) || emprestimoDataDevolucao.isEqual(DataEmprestimo))) {
                    encontradas++;
                }
            }
        }

        if (encontradas == 0) {
            throw new NenhumEmprestimoException();
        }

        Emprestimo[] emprestimosDentroDoPeriodo = new Emprestimo[encontradas];
        int index = 0;

        for (int i = 0; i < this.contador; i++) {
            Emprestimo emprestimo = this.emprestimos[i];
            if (emprestimo != null) {
                LocalDate emprestimoDataEmprestimo = emprestimo.getDataEmprestimo();
                LocalDate emprestimoDataDevolucao = emprestimo.getDataDevolucao();

                if ((emprestimoDataEmprestimo.isBefore(DataDevolucao) || emprestimoDataEmprestimo.isEqual(DataDevolucao)) &&
                        (emprestimoDataDevolucao.isAfter(DataEmprestimo) || emprestimoDataDevolucao.isEqual(DataEmprestimo)))  {
                    emprestimosDentroDoPeriodo[index] = emprestimo;
                    index++;
                }
            }
        }

        return emprestimosDentroDoPeriodo;
    }


    public String toString() {
        String resultado = "\n\nLista de reservas: \n\n";

        for (int i = 0; i < contador; i++) {
            resultado += emprestimos[i].toString() + "\n";
        }

        return resultado;
    }

    public String Relatorio(Emprestimo[] emprestimosFiltrados) {
        String relatoriozinho = "";


        for (int i = 0; i < emprestimosFiltrados.length; i++) {

            relatoriozinho += emprestimosFiltrados[i].gerarRelatorio() + "\n";
        }

        return relatoriozinho;
    }

    public String gerarRelatorioPorCliente(int idCliente) throws NenhumEmprestimoException {

        Emprestimo[] emprestimosDoCliente = buscarEmprestimosPorCliente(idCliente);

        return Relatorio(emprestimosDoCliente);
    }


}



