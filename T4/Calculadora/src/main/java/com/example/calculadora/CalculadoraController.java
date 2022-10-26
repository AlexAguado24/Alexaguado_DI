package com.example.calculadora;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable {

    @FXML
    private BorderPane pantallaGeneral;
    @FXML
    private GridPane panelSCI , botonesArit;
    @FXML
    private VBox panelRegister;
    @FXML
    private Label pantalla;
    @FXML
    private TextArea textoRegister;
    @FXML
    private Button botonSCI, botonRegister, cerrarSCI, cerrarRegister, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, botonDiv, botonMulti, botonResta, botonSuma, botonIgual,botonBorrar, botonPorcentaje, posneg, cero, coma, e, borrarRegister ;
    private double operandoUno, operandoDos, resultado;
    private String signo;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
    }

    private void acciones() {
        botonSCI.setOnAction(new ManejoBotones());
        cerrarSCI.setOnAction(new ManejoBotones());
        botonRegister.setOnAction(new ManejoBotones());
        cerrarRegister.setOnAction(new ManejoBotones());
        borrarRegister.setOnAction(new ManejoBotones());
        for (Node child : botonesArit.getChildren()) {
            if (child instanceof Button) {
                ((Button)child).setOnAction(new ManejoBotones());
            }
        }
    }

    class ManejoBotones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonSCI) {
                pantallaGeneral.setLeft(panelSCI);
            } else if (actionEvent.getSource() == cerrarSCI) {
                pantallaGeneral.getChildren().remove(panelSCI);
            } else if (actionEvent.getSource() == botonRegister) {
                pantallaGeneral.setRight(panelRegister);
            } else if (actionEvent.getSource() == cerrarRegister) {
                pantallaGeneral.getChildren().remove(panelRegister);
            } else if (actionEvent.getSource() == uno){
                pantalla.setText(pantalla.getText()+uno.getText());
            } else if (actionEvent.getSource() == dos) {
                pantalla.setText(pantalla.getText()+dos.getText());
            } else if (actionEvent.getSource() == tres) {
                pantalla.setText(pantalla.getText()+tres.getText());
            } else if (actionEvent.getSource() == cuatro) {
                pantalla.setText(pantalla.getText()+cuatro.getText());
            } else if (actionEvent.getSource() == cinco) {
                pantalla.setText(pantalla.getText()+cinco.getText());
            } else if (actionEvent.getSource() == seis) {
                pantalla.setText(pantalla.getText()+seis.getText());
            } else if (actionEvent.getSource() == siete) {
                pantalla.setText(pantalla.getText()+siete.getText());
            } else if (actionEvent.getSource() == ocho) {
                pantalla.setText(pantalla.getText()+ocho.getText());
            } else if (actionEvent.getSource() == nueve) {
                pantalla.setText(pantalla.getText()+nueve.getText());
            } else if (actionEvent.getSource() == cero) {
                pantalla.setText(pantalla.getText()+cero.getText());
            } else if (actionEvent.getSource() == coma) {
                pantalla.setText(pantalla.getText()+coma.getText());
            } else if (actionEvent.getSource() == posneg) {
                if (Double.parseDouble(pantalla.getText())>0) {
                    pantalla.setText("-"+pantalla.getText());
                } else if (Double.parseDouble(pantalla.getText())<0) {
                }
            } else if (actionEvent.getSource() == botonPorcentaje) {
                signo = "%";
                textoRegister.appendText(pantalla.getText()+signo);
                operandoUno = Double.parseDouble(pantalla.getText());
                pantalla.setText("");
            } else if (actionEvent.getSource() == botonSuma) {
                signo = "+";
                textoRegister.appendText(pantalla.getText()+signo);
                operandoUno = Double.parseDouble(pantalla.getText());
                pantalla.setText("");
            } else if (actionEvent.getSource() == botonResta) {
                signo = "-";
                textoRegister.appendText(pantalla.getText()+signo);
                operandoUno = Double.parseDouble(pantalla.getText());
                pantalla.setText("");
            } else if (actionEvent.getSource() == botonDiv) {
                signo = "/";
                textoRegister.appendText(pantalla.getText()+signo);
                operandoUno = Double.parseDouble(pantalla.getText());
                pantalla.setText("");
            } else if (actionEvent.getSource() == botonMulti) {
                signo = "*";
                textoRegister.appendText(pantalla.getText()+signo);
                operandoUno = Double.parseDouble(pantalla.getText());
                pantalla.setText("");
            } else if (actionEvent.getSource() == botonBorrar) {
                signo = "";
                pantalla.setText("");
                operandoUno = 0.0;
                operandoDos = 0.0;
                resultado = 0.0;
                textoRegister.clear();
            } else if (actionEvent.getSource() == borrarRegister) {
                textoRegister.clear();
            } else if (actionEvent.getSource() == botonIgual) {
                textoRegister.appendText(pantalla.getText()+"=");
                operandoDos = Double.parseDouble(pantalla.getText());
                switch (signo) {
                    case "+":
                        resultado = operandoUno + operandoDos;
                        textoRegister.appendText(String.valueOf(resultado));
                        textoRegister.appendText("\n");
                        pantalla.setText(String.valueOf(resultado));
                        operandoUno = resultado;
                        break;
                    case"-":
                        resultado = operandoUno - operandoDos;
                        textoRegister.appendText(String.valueOf(resultado));
                        textoRegister.appendText("\n");
                        pantalla.setText(String.valueOf(resultado));
                        operandoUno = resultado;
                        break;
                    case"*":
                        resultado = operandoUno * operandoDos;
                        textoRegister.appendText(String.valueOf(resultado));
                        textoRegister.appendText("\n");
                        pantalla.setText(String.valueOf(resultado));
                        operandoUno = resultado;
                        break;
                    case"/":
                        resultado = operandoUno / operandoDos;
                        textoRegister.appendText(String.valueOf(resultado));
                        textoRegister.appendText("\n");
                        pantalla.setText(String.valueOf(resultado));
                        operandoUno = resultado;
                        break;
                    case"%":
                        resultado = operandoUno % operandoDos;
                        textoRegister.appendText(String.valueOf(resultado));
                        textoRegister.appendText("\n");
                        pantalla.setText(String.valueOf(resultado));
                        operandoUno = resultado;
                        break;
                }
            }
        }
    }
}
