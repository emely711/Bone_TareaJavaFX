package com.tarea.javafx.practica2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML private Label lblTitulo;
    @FXML private Label lblInfo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblTitulo.setText("Panel de Administrador");
        lblInfo.setText("Aplicación iniciada directamente en el panel de administrador.\n"
                      + "No hay Login ni navegación.");
    }
}
