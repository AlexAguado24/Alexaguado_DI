package com.pestanias.pestanias;

import com.pestanias.pestanias.model.TipoDePago;
import com.pestanias.pestanias.model.Usuario;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    //elementos gráficos
    @FXML
    private TabPane panelPestanias;
    @FXML
    private Button botonNormal, botonNormalDos;
    @FXML
    private ToggleButton botonToggle;
    @FXML
    private RadioButton radio1, radio2, radio3;
    @FXML
    private TextField textField1, textField2;
    @FXML
    private Button botonSuma,botonResta, botonMultiplicacion, botonDivision, botonIgual, botonComprobar;
    @FXML
    private GridPane gridBotones;

    @FXML
    private ChoiceBox<String> choice;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private ComboBox<Usuario> comboUsuario;
    @FXML
    private Spinner<String> spinner;

    private ObservableList<String> listaChoice, listaCombo, listaSpinner;
    private ObservableList<Usuario> listaUsuarios;

    private ToggleGroup grupoRadios;
    private DropShadow sombraExterior;
    private int tipoOperacion = -1;

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

        combo.setItems(listaCombo);
        choice.setItems(listaChoice);
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

        listaChoice = FXCollections.observableArrayList();
        listaChoice.addAll("OpcionCH 1","OpcionCH 2","OpcionCH 3","OpcionCH 4","OpcionCH 5");
        listaCombo = FXCollections.observableArrayList();
        listaCombo.addAll("OpcionCB 1","OpcionCB 2","OpcionCB 3","OpcionCB 4","OpcionCB 5");
        listaSpinner = FXCollections.observableArrayList();
        listaSpinner.addAll("OpcionSP 1","OpcionSP 2", "OpcionSP 3", "OpcionSP 4", "OpcionSP 5");

        listaUsuarios = FXCollections.observableArrayList();
        listaUsuarios.addAll(
                new Usuario(1,"Paco","Martinez", "pacoinalaysequedaduro@gmail.com"),
                new Usuario(1,"Marcos","Salas", "selapegaenlapera@gmail.com"),
                new Usuario(1,"Andres","Zama", "zamarreñoboy@gmail.com"),
                new Usuario(1,"Marta","Pacheco", "lapachequita@gmail.com"),
                new Usuario(1,"Patri","Fraile", "frailecillo@gmail.com")
        );
    }

    private void acciones(){
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());
        for (Node child : gridBotones.getChildren()) {
            if (child instanceof Button) {
                ((Button) child).setOnAction(new ManejoPulsaciones());
            }
        }
        //botonResta.setOnAction(new ManejoPulsaciones());

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
        botonComprobar.setOnAction(new ManejoPulsaciones());
        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String newValue) {
                System.out.println("El valor cambiado del combo es "+ newValue);
            }
        });
        choice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String newValue) {
                System.out.println("La seleccion del choice es "+newValue);
            }
        });
        comboUsuario.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuario>() {
            @Override
            public void changed(ObservableValue<? extends Usuario> observableValue, Usuario usuario, Usuario newValue) {
                System.out.println("ID "+ newValue.getId());
                System.out.println("Nombre "+ newValue.getNombre());
                System.out.println("Apellido "+ newValue.getApellido());
                System.out.println("correo "+ newValue.getCorreo());
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
            } else if (actionEvent.getSource() == botonSuma) {
                if (Character.isDigit(textField1.getText().charAt(0)) && Character.isDigit(textField2.getText().charAt(0))) {
                    tipoOperacion = 0;
                } else {

                }
            } else if (actionEvent.getSource() == botonResta) {
            } else if (actionEvent.getSource() == botonMultiplicacion) {
            } else if (actionEvent.getSource() == botonDivision) {
            } else if (actionEvent.getSource() == botonIgual) {

            } else if (actionEvent.getSource() == botonComprobar) {
                // seleccion de una lista

                String seleccionCombo = combo.getSelectionModel().getSelectedItem();
                String seleccionChoice = choice.getSelectionModel().getSelectedItem();
                String usuarioNombre = comboUsuario.getSelectionModel().selectedItemProperty().getName();

                System.out.println(combo.getSelectionModel().getSelectedItem());
                System.out.println(choice.getSelectionModel().getSelectedItem());
                System.out.println(comboUsuario.getSelectionModel().getSelectedItem());


                if (combo.getSelectionModel().getSelectedIndex() >-1 && choice.getSelectionModel().getSelectedIndex()>-1){
                    System.out.printf("Seleccion de combo %s%n",seleccionCombo);
                    System.out.printf("Seleccion de choice %s%n",seleccionChoice);
                    System.out.printf("Seleccion de choice %s%n",usuarioNombre);
                } else {
                    System.out.println("Uno de los dos elementos no tiene seleccion");
                }
            }

        }
    }
}
