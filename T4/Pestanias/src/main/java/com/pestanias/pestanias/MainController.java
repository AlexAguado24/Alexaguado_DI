package com.pestanias.pestanias;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // se ejecuta cuando se asocia la parte grafica y la logica
        /*botonNormal.setEffect(sombraExterior);
        botonNormalDos.setEffect(sombraExterior);*/
        instancias();
        configurarBotones();
        acciones();
    }

    private void configurarBotones(){
        //imageView --> image

        botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal.setBackground(null);


        botonNormalDos.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormalDos.setBackground(null);

    }

    private void instancias(){
        sombraExterior = new DropShadow();
    }

    private void acciones(){
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());
        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_PRESSED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_CLICKED, new ManejoRaton());
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
                System.out.println("Boton 1 pulsado");
            } else if (actionEvent.getSource() == botonNormalDos) {
                System.out.println("Boton 2 pulsado");
            }
        }
    }
}
