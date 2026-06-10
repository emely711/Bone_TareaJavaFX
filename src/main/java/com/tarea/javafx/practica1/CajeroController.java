package com.tarea.javafx.practica1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CajeroController implements Initializable {

    @FXML private Label lblBienvenida;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblBienvenida.setText("Bienvenido, Cajero");
    }

    @FXML
    private void handleCerrarSesion() {
        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/practica1/Login.fxml"));
            Stage loginStage = new Stage();
            loginStage.setScene(new Scene(loader.load()));
            loginStage.setTitle("Login - Sistema");
            loginStage.setResizable(false);
            loginStage.show();

            Stage actual = (Stage) lblBienvenida.getScene().getWindow();
            actual.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
