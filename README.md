# Tarea JavaFX – Navegación y Reutilización de Formularios

## Estructura del proyecto

```
src/main/java/com/tarea/javafx/
    practica1/   MainApp, LoginController, AdminController, CajeroController
    practica2/   MainApp, AdminController
    practica3/   MainApp, EncuestaController

src/main/resources/fxml/
    practica1/   Login.fxml, Administrador.fxml, Cajero.fxml
    practica2/   Administrador.fxml
    practica3/   Encuesta.fxml
```

---

## Cómo ejecutar en IntelliJ

1. Abrir IntelliJ → **Open** → seleccionar la carpeta `tarea-javafx`
2. IntelliJ detecta el `pom.xml` automáticamente → clic en **Trust Project**
3. Esperar que Maven descargue las dependencias (barra de progreso abajo)
4. Para correr cada práctica, abrir el `MainApp.java` correspondiente y clic en el ▶ verde

---

## Credenciales de la Práctica 1

| Rol           | Usuario | Contraseña |
|---------------|---------|------------|
| Administrador | admin   | admin123   |
| Cajero        | cajero  | cajero123  |

---

## Práctica 2 – Preguntas de Reflexión

**Pregunta 1: ¿Qué archivo modificó?**
Se modificó el archivo `MainApp.java` (la clase que extiende `Application`).

**Pregunta 2: ¿Qué línea de código cambió exactamente?**
Se cambió la ruta del recurso en `FXMLLoader`:
- ANTES: `getClass().getResource("/fxml/practica1/Login.fxml")`
- DESPUÉS: `getClass().getResource("/fxml/practica2/Administrador.fxml")`

**Pregunta 3: ¿Por qué Administrador.fxml se convierte en la pantalla principal?**
Porque en JavaFX la pantalla principal es la que se carga dentro del método `start(Stage stage)`.
Ese método es el punto de entrada de toda aplicación JavaFX. Al cambiar el archivo que
`FXMLLoader` carga en ese método, cambiamos cuál formulario se muestra al iniciar.
No existe ningún archivo de configuración separado; el control de la pantalla inicial
está completamente en el código Java, específicamente en esa línea del `FXMLLoader`.

---

## Práctica 3 – Respuestas correctas de la encuesta

| Pregunta                        | Respuesta correcta         | Puntos |
|---------------------------------|----------------------------|--------|
| ¿Cuántos bytes tiene 1 KB?      | B) 1024 bytes              | 5      |
| ¿Qué lenguaje usa JavaFX?       | A) Java                    | 5      |
| ¿Qué significa POO?             | C) Programación OO         | 5      |
| ¿Cuántos bits tiene 1 byte?     | A) 8 bits                  | 5      |
| **TOTAL**                       |                            | **20** |
