package com.pestanias.pestanias;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.effect.DropShadow;
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

        sombraExterior = new DropShadow();
        /*botonNormal.setEffect(sombraExterior);
        botonNormalDos.setEffect(sombraExterior);*/
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());
        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());

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
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                System.out.println("Evento raton saliente");
                if (mouseEvent.getSource() == botonNormal) {
                    botonNormal.setEffect(null);
                } else if(mouseEvent.getSource() == botonNormalDos) {
                    botonNormalDos.setEffect(null);
                }
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
