package com.example.ejercicioclase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Button botonAdd;

    @FXML
    private Button botonBorrar;

    @FXML
    private Button botonDetalles;

    @FXML
    private TableColumn columnaId,columnaNombre,columnaApellido;
    @FXML
    private TableView<Alumno> tabla;

    @FXML
    private MenuItem menuAdd;

    @FXML
    private MenuItem menuCerrar;

    @FXML
    private MenuItem menuDetalles;

    private ObservableList<Alumno> listaTabla;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
        configurarTabla();
    }

    private void configurarTabla() {
        tabla.setItems(listaTabla);
        columnaId.setCellValueFactory(new PropertyValueFactory("id"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
    }

    private void instancias() {
        listaTabla = FXCollections.observableArrayList();
        listaTabla.add(new Alumno(0,"Alumno1","Apellido1", "correo1",1234));
    }

    private void acciones() {
        botonAdd.setOnAction(new ManejoPulsaciones());
        menuAdd.setOnAction(new ManejoPulsaciones());
        botonBorrar.setOnAction(new ManejoPulsaciones());
        menuCerrar.setOnAction(new ManejoPulsaciones());
        menuDetalles.setOnAction(new ManejoPulsaciones());
        botonDetalles.setOnAction(new ManejoPulsaciones());

    }


    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == menuAdd || actionEvent.getSource() == menuAdd){

            } else if (actionEvent.getSource() == menuDetalles || actionEvent.getSource() == botonDetalles) {

            } else if (actionEvent.getSource() == menuCerrar || actionEvent.getSource() == botonBorrar) {
                if (tabla.getSelectionModel().getFocusedIndex()>-1){
                    listaTabla.remove(tabla.getSelectionModel().getFocusedIndex());
                } else {
                    System.out.println("nada seleccionado");
                }
            }
        }
    }
}