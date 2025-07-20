package com.example.biblioteca3.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class LoginController {

    @FXML private TextField txtLogin;
    @FXML private PasswordField txtSenha;
    @FXML private Label lblMensagem;

    @FXML
    public void entrar(ActionEvent event) {
        String login = txtLogin.getText();
        String senha = txtSenha.getText();

        try {
            String cargo = "";

            // teste
            if (login.equals("admin") && senha.equals("123")) {
                cargo = "admin";
            } else if (login.equals("atendente") && senha.equals("123")) {
                cargo = "atendente";
            } else {
                lblMensagem.setText("Login ou senha inválidos");
                return;
            }

            //  dashboard
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/com/example/bibliotecafx/dashboard.fxml")));
            Parent root = loader.load();


            DashboardController controller = loader.getController();
            controller.setCargo(cargo);

            Stage stage = (Stage) txtLogin.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Menu Principal");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            lblMensagem.setText("Erro ao carregar o sistema.");
        }
    }
}