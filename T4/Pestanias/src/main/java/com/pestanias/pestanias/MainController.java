package com.pestanias.pestanias;

import com.pestanias.pestanias.model.TipoDePago;
import com.pestanias.pestanias.model.Usuario;
import com.pestanias.pestanias.model.UsuarioJSON;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
    private RadioButton radio1, radio2, radio3, radioTodos, radioMasculino, radioFemenino;
    @FXML
    private Label labelNombre, labelDesc, labelComision;
    @FXML
    private TextField textFiledUno, textFiledDos;
    @FXML
    private Button botonSuma,botonResta, botonMulti, botonDiv, botonIgual,botonMostrar, botonOcultar, botonComprobar, botonFiltrar;
    @FXML
    private GridPane gridBotones;
    @FXML
    private VBox panelMostrar;
    @FXML
    private BorderPane panelGeneral;
    @FXML
    private ChoiceBox<String> choice;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private ComboBox<Usuario> comboUsuario;
    @FXML
    private Spinner<String> spinner;
    @FXML
    private Spinner<Integer>spinnerCantidad;
    @FXML
    private ListView<String> list;
    @FXML
    private ListView<UsuarioJSON> listUsuarios;
    private ObservableList<UsuarioJSON> listaUsuariosJSON;
    private ObservableList<String> listaChoice, listaCombo, listaSpinner, listaListView;
    private ObservableList<Integer> listaSpinnerCantidad;
    private ObservableList<Usuario> listaUsuarios;
    private ToggleGroup grupoRadios, grupoGenero;
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
        interpretarJSON();
    }

    private void interpretarJSON() {
        String urlString = "https://randomuser.me/api/?"+grupoGenero.getSelectedToggle()+spinnerCantidad;

        try {
            // 1-URL
            URL url = new URL(urlString);
            //2-Crear la conexion
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 3 - Interpretar los datos --> BufferReader
            BufferedReader lecturaURL = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String linea = null;
            String lecturaCompleta = "";


            while ((linea = lecturaURL.readLine()) != null) {
                lecturaCompleta+=linea;
            }

            // 4- pasar el String a JSON
            JSONObject objectoJSON = new JSONObject(lecturaCompleta);
            JSONArray arrayResults = objectoJSON.getJSONArray("results");
            for (int i = 0; i < arrayResults.length(); i++) {
                JSONObject item = arrayResults.getJSONObject(i);
                String title = item.getJSONObject("name").getString("title");
                String first = item.getJSONObject("name").getString("first");
                String last = item.getJSONObject("name").getString("last");
                String urlImage = item.getJSONObject("picture").getString("large");
                String email = item.getString("email");
                String phone = item.getString("phone");
                //System.out.printf("%s %s %s - %s%n", title, first, last, urlImage);
                listaUsuariosJSON.add(new UsuarioJSON(title,first,last,urlImage,email,phone));
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    private void asociarDatos(){
        radio1.setUserData(new TipoDePago("Tarjeta","Pago con tarjeta bancaria",0));
        radio2.setUserData(new TipoDePago("Transferencia","Pago con tarjeta bancaria",10));
        radio3.setUserData(new TipoDePago("PayPal","Pago con Paypal",20));
        combo.setItems(listaCombo);
        choice.setItems(listaChoice);
        comboUsuario.setItems(listaUsuarios);
        spinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(listaSpinner));
        list.setItems(listaListView);
        listUsuarios.setItems(listaUsuariosJSON);
        spinnerCantidad.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<>(listaSpinnerCantidad));
        //spinnerCantidad.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,5,5)); (otra forma de rellenar el spinner)
    }

    private void configurarBotones(){
        //imageView --> image
        botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
        botonNormal.setBackground(null);


        botonNormalDos.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
        botonNormalDos.setBackground(null);

        botonToggle.setBackground(null);
        if (botonToggle.isSelected()) {
            botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));
        } else {
            botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
        }

    }

    private void instancias(){
        sombraExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        grupoGenero = new ToggleGroup();
        grupoRadios.getToggles().addAll(radio1,radio2,radio3);
        grupoGenero.getToggles().addAll(radioTodos,radioMasculino,radioFemenino);

        listaChoice = FXCollections.observableArrayList();
        listaChoice.addAll("OpcionCH 1","OpcionCH 2","OpcionCH 3","OpcionCH 4","OpcionCH 5");
        listaCombo = FXCollections.observableArrayList();
        listaCombo.addAll("OpcionCB 1","OpcionCB 2","OpcionCB 3","OpcionCB 4","OpcionCB 5");
        listaSpinner = FXCollections.observableArrayList();
        listaSpinner.addAll("OpcionSP 1","OpcionSP 2", "OpcionSP 3", "OpcionSP 4", "OpcionSP 5");
        listaSpinnerCantidad = FXCollections.observableArrayList();
        for (int i = 0; i < 101; i++) {
            listaSpinnerCantidad.add(i);
        }
        listaUsuarios = FXCollections.observableArrayList();
        listaUsuarios.addAll(
                new Usuario(1,"Paco","Martinez", "pacoinalaysequedaduro@gmail.com"),
                new Usuario(2,"Marcos","Salas", "selapegaenlapera@gmail.com"),
                new Usuario(3,"Andres","Zama", "zamarreñoboy@gmail.com"),
                new Usuario(4,"Marta","Pacheco", "lapachequita@gmail.com"),
                new Usuario(5,"Patri","Fraile", "frailecillo@gmail.com")
        );
        listaListView = FXCollections.observableArrayList();
        listaListView.addAll("Opcion1","Opcion2","Opcion3","Opcion4","Opcion5","Opcion6","Opcion7","Opcion8");
        listaUsuariosJSON = FXCollections.observableArrayList();
    }

    private void acciones(){
        botonComprobar.setOnAction(new ManejoPulsaciones());
        botonNormal.setOnAction(new ManejoPulsaciones());
        botonNormalDos.setOnAction(new ManejoPulsaciones());
        botonMostrar.setOnAction(new ManejoPulsaciones());
        botonOcultar.setOnAction(new ManejoPulsaciones());
        for (Node child : gridBotones.getChildren()) {
            if (child instanceof Button) {
                ((Button) child).setOnAction(new ManejoPulsaciones());
            }
        }
        /*botonSuma.setOnAction(new ManejoPulsaciones());
        botonResta.setOnAction(new ManejoPulsaciones());
        botonMulti.setOnAction(new ManejoPulsaciones());
        botonDiv.setOnAction(new ManejoPulsaciones());
        botonIgual.setOnAction(new ManejoPulsaciones());*/

        // radio1.setOnAction(new ManejoPulsaciones());
        // botonToggle.setOnAction(new ManejoPulsaciones());
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                RadioButton radioButton = (RadioButton)newValue;
                TipoDePago tipoDePago = (TipoDePago) radioButton.getUserData();
                labelNombre.setText(tipoDePago.getNombre());
                labelDesc.setText(tipoDePago.getDescripcion());
                labelComision.setText(String.valueOf(tipoDePago.getComision()));
            }
        });
        botonNormal.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNormalDos.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_CLICKED, new ManejoRaton());
        botonNormal.addEventHandler(MouseEvent.MOUSE_PRESSED, new ManejoRaton());

        botonToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean newValue) {
                botonNormal.setDisable(newValue);
                botonNormalDos.setDisable(newValue);
                if (newValue) {
                    botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchon.png"))));
                } else {
                    botonToggle.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("switchoff.png"))));
                }
            }
        });

        textFiledDos.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                char letraPulsada = keyEvent.getCharacter().charAt(0);
                System.out.println(Character.isDigit(letraPulsada));
            }
        });
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
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                System.out.println("Cambio en la lista, valor nuevo " + t1);
            }
        });
        listUsuarios.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<UsuarioJSON>() {
            @Override
            public void changed(ObservableValue<? extends UsuarioJSON> observableValue, UsuarioJSON oldUser, UsuarioJSON newUser) {
                if (oldUser != null) {
                    System.out.println("Antiguo");
                    oldUser.mostrarDatos();
                }
                System.out.printf("Nuevo");
                newUser.mostrarDatos();
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
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED){
                System.out.println("Evento raton saliente");
                if (mouseEvent.getSource() == botonNormal) {
                    botonNormal.setEffect(null);
                } else if(mouseEvent.getSource() == botonNormalDos) {
                    botonNormalDos.setEffect(null);
                }
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED) {
                System.out.println("Boton Pressed");
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_off.png"))));
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED) {
                System.out.println("Boton Clicked");
                botonNormal.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("power_on.png"))));
            } else if (mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED) {
                System.out.println("Raton released");
            }
        }
    }
    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonNormal) {
                /*System.out.println("Boton 1 pulsado");*/
                botonToggle.setSelected(true);
                System.out.println(textFiledUno.getText());
            } else if (actionEvent.getSource() == botonNormalDos) {
                RadioButton radioSeleccionado = (RadioButton) grupoRadios.getSelectedToggle();
                TipoDePago tipoPago = (TipoDePago) radioSeleccionado.getUserData();
                System.out.println(tipoPago.getComision());
                System.out.println(tipoPago.getNombre());
                System.out.println(tipoPago.getDescripcion());
            } else if (actionEvent.getSource() == botonSuma) {
                tipoOperacion = 0;
                /*if (Character.isDigit(textFiledUno.getText().charAt(0)) && Character.isDigit(textFiledDos.getText().charAt(0))) {
                    int suma = Integer.parseInt(String.valueOf(textFiledUno.getText().charAt(0))) + Integer.parseInt(String.valueOf(textFiledDos.getText().charAt(0)));
                    System.out.println("La suma de los valores es "+suma);
                } else {
                    System.out.println("Alguno de los elementos no es numero");
                }*/
            } else if (actionEvent.getSource() == botonResta) {
                tipoOperacion = 1;
            } else if (actionEvent.getSource() == botonMulti) {
                tipoOperacion = 2;
            } else if (actionEvent.getSource() == botonDiv) {
                tipoOperacion = 3;
            } else if (actionEvent.getSource() == botonIgual) {
                int op1 = Integer.parseInt(String.valueOf(textFiledUno.getText().charAt(0)));
                int op2 = Integer.parseInt(String.valueOf(textFiledDos.getText().charAt(0)));
                double resultado = 0.0;
                switch (tipoOperacion) {
                    case 0:
                        resultado = op1 + op2;
                        break;
                    case 1:
                        resultado = op1 - op2;
                        break;
                    case 2:
                        resultado = op1 * op2;
                        break;
                    case 3:
                        resultado = (double) op1 / op2;
                        break;
                }
                System.out.printf("El resutaldo de la operacion es %.2f%n", resultado);
            } else if (actionEvent.getSource() == botonMostrar) {
                panelGeneral.setLeft(panelMostrar);
            } else if (actionEvent.getSource() == botonOcultar) {
                panelGeneral.getChildren().remove(panelMostrar);
            } else if (actionEvent.getSource() == botonComprobar) {
                // seleccion de una lista
                String seleccionCombo = combo.getSelectionModel().getSelectedItem();
                String seleccionChoice = choice.getSelectionModel().getSelectedItem();
                String seleccionLista = list.getSelectionModel().getSelectedItem();
                System.out.println(combo.getSelectionModel().getSelectedItem());
                System.out.println(seleccionLista);
                System.out.println(choice.getSelectionModel().getSelectedItem());
                String seleccionSpinner = spinner.getValue();
                System.out.println(combo.getSelectionModel().getSelectedIndex());
                System.out.println(seleccionSpinner);
                if (combo.getSelectionModel().getSelectedIndex() >-1 && choice.getSelectionModel().getSelectedIndex()>-1){
                    System.out.printf("Seleccion de combo %s%n",seleccionCombo);
                    System.out.printf("Seleccion de choice %s%n",seleccionChoice);
                } else {
                    System.out.println("Uno de los dos elementos no tiene seleccion");
                }
            } else if (actionEvent.getSource() == botonFiltrar) {
                // resultados
                int numeroResultados = spinnerCantidad.getValue();
                //genero
            }
        }
    }
}
