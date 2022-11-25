package com.example.trabajojson;

import com.example.trabajojson.model.Digimon;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class HelloController implements Initializable {

    @FXML
    private MenuItem menuSalir, menuLista;
    @FXML
    private TableView tabla;
    @FXML
    private TableColumn columnaNombre, columnaNivel;
    @FXML
    private TextField textoFiltrar;

    private ObservableList<Digimon> listaDigimons;
    private FilteredList listaFiltrar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tratamientoJSON();
        instancias();
        asociarDatos();
        acciones();
        disenioBotones();
    }

    private void asociarDatos() {
        tabla.setItems(listaDigimons);
        columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaNivel.setCellValueFactory(new PropertyValueFactory("nivel"));
    }

    private void instancias() {
        listaDigimons = FXCollections.observableArrayList();
        listaFiltrar = new FilteredList(listaDigimons);
    }

    private void tratamientoJSON() {
        String urlDigimon = "https://digimon-api.vercel.app/api/digimon";
        try {
            URL url = new URL(urlDigimon);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea = null;
            String lecturaCompleta = "";
            while ((linea = br.readLine()) != null){
                lecturaCompleta+=linea;
            }
            JSONArray arrayObjeto = new JSONArray(lecturaCompleta);
            for (int i = 0; i < arrayObjeto.length(); i++) {
                JSONObject digimon = arrayObjeto.getJSONObject(i);
                String nombre = digimon.getString("name");
                String imagen = digimon.getString("img");
                String nivel = digimon.getString("level");
                listaDigimons.add(new Digimon(nombre,imagen,nivel));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void disenioBotones() {
        menuSalir.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icono_salida.png"))));
        menuLista.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icono_lista.png"))));
    }

    private void acciones() {
        menuSalir.setOnAction(new ManejoPulsaciones());
        menuLista.setOnAction(new ManejoPulsaciones());
        /*textoFiltrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String valorNuevo) {
                textoFiltrar.setPredicate(new Predicate() {
                    @Override
                    public boolean test(Object objeto) {
                        Digimon digimon = (Digimon) objeto;
                        return digimon.getNombre().toLowerCase().contains(valorNuevo.toLowerCase());
                    }
                });
            }
        });*/
    }
    
    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == menuSalir) {
                System.exit(0);
            } else if (actionEvent.getSource() == menuLista) {
                Stage ventanaLista = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pantalla-lista.fxml"));
                try {
                    Scene escenaLista = new Scene(fxmlLoader.load());
                    ventanaLista.setScene(escenaLista);
                    ventanaLista.setTitle("Ventana de la Lista");
                    ventanaLista.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}