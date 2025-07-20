package com.example.biblioteca3.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CadastroLivroController {

    @FXML private TextField txtTitulo;
    @FXML private TextField txtAutor;
    @FXML private TextField txtISBN;
    @FXML private TextField txtAno;
    @FXML private TextField txtCategoria;
    @FXML private TextField txtQuantidade;

    @FXML
    public void salvarLivro() {
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String isbn = txtISBN.getText();
        String ano = txtAno.getText();
        String categoria = txtCategoria.getText();
        String quantidade = txtQuantidade.getText();

        // backend
        System.out.println("Livro cadastrado:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Ano: " + ano);
        System.out.println("Categoria: " + categoria);
        System.out.println("Quantidade: " + quantidade);

        // sucesso
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Cadastro");
        alerta.setHeaderText(null);
        alerta.setContentText("Livro cadastrado com sucesso!");
        alerta.showAndWait();

        limparCampos();
    }

    @FXML
    public void limparCampos() {
        txtTitulo.clear();
        txtAutor.clear();
        txtISBN.clear();
        txtAno.clear();
        txtCategoria.clear();
        txtQuantidade.clear();
    }

    @FXML
    public void voltar() {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/com/example/bibliotecafx/dashboard.fxml")));
            Parent root = loader.load();

            Stage stage = (Stage) txtTitulo.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Menu Principal");
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setHeaderText("Erro ao voltar para o menu");
            erro.setContentText("Não foi possível carregar a tela principal.");
            erro.showAndWait();
        }
    }
}
