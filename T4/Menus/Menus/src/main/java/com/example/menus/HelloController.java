package com.example.menus;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private MenuItem menuSalir, menuComunicarEspecifico, menuComunicarDefecto, menuEscena;

    @FXML
    private RadioMenuItem menuDesactivado, menuActivado;
    @FXML
    private GridPane gridCentral;

    private ToggleGroup grupoRadios;
    private ContextMenu menuContextual;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instanciar();
        acciones();
        personalizarBotones();
    }

    private void instanciar() {
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(menuActivado, menuDesactivado);
        menuContextual = new ContextMenu();
        menuContextual.getItems().setAll(menuSalir,menuComunicarDefecto,menuComunicarEspecifico,menuEscena, menuActivado, menuDesactivado);
    }

    private void personalizarBotones() {
        menuComunicarDefecto.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN));
        menuComunicarEspecifico.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
    }

    private void acciones() {
        menuSalir.setOnAction(new ManejoPulsaciones());
        menuComunicarEspecifico.setOnAction(new ManejoPulsaciones());
        menuComunicarDefecto.setOnAction(new ManejoPulsaciones());
        menuEscena.setOnAction(new ManejoPulsaciones());
        menuActivado.setOnAction(new ManejoPulsaciones());
        menuDesactivado.setOnAction(new ManejoPulsaciones());
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                RadioMenuItem radioSeleccionado = (RadioMenuItem) newValue;
                //System.out.println(radioButton.getText());
                if (radioSeleccionado.getText().equalsIgnoreCase("Activado")) {
                    menuSalir.setDisable(false);
                } else {
                    menuSalir.setDisable(true);
                }
            }
        });
        gridCentral.setOnMouseClicked(new ManejoRaton());
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == menuSalir) {
                System.exit(0);
            } else if (actionEvent.getSource() == menuComunicarDefecto) {

            } else if (actionEvent.getSource() == menuComunicarEspecifico) {

            } else if (actionEvent.getSource() == menuEscena) {

            }
        }
    }
    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent mouseEvent) {
            //System.out.println("Evento raton detectado");
            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                menuContextual.show(gridCentral,mouseEvent.getX(),mouseEvent.getY());
            }
        }
    }
}