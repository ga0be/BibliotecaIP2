package com.example.biblioteca3.Controllers;

import com.example.biblioteca3.Negocio.ClassesBasicas.Funcionario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class DashBoardAtdntController {
    @FXML
    private Button btnFuncionarios;
    @FXML private Button btnCadastroLivro;
    @FXML private Button btnCadastroCliente;
    @FXML private Button btnCadastroEmprestimo;
    @FXML private Button btnRelatorios;

    private Funcionario cadastro;


    public Funcionario getCadastro(){
        return cadastro;
    }

    public void setCadastro(Funcionario cadastro){
        this.cadastro = cadastro;
    }



    @FXML
    public void abrirCadastroLivro() {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.changeScreen("cadastroLivro.fxml",
                "Pesquisa de livrosr");
    }

    @FXML
    public void abrirCadastroCliente() {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.changeScreen("cadastroCliente.fxml",
                "Cadastro de clientes");
    }

    @FXML
    public void abrirCadastroEmprestimo() {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.changeScreen("cadastroEmprestimo.fxml",
                "Painel de Emprestimos");
    }

    @FXML
    public void abrirRelatorios() {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.changeScreen("relatorios.fxml",
                "Visualização de relatorios");
    }


    @FXML
    public void sair() {
        this.setCadastro(null);
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.getLoginController().setFieldsNull();

        sceneManager.changeScreen("login.fxml", "Sistema de Biblioteca");
    }


}
