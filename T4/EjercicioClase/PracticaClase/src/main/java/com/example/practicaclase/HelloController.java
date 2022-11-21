package com.example.practicaclase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableView tabla;
    @FXML
    private TableColumn columnaId, columnaNombre, columnaCorreo;

    @FXML
    private MenuItem menuAniadir, menuDetalles, menuEliminar;

    private ObservableList listaTabla;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        asociarDatos();
    }

    private void asociarDatos() {

        columnaId.setCellValueFactory(new PropertyValueFactory("id"));
        columnaId.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaId.setCellValueFactory(new PropertyValueFactory("correo"));
        menuAniadir.setOnAction(new ManejoPulsaciones());
        menuDetalles.setOnAction(new ManejoPulsaciones());
        menuEliminar.setOnAction(new ManejoPulsaciones());
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == menuAniadir) {

            }
        }
    }
}