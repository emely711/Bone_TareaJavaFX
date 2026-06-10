package com.tarea.javafx.practica1;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtContrasena;
    @FXML private ComboBox<String> cmbRol;
    @FXML private Label lblMensaje;

    // Credenciales hardcoded para la práctica
    private static final String USUARIO_ADMIN    = "admin";
    private static final String CONTRASENA_ADMIN = "admin123";
    private static final String USUARIO_CAJERO   = "cajero";
    private static final String CONTRASENA_CAJERO = "cajero123";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbRol.setItems(FXCollections.observableArrayList("Administrador", "Cajero"));
        cmbRol.getSelectionModel().selectFirst();
        lblMensaje.setText("");
    }

    @FXML
    private void handleIngresar() {
        String usuario   = txtUsuario.getText().trim();
        String contrasena = txtContrasena.getText().trim();
        String rol        = cmbRol.getValue();

        // 1. Verificar campos vacíos
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            mostrarError("Por favor complete todos los campos.");
            return;
        }
        if (rol == null) {
            mostrarError("Seleccione un rol.");
            return;
        }

        // 2. Validar credenciales según rol
        boolean credencialesOk = false;
        if (rol.equals("Administrador") && usuario.equals(USUARIO_ADMIN) && contrasena.equals(CONTRASENA_ADMIN)) {
            credencialesOk = true;
        } else if (rol.equals("Cajero") && usuario.equals(USUARIO_CAJERO) && contrasena.equals(CONTRASENA_CAJERO)) {
            credencialesOk = true;
        }

        if (!credencialesOk) {
            mostrarError("Credenciales incorrectas o rol no coincide.");
            return;
        }

        // 3. Navegar al formulario correspondiente
        try {
            String fxml = rol.equals("Administrador")
                ? "/fxml/practica1/Administrador.fxml"
                : "/fxml/practica1/Cajero.fxml";

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Stage nuevoStage = new Stage();
            nuevoStage.setScene(new Scene(loader.load()));
            nuevoStage.setTitle(rol.equals("Administrador") ? "Panel Administrador" : "Panel Cajero");
            nuevoStage.setResizable(false);
            nuevoStage.show();

            // Cerrar el Login
            Stage loginStage = (Stage) txtUsuario.getScene().getWindow();
            loginStage.close();

        } catch (Exception e) {
            mostrarError("Error al cargar el formulario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSalir() {
        Platform.exit();
    }

    private void mostrarError(String mensaje) {
        lblMensaje.setText(mensaje);
        lblMensaje.setStyle("-fx-text-fill: red;");
    }
}
