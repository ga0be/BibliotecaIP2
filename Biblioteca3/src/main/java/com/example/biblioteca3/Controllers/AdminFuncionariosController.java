package com.example.biblioteca3.Controllers;

import com.example.biblioteca3.Negocio.ClassesBasicas.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminFuncionariosController {

    @FXML
    private TextField txtNomeFuncionario;
    @FXML private TextField txtLoginFuncionario;
    @FXML private PasswordField txtSenhaFuncionario;
    @FXML private TextField txtCargoFuncionario;

    @FXML private TableView<Funcionario> tabelaFuncionarios;
    @FXML private TableColumn<Funcionario, String> colNome;
    @FXML private TableColumn<Funcionario, String> colLogin;
    @FXML private TableColumn<Funcionario, String> colSenha;
    @FXML private TableColumn<Funcionario, String> colCargo;

    private final ObservableList<Funcionario> listaFuncionarios = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        colSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));

        tabelaFuncionarios.setItems(listaFuncionarios);
    }

    @FXML
    public void adicionarFuncionario() {
        String nome = txtNomeFuncionario.getText();
        String login = txtLoginFuncionario.getText();
        String senha = txtSenhaFuncionario.getText();
        String cargo = txtCargoFuncionario.getText();

        if (nome.isEmpty() || login.isEmpty() || senha.isEmpty() || cargo.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Campos obrigatórios");
            alerta.setContentText("Preencha todos os campos para adicionar o funcionário.");
            alerta.showAndWait();
            return;
        }

        //Funcionario funcionario = new Funcionario(nome, login, senha, cargo);
        //listaFuncionarios.add(funcionario);

        limparCampos();

        Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
        sucesso.setHeaderText(null);
        sucesso.setContentText("Funcionário adicionado com sucesso!");
        sucesso.showAndWait();
    }

    private void limparCampos() {
        txtNomeFuncionario.clear();
        txtLoginFuncionario.clear();
        txtSenhaFuncionario.clear();
        txtCargoFuncionario.clear();
    }

    @FXML
    public void voltar() {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/com/example/bibliotecafx/dashboard.fxml")));
            Parent root = loader.load();

            Stage stage = (Stage) txtNomeFuncionario.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Menu Principal");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Erro ao voltar");
            erro.setContentText("Verifique se o arquivo dashboard.fxml está correto.");
            erro.showAndWait();
        }
    }
}
