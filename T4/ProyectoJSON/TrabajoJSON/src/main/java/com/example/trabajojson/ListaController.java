package com.example.trabajojson;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaController implements Initializable {

    @FXML
    private ListView lista;
    @FXML
    private Button botonVolver, botonCombo, botonSpinner;
    @FXML
    private Spinner spinner;
    @FXML
    private ComboBox combo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
