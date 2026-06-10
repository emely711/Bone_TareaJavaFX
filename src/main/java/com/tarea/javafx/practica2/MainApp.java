package com.tarea.javafx.practica2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // PRÁCTICA 2: Se carga directamente Administrador.fxml
        // No pasa por Login ni por Cajero
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/fxml/practica2/Administrador.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Panel Administrador");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
