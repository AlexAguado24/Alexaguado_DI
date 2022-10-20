package com.example.repaso;

import com.example.repaso.model.TipoPago;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class RepasoController implements Initializable {


    @FXML
    private TabPane panelPestanias;
    @FXML
    private Button botonNormal, botonNormalDos;
    @FXML
    private ToggleButton botonToggle;
    @FXML
    private RadioButton radio1, radio2, radio3;

    private ToggleGroup grupoRadios;
    private DropShadow sombraExterior;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        configurarBotones();
        asociarDatos();
        instancias();
        acciones();

    }

    private void asociarDatos(){
        radio1.setUserData(new TipoPago("Tarjeta","Pago con tarjeta",0));
        radio1.setUserData(new TipoPago("Tranfer","Pago con tranferencia",10));
        radio1.setUserData(new TipoPago("PayPal","Pago con Paypal",20));
    }

    private void configurarBotones(){
        botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal.setBackground(null);
        botonNormalDos.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormalDos.setBackground(null);
    }

    private void acciones(){
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());

        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                RadioButton radioButton = (RadioButton) newValue;
                System.out.println(((TipoPago)radioButton.getUserData()).getNombre());
                System.out.println(((TipoPago)radioButton.getUserData()).getDescripcion());
                System.out.println(((TipoPago)radioButton.getUserData()).getComision());
            }
        });

        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_CLICKED,new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_PRESSED,new ManejoRaton());
        botonToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                botonNormal.setDisable(newValue);
                botonNormalDos.setDisable(newValue);
            }
        });
    }

    private void instancias(){
        sombraExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radio1,radio2,radio3);
    }

    class ManejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED) {
                System.out.println("Entrando");
                if (mouseEvent.getSource() == botonNormal) {
                    botonNormal.setEffect(sombraExterior);
                } else if (mouseEvent.getSource() == botonNormalDos) {
                    botonNormalDos.setEffect(sombraExterior);
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                System.out.println("Saliendo");
                if (mouseEvent.getSource() == botonNormal) {
                    botonNormal.setEffect(null);
                } else if (mouseEvent.getSource() == botonNormalDos) {
                    botonNormalDos.setEffect(null);
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonNormal) {
                botonToggle.setSelected(true);
            } else if (actionEvent.getSource() == botonNormalDos) {
                System.out.println("Boton 2 pulsado");
            }
        }
    }
}



