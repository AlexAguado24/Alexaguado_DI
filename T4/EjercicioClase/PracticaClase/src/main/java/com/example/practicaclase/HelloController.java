package com.example.practicaclase;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.Serializable;

public class HelloController implements Serializable {

    @FXML
    private TableView tabla;
    @FXML
    private TableColumn columnaId, columnaNombre, columnaDni;


}