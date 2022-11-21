package com.example.pizzeria;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField textNombre, textTelefono;
    @FXML
    private ComboBox<Pizza> comboPizzas;
    @FXML
    private RadioButton radioFamiliar, radioMediana, radioPequenia;
    @FXML
    private Button botonRealizarPedido;
    @FXML
    private ListView<Pedido> listaPedidos;
    private ToggleGroup grupoTamanios;
    private ObservableList<Pizza> listaPizzas;
    private ObservableList<Pedido> listListaPedidos;
    private int idPedido = 1;
    private ArrayList<Ingrediente>
            bbq = new ArrayList<>(),
            hawaiana = new ArrayList<>(),
            jamonQueso = new ArrayList<>(),
            cuatroQuesos = new ArrayList<>();
    private Ingrediente bacon = new Ingrediente("bacon");
    private Ingrediente salsaBbq = new Ingrediente("salsaBbq");
    private Ingrediente maiz = new Ingrediente("maiz");
    private Ingrediente cebolla = new Ingrediente("cebolla");
    private Ingrediente carne = new Ingrediente("cebolla");
    private Ingrediente pinia = new Ingrediente("piña");
    private Ingrediente jamon = new Ingrediente("jamon");
    private Ingrediente salsa = new Ingrediente("salsa");
    private Ingrediente queso = new Ingrediente("queso");
    private Ingrediente gorgonzola = new Ingrediente("gorgonzola");
    private Ingrediente parmesano = new Ingrediente("parmesano");
    private Ingrediente roquefort = new Ingrediente("roquefort");
    private Ingrediente gouda = new Ingrediente("gouda");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void acciones() {
        botonRealizarPedido.setOnAction(new ManejoPulsaciones());
        //Añade escuchadores a la seleccion del comboBox y el grupo de radios y configura el precio y tamaño de las pizzas
        grupoTamanios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton radioButton = (RadioButton) t1;
                String tipo = radioButton.getText();
                if (comboPizzas.getSelectionModel().getSelectedItem().getNombre().equalsIgnoreCase("barbacoa")) {
                    if (tipo.equalsIgnoreCase("pequeña")) {
                        comboPizzas.getSelectionModel().getSelectedItem().setTamanio("pequeña");
                        comboPizzas.getSelectionModel().getSelectedItem().setPrecio(7);
                    } else if (tipo.equalsIgnoreCase("mediana")) {
                        comboPizzas.getSelectionModel().getSelectedItem().setTamanio("mediana");
                        comboPizzas.getSelectionModel().getSelectedItem().setPrecio(12);
                    } else if (tipo.equalsIgnoreCase("familiar")) {
                        comboPizzas.getSelectionModel().getSelectedItem().setTamanio("familiar");
                        comboPizzas.getSelectionModel().getSelectedItem().setPrecio(15);
                    }
                } else if (comboPizzas.getSelectionModel().getSelectedItem().getNombre().equalsIgnoreCase("hawaiana")) {
                    if (tipo.equalsIgnoreCase("pequeña")) {
                        comboPizzas.getSelectionModel().getSelectedItem().setTamanio("pequeña");
                        comboPizzas.getSelectionModel().getSelectedItem().setPrecio(5);
                    } else if (tipo.equalsIgnoreCase("mediana")) {
                        comboPizzas.getSelectionModel().getSelectedItem().setTamanio("mediana");
                        comboPizzas.getSelectionModel().getSelectedItem().setPrecio(10);
                    } else if (tipo.equalsIgnoreCase("familiar")) {
                        comboPizzas.getSelectionModel().getSelectedItem().setTamanio("familiar");
                        comboPizzas.getSelectionModel().getSelectedItem().setPrecio(13);
                    }
                } else if (comboPizzas.getSelectionModel().getSelectedItem().getNombre().equalsIgnoreCase("jamon y queso")) {
                    if (tipo.equalsIgnoreCase("pequeña")) {
                        comboPizzas.getSelectionModel().getSelectedItem().setTamanio("pequeña");
                        comboPizzas.getSelectionModel().getSelectedItem().setPrecio(4);
                    } else if (tipo.equalsIgnoreCase("mediana")) {
                        comboPizzas.getSelectionModel().getSelectedItem().setTamanio("mediana");
                        comboPizzas.getSelectionModel().getSelectedItem().setPrecio(8);
                    } else if (tipo.equalsIgnoreCase("familiar")) {
                        comboPizzas.getSelectionModel().getSelectedItem().setTamanio("familiar");
                        comboPizzas.getSelectionModel().getSelectedItem().setPrecio(10);
                    }
                } else if (comboPizzas.getSelectionModel().getSelectedItem().getNombre().equalsIgnoreCase("Cuatro quesos")) {
                    if (tipo.equalsIgnoreCase("pequeña")) {
                        comboPizzas.getSelectionModel().getSelectedItem().setTamanio("pequeña");
                        comboPizzas.getSelectionModel().getSelectedItem().setPrecio(8);
                    } else if (tipo.equalsIgnoreCase("mediana")) {
                        comboPizzas.getSelectionModel().getSelectedItem().setTamanio("mediana");
                        comboPizzas.getSelectionModel().getSelectedItem().setPrecio(13);
                    } else if (tipo.equalsIgnoreCase("familiar")) {
                        comboPizzas.getSelectionModel().getSelectedItem().setTamanio("familiar");
                        comboPizzas.getSelectionModel().getSelectedItem().setPrecio(17);
                    }
                }
            }
        });
        listaPedidos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pedido>() {
            @Override
            public void changed(ObservableValue<? extends Pedido> observableValue, Pedido oldPedido, Pedido newPedido) {
                newPedido.mostrarDatos();
            }
        });
    }

    private void asociarDatos() {
        comboPizzas.setItems(listaPizzas);
        listaPedidos.setItems(listListaPedidos);
    }

    private void instancias() {
        // añade los radioButtons en el grupo
        grupoTamanios = new ToggleGroup();
        grupoTamanios.getToggles().addAll(radioFamiliar, radioMediana, radioPequenia);
        //Inicializa la lista de pizzas y la rellena
        listaPizzas = FXCollections.observableArrayList();
        bbq.add(bacon);
        bbq.add(salsaBbq);
        bbq.add(maiz);
        bbq.add(cebolla);
        bbq.add(carne);
        hawaiana.add(pinia);
        hawaiana.add(jamon);
        hawaiana.add(salsa);
        jamonQueso.add(jamon);
        jamonQueso.add(queso);
        cuatroQuesos.add(gorgonzola);
        cuatroQuesos.add(gouda);
        cuatroQuesos.add(parmesano);
        cuatroQuesos.add(roquefort);
        listaPizzas.addAll(
                new Pizza("Barbacoa", bbq),
                new Pizza("Hawaiana", hawaiana),
                new Pizza("Jamon y Queso", jamonQueso),
                new Pizza("Cuatro quesos", cuatroQuesos)
        );
        listListaPedidos = FXCollections.observableArrayList();
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            // da funcionalidad al boton de añadir pedido
            if (actionEvent.getSource() == botonRealizarPedido) {
                if (textNombre.getText().isEmpty()) {
                    System.out.println("Debes indicar el nombre");
                } else if (textTelefono.getText().isEmpty()) {
                    System.out.println("Debes indicar el numero de telefono");
                } else if (comboPizzas.getSelectionModel().isEmpty()) {
                    System.out.println("Indica el tipo de pizzaa que quieres");
                } else if (grupoTamanios.getSelectedToggle() == null) {
                    System.out.println("Indica un tamaño para la pizza");
                } else {
                    listListaPedidos.add(new Pedido(idPedido, textNombre.getText(), Integer.parseInt(textTelefono.getText())
                            , comboPizzas.getSelectionModel().getSelectedItem()));
                    idPedido++;
                    textNombre.clear();
                    textTelefono.clear();
                    grupoTamanios.getToggles().clear();
                    //comboPizzas.set
                }
            }
        }
    }
}

