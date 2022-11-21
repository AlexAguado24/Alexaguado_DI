package com.example.practicaclase;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable {
    @FXML
    private Button botonVolver;

    @FXML
    private Label campoNombre;

    @FXML
    private Label campoApellido;

    @FXML
    private Label campoCorreo;

    @FXML
    private Label campoTelefono;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
