package com.example.biblioteca3;


import com.example.biblioteca3.Controllers.SceneManager;
import com.example.biblioteca3.Negocio.CadastroFuncionario;
import com.example.biblioteca3.Negocio.Fachada;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class BibliotecaApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        SceneManager.setStage(stage);
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.changeScreen("login.fxml", "Sistema De Biblioteca");

        stage.show();
    }

    public static void main(String[] args) {

        Fachada fachada = Fachada.getInstance();

        try{
            fachada.cadastrarAdministrador("Sammuel", "Adm aux", "bradalsb", "Cigarropreto", "182927", 1650.0);;}
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(fachada.listarContas());

        BibliotecaApp.launch(args);
    }
}