package com.example.biblioteca3.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RelatoriosController {

    @FXML
    public void abrirRelatorioLivros() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Relatório de Livros");
        alerta.setHeaderText(null);
        alerta.setContentText("Aqui você verá os livros cadastrados (em breve).");
        alerta.showAndWait();
    }

    @FXML
    public void abrirRelatorioClientes() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Relatório de Clientes");
        alerta.setHeaderText(null);
        alerta.setContentText("Aqui você verá os clientes cadastrados (em breve).");
        alerta.showAndWait();
    }

    @FXML
    public void abrirRelatorioEmprestimos() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Relatório de Empréstimos");
        alerta.setHeaderText(null);
        alerta.setContentText("Aqui você verá os empréstimos realizados (em breve).");
        alerta.showAndWait();
    }

    @FXML
    public void voltar() {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/com/example/bibliotecafx/dashboard.fxml")));
            Parent root = loader.load();

            Stage stage = (Stage) root.getScene().getWindow();
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