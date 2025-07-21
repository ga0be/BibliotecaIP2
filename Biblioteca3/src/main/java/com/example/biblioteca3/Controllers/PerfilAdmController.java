package com.example.biblioteca3.Controllers;

import com.example.biblioteca3.Negocio.ClassesBasicas.Administrador;
import com.example.biblioteca3.Negocio.ClassesBasicas.Atendente;
import com.example.biblioteca3.Negocio.ClassesBasicas.Funcionario;
import com.example.biblioteca3.Negocio.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PerfilAdmController {


    @FXML
    private Button VoltarButton;

    @FXML
    private Button RemoverUserButton;

    @FXML
    private Label nomeText;

    @FXML
    private Label cpfText;

    @FXML
    private Label cargoText;

    @FXML
    private Label salarioText;

    private Funcionario conta;

    private Funcionario cadastro;


    public Funcionario getCadastro(){
        return cadastro;
    }

    public void setCadastro(Funcionario cadastro){
        this.cadastro = cadastro;
    }

    @FXML
    void Remover(ActionEvent event){
        try {
            Fachada.getInstance().removerFuncionario(conta.getIdFuncionario());
        } catch (Exception ex) {}

        SceneManager.getInstance().getAdminfuncionariosController().inicializar();
        SceneManager.getInstance().changeScreen("adminfuncionarios.fxml",
                "Gerenciador de funcionarios");

    }

    @FXML
    void Voltar(ActionEvent event){
        SceneManager.getInstance().changeScreen("adminfuncionarios.fxml",
                "Gerenciador de funcionarios");
    }


    public void initialize(Funcionario conta){
        this.conta = conta;
        nomeText.setText(conta.getNome());
        cpfText.setText(conta.getCpf());
        cargoText.setText(conta.getCargo());
        if(conta instanceof Administrador){
            salarioText.setText("RS " + ((Administrador) conta).getSalario());
    }else{salarioText.setText("RS " + ((Atendente) conta).calcularSalario());}
}
}
