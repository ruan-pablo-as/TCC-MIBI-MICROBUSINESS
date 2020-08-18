/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static JDBCC.AdministradorDAO.insereAdm;
import static JDBCC.AdministradorDAO.pegaAdm;
import Model.Administrador;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author r_pab
 */
public class ControllerPrincipal implements Initializable {

    @FXML
    private TextField user;
    @FXML
    private TextField nome;
    @FXML
    private PasswordField senha;
    @FXML
    private Button cad;
    @FXML
    private Button login;
    @FXML
    private Button cadNome;
    @FXML
    private Button voltar;

    public String us;
    public String sen;

    @FXML
    private void Cadastrar(ActionEvent event) {
        Alert c = new Alert(Alert.AlertType.WARNING);
        Administrador adm = new Administrador();
        adm.setUsers(user.getText());
        adm.setSenha(senha.getText());
        Administrador jaCadastrado = pegaAdm(adm.getUsers(), adm.getSenha());
        if (adm.getUsers().equals("") || adm.getSenha().equals("")) {
            c.setTitle("ATENÇÃO");
            c.setHeaderText("Usuário e/ou senha vazios");
            c.setContentText("Preencha-os para cadastrar.");
            c.showAndWait();

        } else if (adm.getUsers().length() < 3 || adm.getSenha().length() < 6) {
            c.setTitle("ATENÇÃO");
            c.setHeaderText("Usuário com caracteres insuficientes");
            c.setContentText("• O campo usuário não pode ter menos de 3 caracteres;\n"
                    + "• O campo senha não pode ter menos de 6 caracteres;");
            c.showAndWait();
        } else if (adm.getUsers().equals(jaCadastrado.getUsers()))  {
            System.out.println("adm "+adm.getSenha());
            System.out.println("jaCadastrado "+jaCadastrado.getSenha());
            c.setTitle("ATENÇÃO");
            c.setHeaderText("Usuário já está cadastrado");
            c.setContentText("Tente clicar no botão \"VOLTAR\" , preencher os dois campos solicitados"
                    + "e clicar no botão \"CADASTRAR\"");
            c.showAndWait();

        } else {
            try {
                if (nome.getText().equals("")) {
                    c.setTitle("ATENÇÃO");
                    c.setHeaderText("O campo nome está vazio");
                    c.setContentText("Preencha-o para cadastrar.");
                    c.showAndWait();
                } else {
                    adm.setNome(nome.getText());
                    insereAdm(adm);

                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("VERIFICAÇÃO DE CADASTRO");
                    a.setHeaderText("Campos digitados corretamente");
                    a.setContentText("Cadastro realizado com sucesso!");
                    a.showAndWait();
                    ChamaTabelaEmpresas CTE = new ChamaTabelaEmpresas();
                    ChamaCadastro.getStage().close();
                    CTE.start(new Stage());

                }
            } catch (Exception e) {
                e.getStackTrace();
                e.printStackTrace();
                System.out.println("erro Controller(CadastrarTT): " + e.getMessage());

            }
        }
    }

    @FXML
    private void RedirectCadastro(ActionEvent event) {
        ChamaCadastro CC = new ChamaCadastro();
        try {
            ChamaPrincipal.getStage().close();
            CC.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ControllerPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void RedirectLogin(ActionEvent event) {
        ChamaPrincipal CP = new ChamaPrincipal();
        try {
            ChamaCadastro.getStage().close();
            CP.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(ControllerPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loginUs(ActionEvent event) {
        Administrador adm = new Administrador();
        adm.setUsers(user.getText());
        adm.setSenha(senha.getText());
        Administrador jaCadastrado = pegaAdm(adm.getUsers(), adm.getSenha());
        if (adm.getUsers().equals("") || adm.getSenha().equals("")) {
            Alert c = new Alert(Alert.AlertType.WARNING);
            c.setTitle("VERIFICANDO A ENTRADA DE USUÁRIO");
            c.setHeaderText("Usuário e/ou Senha vazio(s)");
            c.setContentText("Preencha os campos antes de clicar em \"ENTRAR\"");
            c.showAndWait();
        } else if (!adm.getUsers().equals(jaCadastrado.getUsers())) {
            Alert c = new Alert(Alert.AlertType.WARNING);
            System.out.println("adm "+adm.getUsers());
            System.out.println("jaCadastrado "+jaCadastrado.getUsers());
            c.setTitle("VERIFICANDO A ENTRADA DE USUÁRIO");
            c.setHeaderText("Usuário/Senha não encontrado");
            c.setContentText("Verifique suas informações, caso ainda não tenha uma conta "
                    + "clique no botão \"CADASTRAR\"");
            c.showAndWait();

        } else {
            Alert c = new Alert(Alert.AlertType.INFORMATION);
            c.setTitle("VERIFICANDO A ENTRADA DE USUÁRIO");
            c.setHeaderText("Dados preenchidos corretamente");
            c.setContentText("Bem vindo, " + jaCadastrado.getNome() + "!");
            c.showAndWait();
            ChamaTabelaEmpresas CTE = new ChamaTabelaEmpresas();
            ChamaPrincipal.getStage().close();
            try {
                us = adm.getUsers();
                sen = adm.getSenha();
                CTE.setUs(us);
                CTE.setSen(sen);
                CTE.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(ControllerPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
    }

}
