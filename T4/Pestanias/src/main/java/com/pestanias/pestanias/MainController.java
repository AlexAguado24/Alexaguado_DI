package com.pestanias.pestanias;

import com.pestanias.pestanias.model.TipoDePago;
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

public class MainController implements Initializable {

    //elementos gráficos
    @FXML
    private TabPane panelPestanias;
    private DropShadow sombraExterior;
    @FXML
    private Button botonNormal, botonNormalDos;
    @FXML
    private ToggleButton botonToggle;
    @FXML
    private RadioButton radio1, radio2, radio3;

    private ToggleGroup grupoRadios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // se ejecuta cuando se asocia la parte grafica y la logica
        /*botonNormal.setEffect(sombraExterior);
        botonNormalDos.setEffect(sombraExterior);*/
        instancias();
        asociarDatos();
        configurarBotones();
        acciones();
    }

    private void asociarDatos(){
        radio1.setUserData(new TipoDePago("Tarjeta","Pago con tarjeta bancaria",0));
        radio2.setUserData(new TipoDePago("Transferencia","Pago con tarjeta bancaria",10));
        radio3.setUserData(new TipoDePago("PayPal","Pago con Paypal",20));
    }

    private void configurarBotones(){
        //imageView --> image
        botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
        botonToggle.setBackground(null);

        botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal.setBackground(null);


        botonNormalDos.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormalDos.setBackground(null);

    }

    private void instancias(){
        sombraExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radio1,radio2,radio3);
    }

    private void acciones(){
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());

        //botonToggle.setOnAction(new ManejoPulsaciones());
        /*botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_PRESSED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_CLICKED, new ManejoRaton());*/
        botonToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean newValue) {
                botonNormal.setDisable(newValue);
                botonNormalDos.setDisable(newValue);
                if (newValue) {
                    botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));
                    botonToggle.setBackground(null);
                } else {
                    botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
                    botonToggle.setBackground(null);
                }
            }
        });
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                RadioButton radioButton = (RadioButton)newValue;
                System.out.println(((TipoDePago)radioButton.getUserData()).getNombre());
                System.out.println(((TipoDePago)radioButton.getUserData()).getDescripcion());
                System.out.println(((TipoDePago)radioButton.getUserData()).getComision());
            }
        });

    }

    class ManejoRaton implements EventHandler<MouseEvent>{
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED){
                System.out.println("Evento raton entrante");
                if (mouseEvent.getSource() == botonNormal) {
                    botonNormal.setEffect(sombraExterior);
                } else if(mouseEvent.getSource() == botonNormalDos) {
                    botonNormalDos.setEffect(sombraExterior);
                }
            }
            else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                System.out.println("Evento raton saliente");
                if (mouseEvent.getSource() == botonNormal) {
                    botonNormal.setEffect(null);
                } else if(mouseEvent.getSource() == botonNormalDos) {
                    botonNormalDos.setEffect(null);
                }
            }
            else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                System.out.println("Boton Pressed");
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
            }
            else if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
                System.out.println("Boton Clicked");
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));

            }
        }
    }
    class ManejoPulsaciones implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonNormal) {
                /*System.out.println("Boton 1 pulsado");*/
                botonToggle.setSelected(true);
            } else if (actionEvent.getSource() == botonNormalDos) {
                RadioButton radioSeleccionado = (RadioButton) grupoRadios.getSelectedToggle();
                
            }
        }
    }
}
