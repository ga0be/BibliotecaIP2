package com.example.biblioteca3.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    private static SceneManager instance;
    private static Stage stage;

    private Scene adminfuncionarios;
    private Scene cadastroCliente;
    private Scene cadastroEmprestimo;
    private Scene cadastroLivro;
    private Scene dashboard;
    private Scene login;
    private Scene relatorios;
    private Scene dashboardAtendente;
    private Scene perfilcliente;
    private Scene telacadastroAdm;
    private Scene telacadastroAtdnt;
    private Scene perfilfuncionario;
    private Scene perfilatdnt;

    private AdminFuncionariosController adminfuncionariosController;
    private CadastroClienteController cadastroClienteController;
    private CadastroEmprestimoController cadastroEmprestimoController;
    private CadastroLivroController cadastroLivroController;
    private DashboardController dashboardController;
    private LoginController loginController;
    private RelatoriosController relatoriosController;
    private DashBoardAtdntController dashboardatdntController;
    private PerfilClienteController perfilclienteController;
    private TelaCadastroAdmController telaCadastroAdmController;
    private TelaCadastroAtdntController telaCadastroAtdntController;
    private PerfilAdmController perfilfuncionarioController;



    private SceneManager(){
        this.screenLoader();
    }

    public static SceneManager getInstance(){
        if(instance == null){
            instance = new SceneManager();
        }

        return instance;
    }



    public static void setStage(Stage stage){ SceneManager.stage = stage; }

    public static Stage getStage(){ return stage; }



    public Scene getAdminfuncionarios(){ return this.adminfuncionarios; }

    public Scene getCadastroCliente(){ return this.cadastroCliente; }

    public Scene getCadastroEmprestimo(){ return this.cadastroEmprestimo; }

    public Scene getCadastroLivro(){ return this.cadastroLivro; }

    public Scene getDashboard(){ return this.dashboard; }

    public Scene getLogin(){ return this.login; }

    public Scene getRelatorios(){ return this.relatorios; }

    public Scene getDashboardAtendente(){ return this.dashboardAtendente; }

    public Scene getPerfilcliente(){ return this.perfilcliente; }

    public Scene getTelacadastroAdm(){ return this.telacadastroAdm; }

    public Scene getTelacadastroAtdnt(){ return this.telacadastroAtdnt; }

    public Scene getPerfilAdm(){ return this.perfilfuncionario; }

    public Scene getPerfilatdnt(){ return this.perfilatdnt; }






    public AdminFuncionariosController getAdminfuncionariosController(){ return this.adminfuncionariosController; }

    public CadastroClienteController getCadastriclienteController(){ return this.cadastroClienteController; }

    public CadastroEmprestimoController getCadastroEmprestimoController() { return this.cadastroEmprestimoController; }

    public CadastroLivroController getLivroController() { return this.cadastroLivroController; }

    public DashboardController getDashboardController() { return this.dashboardController; }

    public LoginController getLoginController(){ return this.loginController; }

    public RelatoriosController getRelatoriosController(){ return this.relatoriosController; }

    public DashBoardAtdntController getDashboardatdntController(){ return this.dashboardatdntController; }

    public PerfilClienteController getPerfilclienteController() { return this.perfilclienteController; }

    public TelaCadastroAdmController getTelaCadastroAdmController() { return this.telaCadastroAdmController; }

    public TelaCadastroAtdntController getTelaCadastroAtdntController() { return this.telaCadastroAtdntController; }

    public PerfilAdmController getPerfilAdmController() { return this.perfilfuncionarioController; }






    private void screenLoader(){
        try {
            FXMLLoader fxmlLoader = null;

            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/biblioteca3/login.fxml"));
            this.login = new Scene(fxmlLoader.load());
            this.loginController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/biblioteca3/adminfuncionarios.fxml"));
            this.adminfuncionarios = new Scene(fxmlLoader.load());
            this.adminfuncionariosController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/biblioteca3/cadastroCliente.fxml"));
            this.cadastroCliente = new Scene(fxmlLoader.load());
            this.cadastroClienteController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/biblioteca3/cadastroEmprestimo.fxml"));
            this.cadastroEmprestimo = new Scene(fxmlLoader.load());
            this.cadastroEmprestimoController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/biblioteca3/cadastroLivro.fxml"));
            this.cadastroLivro = new Scene(fxmlLoader.load());
            this.cadastroLivroController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/biblioteca3/dashboard.fxml"));
            this.dashboard = new Scene(fxmlLoader.load());
            this.dashboardController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/biblioteca3/relatorios.fxml"));
            this.relatorios = new Scene(fxmlLoader.load());
            this.relatoriosController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/biblioteca3/dashboardAtendente.fxml"));
            this.dashboardAtendente = new Scene(fxmlLoader.load());
            this.dashboardatdntController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/biblioteca3/PerfilCliente.fxml"));
            this.perfilcliente= new Scene(fxmlLoader.load());
            this.perfilclienteController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/biblioteca3/TelaCadastroAdm.fxml"));
            this.telacadastroAdm = new Scene(fxmlLoader.load());
            this.telaCadastroAdmController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/biblioteca3/TelaCadastroAtdnt.fxml"));
            this.telacadastroAtdnt = new Scene(fxmlLoader.load());
            this.telaCadastroAtdntController = fxmlLoader.getController();

            fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/biblioteca3/PerfilFuncionario.fxml"));
            this.perfilfuncionario= new Scene(fxmlLoader.load());
            this.perfilfuncionarioController = fxmlLoader.getController();



        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void changeScreen(String fileNameFxml, String titleScreen){
        boolean max = stage.isMaximized();
        if(max){ stage.setMaximized(false); }

        switch(fileNameFxml){
            case "adminfuncionarios.fxml" -> stage.setScene(this.adminfuncionarios);
            case "cadastroCliente.fxml" -> stage.setScene(this.cadastroCliente);
            case "cadastroEmprestimo.fxml" -> stage.setScene(this.cadastroEmprestimo);
            case "cadastroLivro.fxml" -> stage.setScene(this.cadastroLivro);
            case "dashboard.fxml" -> stage.setScene(this.dashboard);
            case "login.fxml" -> stage.setScene(this.login);
            case "relatorios.fxml" -> stage.setScene(this.relatorios);
            case "dashboardAtendente.fxml" -> stage.setScene(this.dashboardAtendente);
            case "PerfilCliente.fxml" -> stage.setScene(this.perfilcliente);
            case "TelaCadastroAdm.fxml" -> stage.setScene(this.telacadastroAdm);
            case "TelaCadastroAtdnt.fxml" -> stage.setScene(this.telacadastroAtdnt);
            case "PerfilFuncionario.fxml" -> stage.setScene(this.perfilfuncionario);
            case "perfilAtdnt.fxml" -> stage.setScene(this.perfilatdnt);
            default -> {
                System.out.println("Erro ao trocar de tela");
                System.exit(0);
            }
        }
        stage.setTitle(titleScreen);

        if(max){ stage.setMaximized(true);}
    }
}
