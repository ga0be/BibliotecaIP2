package com.example.biblioteca3.Controllers;

import com.example.biblioteca3.Exceptions.Conta.ContaNaoExisteException;
import com.example.biblioteca3.Exceptions.OperacaoBemSucedidaException;
import com.example.biblioteca3.Negocio.ClassesBasicas.Funcionario;
import com.example.biblioteca3.Negocio.Fachada;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    private Button btnVoltar;

    @FXML
    private Button btnAddAdm;

    @FXML
    private Button btnAddAtdnt;

    @FXML
    private ListView<String> ListaUsuarios;

    private Funcionario[] contas;

    @FXML
    public void voltar(){
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.changeScreen("dashboard.fxml",
                "Sistema De Biblioteca - Administrador");
    }

    public void inicializar() {
        Fachada fachada = Fachada.getInstance();
        Funcionario[] auxConta = fachada.getListaContas();
        Funcionario  cadastro = SceneManager.getInstance().getPerfilAdmController().getCadastro();
        ListaUsuarios.getItems().clear();
        contas = auxConta;

        for(int i = 0; i < auxConta.length; i++){
            if(auxConta[i] != null && (cadastro == null || !auxConta[i].compareTo(cadastro))){
                ListaUsuarios.getItems().add(auxConta[i].adicionarNaLista());
            }
        }

        ListaUsuarios.getSelectionModel().selectedItemProperty().addListener( new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                SceneManager.getInstance().changeScreen("PerfilFuncionario.fxml", "Perfil - Funcionário");
                Funcionario auxConta = null;
                for(int i = 0; i < contas.length; i++){
                    if(contas[i] != null && t1.equals(contas[i].adicionarNaLista())){
                        auxConta = contas[i];
                        break;
                    }
                }
                SceneManager.getInstance().getPerfilAdmController().initialize(auxConta);
            }
        });
    }

    @FXML
    void HandleAdm(ActionEvent event){
        SceneManager.getInstance().changeScreen("TelaCadastroAdm.fxml",
                "Cadastro");
    }

    @FXML
    void HandleAtdnt(ActionEvent event){
        SceneManager.getInstance().changeScreen("TelaCadastroAtdnt.fxml",
                "Cadastro");
    }



}
