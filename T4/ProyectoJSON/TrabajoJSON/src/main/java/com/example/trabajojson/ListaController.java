package com.example.trabajojson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;

public class ListaController implements Initializable {

    @FXML
    private ListView lista;
    @FXML
    private Button botonVolver, botonCombo, botonSpinner;
    @FXML
    private Spinner spinnerCocktais;
    @FXML
    private ComboBox comboCocktails;
    private ObservableList listaCombo, listaSpinner, listaCocktails;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void acciones() {
        botonCombo.setOnAction(new ManejoBotones());
        botonSpinner.setOnAction(new ManejoBotones());
        botonVolver.setOnAction(new ManejoBotones());
    }

    private void asociarDatos() {
        lista.setItems(listaCocktails);
        comboCocktails.setItems(listaCombo);
        spinnerCocktais.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory(listaSpinner));
    }

    public void recibirLista(String urlJSON) {
        String urlRecibida = urlJSON;
        try {
            URL url = new URL(urlRecibida);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea = null;
            String lecturaCompleta = "";
            while ((linea = br.readLine()) != null) {
                lecturaCompleta += linea;
            }
            JSONObject objeto = new JSONObject(lecturaCompleta);
            JSONArray arrayObjeto = objeto.getJSONArray("drinks");
            for (int i = 0; i < arrayObjeto.length(); i++) {
                JSONObject margarita = arrayObjeto.getJSONObject(i);
                String nombre = margarita.getString("strDrink");
                String imagen = margarita.getString("strDrinkThumb");
                String tipoVaso = margarita.getString("strGlass");
                listaCombo.add(new Cocktail(nombre, imagen, tipoVaso));
                listaSpinner.add(new Cocktail(nombre, imagen, tipoVaso));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void instancias() {
        listaCombo = FXCollections.observableArrayList();
        listaSpinner = FXCollections.observableArrayList();
        listaCocktails = FXCollections.observableArrayList();
    }

    class ManejoBotones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonCombo) {
                //añadiendo el cocktail del combobox
                if (comboCocktails.getSelectionModel().isEmpty()) {
                    System.out.println("Indica el tipo de cocktail que quieres");
                } else {
                    listaCocktails.add(comboCocktails.getSelectionModel().getSelectedItem());
                }
            } else if (actionEvent.getSource() == botonSpinner) {
                //Añade el cocktail que hay seleccionado en el spinner
                listaCocktails.add(spinnerCocktais.getValue());
            } else if (actionEvent.getSource() == botonVolver) {
                // cerrando la ventana
                Stage ventanaNueva = (Stage) botonVolver.getScene().getWindow();
                ventanaNueva.close();
            }
        }
    }
}
