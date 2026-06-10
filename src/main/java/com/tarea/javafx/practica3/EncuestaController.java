package com.tarea.javafx.practica3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class EncuestaController implements Initializable {

    // --- Pregunta 1 ---
    @FXML private ToggleGroup tgP1;
    @FXML private RadioButton rbP1A, rbP1B, rbP1C, rbP1D;

    // --- Pregunta 2 ---
    @FXML private ToggleGroup tgP2;
    @FXML private RadioButton rbP2A, rbP2B, rbP2C, rbP2D;

    // --- Pregunta 3 ---
    @FXML private ToggleGroup tgP3;
    @FXML private RadioButton rbP3A, rbP3B, rbP3C, rbP3D;

    // --- Pregunta 4 ---
    @FXML private ToggleGroup tgP4;
    @FXML private RadioButton rbP4A, rbP4B, rbP4C, rbP4D;

    // --- Resultados ---
    @FXML private VBox vboxResultado;
    @FXML private Label lblPuntaje;
    @FXML private Label lblCorrectas;
    @FXML private Label lblIncorrectas;
    @FXML private Label lblMensajeFinal;
    @FXML private Button btnEnviar;
    @FXML private Button btnReiniciar;

    // Respuestas correctas: A=0, B=1, C=2, D=3
    // P1: ¿Cuántos bytes tiene 1 KB?  → B) 1024
    // P2: ¿Qué lenguaje usa JavaFX?   → A) Java
    // P3: ¿Qué significa POO?         → C) Programación Orientada a Objetos
    // P4: ¿Cuántos bits tiene 1 byte? → A) 8

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vboxResultado.setVisible(false);
        vboxResultado.setManaged(false);
    }

    @FXML
    private void handleEnviar() {
        // Verificar que todas estén respondidas
        if (tgP1.getSelectedToggle() == null || tgP2.getSelectedToggle() == null
         || tgP3.getSelectedToggle() == null || tgP4.getSelectedToggle() == null) {
            new Alert(Alert.AlertType.WARNING,
                "Por favor responda todas las preguntas antes de enviar.",
                ButtonType.OK).showAndWait();
            return;
        }

        int correctas = 0;

        // P1: correcta = rbP1B (1024 bytes)
        if (tgP1.getSelectedToggle() == rbP1B) correctas++;

        // P2: correcta = rbP2A (Java)
        if (tgP2.getSelectedToggle() == rbP2A) correctas++;

        // P3: correcta = rbP3C (Programación Orientada a Objetos)
        if (tgP3.getSelectedToggle() == rbP3C) correctas++;

        // P4: correcta = rbP4A (8 bits)
        if (tgP4.getSelectedToggle() == rbP4A) correctas++;

        int incorrectas = 4 - correctas;
        int puntaje = correctas * 5;

        lblPuntaje.setText("Puntaje total: " + puntaje + " / 20 puntos");
        lblCorrectas.setText("Respuestas correctas: " + correctas);
        lblIncorrectas.setText("Respuestas incorrectas: " + incorrectas);

        if (puntaje == 20) {
            lblMensajeFinal.setText("¡Perfecto! Todas las respuestas correctas.");
            lblMensajeFinal.setStyle("-fx-text-fill: #1e8449; -fx-font-weight: bold;");
        } else if (puntaje >= 10) {
            lblMensajeFinal.setText("¡Buen intento! Puedes mejorar.");
            lblMensajeFinal.setStyle("-fx-text-fill: #d35400; -fx-font-weight: bold;");
        } else {
            lblMensajeFinal.setText("Sigue practicando.");
            lblMensajeFinal.setStyle("-fx-text-fill: #c0392b; -fx-font-weight: bold;");
        }

        vboxResultado.setVisible(true);
        vboxResultado.setManaged(true);
        btnEnviar.setDisable(true);

        // Marcar visualmente correctas e incorrectas
        colorearRespuesta(tgP1, rbP1B);
        colorearRespuesta(tgP2, rbP2A);
        colorearRespuesta(tgP3, rbP3C);
        colorearRespuesta(tgP4, rbP4A);
    }

    private void colorearRespuesta(ToggleGroup grupo, RadioButton correcta) {
        RadioButton seleccionada = (RadioButton) grupo.getSelectedToggle();
        if (seleccionada == correcta) {
            seleccionada.setStyle("-fx-text-fill: #1e8449; -fx-font-weight: bold;");
        } else {
            seleccionada.setStyle("-fx-text-fill: #c0392b;");
            correcta.setStyle("-fx-text-fill: #1e8449; -fx-font-weight: bold;");
        }
    }

    @FXML
    private void handleReiniciar() {
        tgP1.selectToggle(null);
        tgP2.selectToggle(null);
        tgP3.selectToggle(null);
        tgP4.selectToggle(null);

        // Limpiar estilos
        for (RadioButton rb : new RadioButton[]{rbP1A,rbP1B,rbP1C,rbP1D,
                                                rbP2A,rbP2B,rbP2C,rbP2D,
                                                rbP3A,rbP3B,rbP3C,rbP3D,
                                                rbP4A,rbP4B,rbP4C,rbP4D}) {
            rb.setStyle("");
        }

        vboxResultado.setVisible(false);
        vboxResultado.setManaged(false);
        btnEnviar.setDisable(false);
    }
}
