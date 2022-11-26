package com.example.trabajojson;

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
import javafx.scene.Parent;
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
    @FXML
    private RadioButton radioHab, radioDes;

    private ObservableList<Cocktail> listaCocktails;
    private FilteredList listaFiltrar;
    private ToggleGroup grupoRadios;
    private String urlCocktails = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        tratamientoJSON();
        asociarDatos();
        acciones();
        disenioBotones();
        configurarBotones();
    }

    private void configurarBotones() {
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle valorViejo, Toggle valorNuevo) {
                RadioButton radioSeleccionado = (RadioButton) grupoRadios.getSelectedToggle();
                if (radioSeleccionado.getText().equalsIgnoreCase("Deshabilitar")) {
                    tabla.setDisable(true);
                } else if (radioSeleccionado.getText().equalsIgnoreCase("Habilitar")) {
                    tabla.setDisable(false);
                }
            }
        });
    }

    private void asociarDatos() {
        tabla.setItems(listaFiltrar);
        columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaNivel.setCellValueFactory(new PropertyValueFactory("tipoCopa"));
    }

    private void instancias() {
        listaCocktails = FXCollections.observableArrayList();
        listaFiltrar = new FilteredList(listaCocktails);
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radioHab, radioDes);
    }

    private void tratamientoJSON() {
        try {
            URL url = new URL(urlCocktails);
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
                listaCocktails.add(new Cocktail(nombre, imagen, tipoVaso));
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
        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object valorNuevo) {
                System.out.println(((Cocktail) valorNuevo).getFoto());
            }
        });
        textoFiltrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String valorNuevo) {
                listaFiltrar.setPredicate(new Predicate() {
                    @Override
                    public boolean test(Object objeto) {
                        Cocktail cocktail = (Cocktail) objeto;
                        return cocktail.getNombre().toLowerCase().contains(valorNuevo.toLowerCase());
                    }
                });
            }
        });
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == menuSalir) {
                System.exit(0);
            } else if (actionEvent.getSource() == menuLista) {
                Stage ventanaLista = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pantalla-lista.fxml"));
                try {
                    Parent root = fxmlLoader.load();
                    Scene escenaLista = new Scene(root);
                    ventanaLista.setScene(escenaLista);
                    ListaController controller = fxmlLoader.getController();
                    controller.recibirLista(urlCocktails);
                    ventanaLista.setTitle("Ventana de la Lista");
                    ventanaLista.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}