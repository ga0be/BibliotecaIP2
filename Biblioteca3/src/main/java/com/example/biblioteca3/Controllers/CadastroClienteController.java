package com.example.biblioteca3.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class CadastroClienteController {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtEndereco;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtEmail;

    @FXML
    public void salvarCliente() {
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String endereco = txtEndereco.getText();
        String telefone = txtTelefone.getText();
        String email = txtEmail.getText();

        // teste
        System.out.println("Cliente cadastrado:");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Cadastro");
        alerta.setHeaderText(null);
        alerta.setContentText("Cliente cadastrado com sucesso!");
        alerta.showAndWait();

        limparCampos();
    }

    @FXML
    public void limparCampos() {
        txtNome.clear();
        txtCpf.clear();
        txtEndereco.clear();
        txtTelefone.clear();
        txtEmail.clear();
    }

    @FXML
    public void voltar() {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/com/example/bibliotecafx/dashboard.fxml")));
            Parent root = loader.load();

            Stage stage = (Stage) txtNome.getScene().getWindow();
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