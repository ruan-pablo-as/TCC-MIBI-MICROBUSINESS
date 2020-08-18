/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static JDBCC.AdministradorDAO.pegaAdm;
import Model.Administrador;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author r_pab
 */
public class ChamaTabelaEmpresas extends Application {
    
    private static Stage stage;
    private Administrador adm;
    private String us;
    private String sen;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TabelaEmpresas.fxml"));
        setAdm(pegaAdm(getUs(), getSen()));
        Scene scene = new Scene(root);
        stage.setTitle("Bem-Vindo, Administador");
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage aStage) {
        stage = aStage;
    }

    public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getSen() {
        return sen;
    }

    public void setSen(String sen) {
        this.sen = sen;
    }
}
