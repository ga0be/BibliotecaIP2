package com.example.biblioteca3;


import com.example.biblioteca3.Controllers.SceneManager;
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
        BibliotecaApp.launch(args);
    }
}