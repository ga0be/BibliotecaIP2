package com.example.biblioteca3.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashboardController {

    @FXML private Button btnFuncionarios;
    @FXML private Button btnCadastroLivro;
    @FXML private Button btnCadastroCliente;
    @FXML private Button btnCadastroEmprestimo;
    @FXML private Button btnRelatorios;

    public void setCargo(String cargo) {
        if (!"admin".equals(cargo)) {
            btnFuncionarios.setVisible(false);
            btnFuncionarios.setManaged(false);
        }
    }

    @FXML
    public void abrirCadastroLivro() {
        carregarTela("/com/example/bibliotecafx/cadastroLivro.fxml", "Cadastro de Livro");
    }

    @FXML
    public void abrirCadastroCliente() {
        carregarTela("/com/example/bibliotecafx/cadastroCliente.fxml", "Cadastro de Cliente");
    }

    @FXML
    public void abrirCadastroEmprestimo() {
        carregarTela("/com/example/bibliotecafx/cadastroEmprestimo.fxml", "Cadastro de Empréstimo");
    }

    @FXML
    public void abrirRelatorios() {
        carregarTela("/com/example/bibliotecafx/relatorios.fxml", "Relatórios");
    }

    @FXML
    public void abrirFuncionarios() {
        carregarTela("/com/example/bibliotecafx/adminFuncionarios.fxml", "Cadastro de Funcionários");
    }

    @FXML
    public void sair() {
        System.exit(0);
    }


    private void carregarTela(String caminhoFXML, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(caminhoFXML)));
            Parent root = loader.load();

            Stage stage = (Stage) btnCadastroLivro.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(titulo);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
