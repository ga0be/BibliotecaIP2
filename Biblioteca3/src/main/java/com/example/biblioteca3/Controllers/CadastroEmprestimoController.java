package com.example.biblioteca3.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CadastroEmprestimoController {

    @FXML private ComboBox<String> comboCliente;
    @FXML private ComboBox<String> comboLivro;
    @FXML private TextField txtDataEmprestimo;
    @FXML private TextField txtDataDevolucao;

    @FXML
    public void initialize() {
        // teste
        comboCliente.getItems().addAll("Maria Silva", "João Souza", "Ana Paula");
        comboLivro.getItems().addAll("Dom Casmurro", "O Hobbit", "1984");
    }

    @FXML
    public void confirmar() {
        String cliente = comboCliente.getValue();
        String livro = comboLivro.getValue();
        String dataEmprestimo = txtDataEmprestimo.getText();
        String dataDevolucao = txtDataDevolucao.getText();

        if (cliente == null || livro == null || dataEmprestimo.isEmpty() || dataDevolucao.isEmpty()) {
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Campos obrigatórios");
            erro.setContentText("Preencha todos os campos para confirmar o empréstimo.");
            erro.showAndWait();
            return;
        }

        // teste
        System.out.println("Empréstimo cadastrado:");
        System.out.println("Cliente: " + cliente);
        System.out.println("Livro: " + livro);
        System.out.println("Data Empréstimo: " + dataEmprestimo);
        System.out.println("Data Devolução: " + dataDevolucao);

        Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
        sucesso.setTitle("Empréstimo");
        sucesso.setHeaderText(null);
        sucesso.setContentText("Empréstimo registrado com sucesso!");
        sucesso.showAndWait();

        limparCampos();
    }

    @FXML
    public void limparCampos() {
        comboCliente.setValue(null);
        comboLivro.setValue(null);
        txtDataEmprestimo.clear();
        txtDataDevolucao.clear();
    }

    @FXML
    public void voltar() {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/com/example/bibliotecafx/dashboard.fxml")));
            Parent root = loader.load();

            Stage stage = (Stage) comboCliente.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Menu Principal");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("Erro");
            erro.setHeaderText("Não foi possível voltar");
            erro.setContentText("Verifique se o arquivo dashboard.fxml está correto.");
            erro.showAndWait();
        }
    }
}