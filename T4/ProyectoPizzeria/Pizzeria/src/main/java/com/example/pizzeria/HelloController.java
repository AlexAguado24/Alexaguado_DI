package com.example.pizzeria;

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
    //private ArrayList<Ingrediente> bbq, hawaiana, jamonQueso, cuatroQuesos;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acciones();
        instancias();
        asociarDatos();
    }

    private void acciones() {
        botonRealizarPedido.setOnAction(new ManejoPulsaciones());
        //llenarListasIngredientes();
    }

    /*public void llenarListasIngredientes(){
            bbq.add(new Ingrediente("bacon"));
            bbq.add(new Ingrediente("salsaBBQ"));
            bbq.add(new Ingrediente("maiz"));
            bbq.add(new Ingrediente("cebolla"));
            bbq.add(new Ingrediente("carne"));
            hawaiana.add(new Ingrediente("piña"));
            hawaiana.add(new Ingrediente("jamon"));
            hawaiana.add(new Ingrediente("salsa"));
            jamonQueso.add(new Ingrediente("queso"));
            jamonQueso.add(new Ingrediente("jamon"));
            cuatroQuesos.add(new Ingrediente("gorgonzola"));
            cuatroQuesos.add(new Ingrediente("parmesano"));
            cuatroQuesos.add(new Ingrediente("roquefort"));
            cuatroQuesos.add(new Ingrediente("gouda"));
    }*/

    private void asociarDatos() {
        comboPizzas.setItems(listaPizzas);
        listaPedidos.setItems(listListaPedidos);

    }

    private void instancias() {
        grupoTamanios = new ToggleGroup();
        grupoTamanios.getToggles().addAll(radioFamiliar,radioMediana,radioPequenia);
        listaPizzas = FXCollections.observableArrayList();
        listaPizzas.addAll(
                new Pizza("Barbacoa")
                /*new Pizza("Hawaiana", hawaiana),
                new Pizza("Jamon y Queso", jamonQueso),
                new Pizza("Cuatro quesos", cuatroQuesos)*/
        );
        listListaPedidos = FXCollections.observableArrayList();
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
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
                listListaPedidos.add(new Pedido(idPedido,textNombre.getText(),Integer.parseInt(textTelefono.getText())
                            ,new Pizza("bbq")));
                    idPedido++;
                    textNombre.setText("");
                    textTelefono.setText("");
                    grupoTamanios.selectToggle(null);
                }
            }
        }
    }
}

