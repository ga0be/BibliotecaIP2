package com.example.biblioteca3.Controllers;

import com.example.biblioteca3.Exceptions.Conta.ContaJaExisteException;
import com.example.biblioteca3.Exceptions.OperacaoBemSucedidaException;
import com.example.biblioteca3.Negocio.Fachada;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TelaCadastroAtdntController {
    @FXML private TextField txtNomeAtendente;
    @FXML private TextField txtCpf;
    @FXML private TextField txtLoginFuncionario;
    @FXML private PasswordField txtSenhaFuncionario;
    @FXML private TextField txtCargoFuncionario;
    @FXML private TextField txtTurno;
    @FXML private TextField txtRemuneracao;
    @FXML private TextField txtHoras;



    @FXML
    public void adicionarFuncionario() {
        String nome = txtNomeAtendente.getText();
        String cpf = txtCpf.getText();
        String login = txtLoginFuncionario.getText();
        String senha = txtSenhaFuncionario.getText();
        String cargo = txtCargoFuncionario.getText();
        String turno = txtTurno.getText();
        String remuneracao = txtRemuneracao.getText();
        String horas = txtHoras.getText();

        if (nome.isEmpty() || cpf.isEmpty() || login.isEmpty() ||
                cargo.isEmpty() || senha.isEmpty() || turno.isEmpty()  || remuneracao.isEmpty()  || horas.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro ao cadastrar Administrador");
            alert.setHeaderText(null);
            alert.setContentText("Preencha os campos");
            alert.show();
        } else {
            try {
                Fachada.getInstance().cadastrarAtendente(nome, cpf, login, cargo, senha, turno, Integer.parseInt(txtRemuneracao.getText()), Integer.parseInt(txtHoras.getText()));
            } catch (ContaJaExisteException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro ao cadastrar Administrador");
                alert.setHeaderText(null);
                alert.setContentText("Conta já existe no repositorio.");
                alert.show();
            } catch (OperacaoBemSucedidaException e) {
                this.setFieldsNull();
                SceneManager.getInstance().getAdminfuncionariosController().inicializar();
                SceneManager.getInstance().changeScreen("adminfuncionarios.fxml",
                        "Gerenciador de funcionarios");

            } catch (Exception e) {
            }
        }
    }

    private void setFieldsNull(){
        txtNomeAtendente.setText("");
        txtCpf.setText("");
        txtLoginFuncionario.setText("");
        txtSenhaFuncionario.setText("");
        txtCargoFuncionario.setText("");
        txtTurno.setText("");
        txtRemuneracao.setText("");
        txtHoras.setText("");
    }





    public void voltar(){
            SceneManager sceneManager = SceneManager.getInstance();
            sceneManager.changeScreen("dashboard.fxml",
                    "Sistema De Biblioteca - Administrador");
        }
    }



