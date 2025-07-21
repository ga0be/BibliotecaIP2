package com.example.biblioteca3.Controllers;

import com.example.biblioteca3.Exceptions.Conta.ContaJaExisteException;
import com.example.biblioteca3.Exceptions.OperacaoBemSucedidaException;
import com.example.biblioteca3.Negocio.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TelaCadastroAdmController {
    @FXML private TextField txtNomeAdm;
    @FXML private TextField txtCpf;
    @FXML private TextField txtLoginFuncionario;
    @FXML private PasswordField txtSenhaFuncionario;
    @FXML private TextField txtCargoFuncionario;
    @FXML private TextField txtSalario;


    @FXML
    public void adicionarFuncionario(ActionEvent event) {
        String nome = txtNomeAdm.getText();
        String cpf = txtCpf.getText();
        String login = txtLoginFuncionario.getText();
        String senha = txtSenhaFuncionario.getText();
        String cargo = txtCargoFuncionario.getText();
        String salario = txtSalario.getText();

        if(nome.isEmpty() || cpf.isEmpty() || login.isEmpty() ||
                cargo.isEmpty() || senha.isEmpty()  || salario.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao cadastrar Administrador");
            alert.setHeaderText(null);
            alert.setContentText("Preencha os campos");
            alert.show();
        } else{
            try {
                Fachada.getInstance().cadastrarAdministrador(nome, cpf, login, cargo, senha,  Integer.parseInt(txtSalario.getText()));
            } catch(ContaJaExisteException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro ao cadastrar Administrador");
                alert.setHeaderText(null);
                alert.setContentText("Conta já existe no repositorio.");
                alert.show();
            } catch(OperacaoBemSucedidaException e){
                this.setFieldsNull();
                SceneManager.getInstance().getAdminfuncionariosController().inicializar();
                SceneManager.getInstance().changeScreen("adminfuncionarios.fxml",
                        "Gerenciador de funcionários");

            } catch(Exception e){}
        }

        Alert sucesso = new Alert(Alert.AlertType.INFORMATION);
        sucesso.setHeaderText(null);
        sucesso.setContentText("Funcionário adicionado com sucesso!");
        sucesso.showAndWait();
    }


    private void setFieldsNull(){
        txtNomeAdm.setText("");
        txtCpf.setText("");
       txtLoginFuncionario.setText("");
        txtSenhaFuncionario.setText("");
         txtCargoFuncionario.setText("");
         txtSalario.setText("");
    }

    @FXML
    public void voltar() {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.changeScreen("dashboard.fxml",
                "Sistema De Biblioteca - Administrador");
    }
}


