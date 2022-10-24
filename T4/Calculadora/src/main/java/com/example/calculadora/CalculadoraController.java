package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable {

    @FXML
    private BorderPane pantallaGeneral;
    @FXML
    private GridPane panelSCI, botonesArit;
    @FXML
    private VBox panelRegister;
    @FXML
    private Button botonSCI, botonRegister, cerrarSCI, cerrarRegister;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones() {
        botonSCI.setOnAction(new ManejoBotones());
        cerrarSCI.setOnAction(new ManejoBotones());
        botonRegister.setOnAction(new ManejoBotones());
        cerrarRegister.setOnAction(new ManejoBotones());
        for (Node child : botonesArit.getChildren()) {
            if (child instanceof Button) {
                ((Button)child).setOnAction(new ManejoBotones());
            }
        }
    }

    class ManejoBotones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Button b = (Button)actionEvent.getSource();
            if (actionEvent.getSource() == botonSCI) {
                pantallaGeneral.setLeft(panelSCI);
            } else if (actionEvent.getSource() == cerrarSCI) {
                pantallaGeneral.getChildren().remove(panelSCI);
            } else if (actionEvent.getSource() == botonRegister) {
                pantallaGeneral.setRight(panelRegister);
            } else if (actionEvent.getSource() == cerrarRegister) {
                pantallaGeneral.getChildren().remove(panelRegister);
            } else if (b == ) {
                
            }

        }
    }

}
