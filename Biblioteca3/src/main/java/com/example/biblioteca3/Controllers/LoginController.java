package com.example.biblioteca3.Controllers;

import com.example.biblioteca3.Exceptions.Conta.ContaNaoExisteException;
import com.example.biblioteca3.Negocio.ClassesBasicas.Funcionario;
import com.example.biblioteca3.Negocio.Fachada;
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
    @FXML private Button btnEntrar;

    private Fachada fachada = Fachada.getInstance();

    @FXML
    public void entrar(ActionEvent event) {
        String login = txtLogin.getText();
        String senha = txtSenha.getText();

        Fachada fachada = Fachada.getInstance();
        Funcionario auxConta = null;
        SceneManager sceneManager = SceneManager.getInstance();

        try{
            auxConta = fachada.buscarContaPeloLogin(login);

            if(auxConta.getSenha().equals(senha)){
                if(!auxConta.getAdministrador()) {
                    //sceneManager.getPerfilClienteController().setCadastro(auxConta);
                    //sceneManager.getPerfilClienteController().initialize(auxConta);
                    sceneManager.changeScreen("dashboardAtendente.fxml", "Atendente - Central de Controle");
                } else{
                    sceneManager.changeScreen("dashboard.fxml", "Administrador - Central de Controle");
                }
            } else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("");
                alert.setTitle("Problema durante o login");
                alert.setContentText("Senha incorreta ");
                alert.show();
            }
        } catch(ContaNaoExisteException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("");
            alert.setTitle("Problema durante o login");
            alert.setContentText("Conta não existe");
            alert.show();
        }
    }

    public void setFieldsNull(){
        txtLogin.setText(null);
        txtSenha.setText(null);
    }
}
