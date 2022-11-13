package com.example.pizzeria;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField textNombre, textTelefono;
    @FXML
    private ComboBox comboPizzas;
    @FXML
    private RadioButton radioFamiliar, radioMediana, radioPequenia;
    @FXML
    private Button botonRealizarPedido;
    @FXML
    private ListView listaPedidos;

    private ToggleGroup grupoTamanios;
    private ObservableList listaPizzas;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
    }

    private void asociarDatos() {
        comboPizzas.setItems(listaPizzas);
    }

    private void instancias() {
        grupoTamanios.getToggles().addAll(radioFamiliar,radioMediana,radioPequenia);
        listaPizzas = FXCollections.observableArrayList();
    }
    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonRealizarPedido) {

            }
        }
    }
}

