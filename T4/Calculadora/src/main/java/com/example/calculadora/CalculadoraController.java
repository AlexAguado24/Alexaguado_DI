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
    private GridPane panelSCI, botonesArit;
    @FXML
    private VBox panelRegister;
    @FXML
    private Label pantalla;
    @FXML
    private TextArea textoRegister;
    @FXML
    private Button botonSCI, botonRegister, cerrarSCI, cerrarRegister, uno, dos,
            tres, cuatro, cinco, seis, siete, ocho, nueve, botonDiv, botonMulti,
            botonResta, botonSuma, botonIgual, botonBorrar, botonPorcentaje,
            posneg, cero, coma, E, e, borrarRegister, botonRaiz, elevado, botonIn, equisExcla;
    private double operandoUno, operandoDos, resultado;
    private String signo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pantallaGeneral.getChildren().remove(panelSCI);
        pantallaGeneral.getChildren().remove(panelRegister);
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
                ((Button) child).setOnAction(new ManejoBotones());
            }
        }
        for (Node child : panelSCI.getChildren()) {
            if (child instanceof Button) {
                ((Button) child).setOnAction(new ManejoBotones());
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
            } else if (actionEvent.getSource() == uno) {
                pantalla.setText(pantalla.getText() + uno.getText());
            } else if (actionEvent.getSource() == dos) {
                pantalla.setText(pantalla.getText() + dos.getText());
            } else if (actionEvent.getSource() == tres) {
                pantalla.setText(pantalla.getText() + tres.getText());
            } else if (actionEvent.getSource() == cuatro) {
                pantalla.setText(pantalla.getText() + cuatro.getText());
            } else if (actionEvent.getSource() == cinco) {
                pantalla.setText(pantalla.getText() + cinco.getText());
            } else if (actionEvent.getSource() == seis) {
                pantalla.setText(pantalla.getText() + seis.getText());
            } else if (actionEvent.getSource() == siete) {
                pantalla.setText(pantalla.getText() + siete.getText());
            } else if (actionEvent.getSource() == ocho) {
                pantalla.setText(pantalla.getText() + ocho.getText());
            } else if (actionEvent.getSource() == nueve) {
                pantalla.setText(pantalla.getText() + nueve.getText());
            } else if (actionEvent.getSource() == cero) {
                pantalla.setText(pantalla.getText() + cero.getText());
            } else if (actionEvent.getSource() == coma) {
                pantalla.setText(pantalla.getText() + coma.getText());
            } else if (actionEvent.getSource() == E) {
                pantalla.setText("2.718");
            } else if (actionEvent.getSource() == e) {
                pantalla.setText("2.718");
            } else if (actionEvent.getSource() == equisExcla) {
                operandoUno = Double.parseDouble(pantalla.getText());
                textoRegister.appendText("X!"+operandoUno+"=");
                double total = 0.0;
                for (int i = (int) operandoUno-1; i > 0 ; i--) {
                    operandoUno = operandoUno*i;
                }
                total = operandoUno;
                textoRegister.appendText(String.valueOf(total+"\n"));
                pantalla.setText(String.valueOf(operandoUno));
            }else if (actionEvent.getSource() == posneg) {
                try {
                    if (pantalla.getText().contains("-")) {
                        String[] texto = pantalla.getText().split("-");
                        pantalla.setText(texto[1]);
                    } else {
                        pantalla.setText("-" + pantalla.getText());
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Debes indicar algun numero primero");
                }
            } else if (actionEvent.getSource() == botonPorcentaje) {
                try {
                    signo = "%";
                    textoRegister.appendText(pantalla.getText() + signo);
                    operandoUno = Double.parseDouble(pantalla.getText());
                    pantalla.setText("");
                } catch (NumberFormatException e) {
                    System.out.println("Debes indicar algun numero primero");
                }
            } else if (actionEvent.getSource() == botonSuma) {
                try {
                    signo = "+";
                    textoRegister.appendText(pantalla.getText() + signo);
                    operandoUno = Double.parseDouble(pantalla.getText());
                    pantalla.setText("");
                } catch (NumberFormatException e){
                    System.out.println("Debes indicar algun numero primero");
                }
            } else if (actionEvent.getSource() == botonResta) {
                try {
                    signo = "-";
                    textoRegister.appendText(pantalla.getText() + signo);
                    operandoUno = Double.parseDouble(pantalla.getText());
                    pantalla.setText("");
                } catch (NumberFormatException e) {
                    System.out.println("Debes indicar algun numero primero");
                }
            } else if (actionEvent.getSource() == botonDiv) {
                try {
                    signo = "/";
                    textoRegister.appendText(pantalla.getText() + signo);
                    operandoUno = Double.parseDouble(pantalla.getText());
                    pantalla.setText("");
                } catch (NumberFormatException e) {
                    System.out.println("Debes indicar algun numero primero");
                }
            } else if (actionEvent.getSource() == botonMulti) {
                try {
                    signo = "*";
                    textoRegister.appendText(pantalla.getText() + signo);
                    operandoUno = Double.parseDouble(pantalla.getText());
                    pantalla.setText("");
                } catch (NumberFormatException e) {
                    System.out.println("Debes indicar algun numero primero");
                }
            } else if (actionEvent.getSource() == botonRaiz) {
                try {
                    operandoUno = Double.parseDouble(pantalla.getText());
                    textoRegister.appendText("√" + pantalla.getText() + "=" + String.valueOf(Math.sqrt(operandoUno)));
                    textoRegister.appendText("\n");
                    pantalla.setText(String.valueOf(Math.sqrt(operandoUno)));
                } catch (NumberFormatException e) {
                    System.out.println("Debes indicar algun numero primero");
                }
            } else if (actionEvent.getSource() == elevado) {
                try {
                    operandoUno = Double.parseDouble(pantalla.getText());
                    textoRegister.appendText(pantalla.getText() + "^ =" + String.valueOf(Math.pow(operandoUno, 2)));
                    textoRegister.appendText("\n");
                    pantalla.setText(String.valueOf(Math.pow(operandoUno, 2)));
                }  catch (NumberFormatException e) {
                    System.out.println("Debes indicar algun numero primero");
                }
            } else if (actionEvent.getSource() == botonIn) {
                try {
                    operandoUno = Double.parseDouble(pantalla.getText());
                    textoRegister.appendText("log("+pantalla.getText()+String.valueOf(Math.log(operandoUno))+")");
                    textoRegister.appendText("\n");
                    pantalla.setText(String.valueOf(Math.log(operandoUno)));
                }  catch (NumberFormatException e) {
                    System.out.println("Debes indicar algun numero primero");
                }
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
                try {
                    textoRegister.appendText(pantalla.getText() + "=");
                    operandoDos = Double.parseDouble(pantalla.getText());
                    switch (signo) {
                        case "+":
                            resultado = operandoUno + operandoDos;
                            textoRegister.appendText(String.valueOf(resultado+"\n"));
                            pantalla.setText(String.valueOf(resultado));
                            operandoUno = resultado;
                            break;
                        case "-":
                            resultado = operandoUno - operandoDos;
                            textoRegister.appendText(String.valueOf(resultado+"\n"));
                            pantalla.setText(String.valueOf(resultado));
                            operandoUno = resultado;
                            break;
                        case "*":
                            resultado = operandoUno * operandoDos;
                            textoRegister.appendText(String.valueOf(resultado+"\n"));
                            pantalla.setText(String.valueOf(resultado));
                            operandoUno = resultado;
                            break;
                        case "/":
                            resultado = operandoUno / operandoDos;
                            textoRegister.appendText(String.valueOf(resultado+"\n"));
                            pantalla.setText(String.valueOf(resultado));
                            operandoUno = resultado;
                            break;
                        case "%":
                            resultado = operandoUno % operandoDos;
                            textoRegister.appendText(String.valueOf(resultado+"\n"));
                            pantalla.setText(String.valueOf(resultado));
                            operandoUno = resultado;
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Debes indicar algun numero primero");
                }
            }
        }
    }
}
