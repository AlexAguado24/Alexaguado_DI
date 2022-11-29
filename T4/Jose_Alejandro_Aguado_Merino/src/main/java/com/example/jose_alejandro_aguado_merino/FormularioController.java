package com.example.jose_alejandro_aguado_merino;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
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


public class FormularioController implements Initializable {

    @FXML
    private TextField formulario_nombre;

    @FXML
    private TextField formulario_pass;

    @FXML
    private TextField formulario_correo;

    @FXML
    private TextField formulario_telefono;
    @FXML
    private Button botonRegistrar, botonCerrar;

    @FXML
    private ComboBox combo_formulario;
    private ObservableList listaCombo;
    private HelloController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        inicializar();
        tratarJSON();
        asociarDatos();
        acciones();

    }
    public void setController(HelloController controller){
        this.controller = controller;
    }

    private void acciones() {
        botonCerrar.setOnAction(new ManejoPulsaciones());
        botonRegistrar.setOnAction(new ManejoPulsaciones());
    }

    private void asociarDatos() {
        combo_formulario.setItems(listaCombo);
    }

    private void inicializar() {
        listaCombo = FXCollections.observableArrayList();
    }
    public Usuario setUsuario(){
        String nombre = formulario_nombre.getText();
        String correo = formulario_correo.getText();
        String pass = formulario_pass.getText();
        int telefono = Integer.valueOf(formulario_telefono.getText());
        String rol = (String) combo_formulario.getSelectionModel().getSelectedItem();
        Usuario usuario = new Usuario(nombre,telefono,correo,pass,rol);
        return usuario;
    }

    private void tratarJSON() {
        String urlJSON = "https://run.mocky.io/v3/48686b58-bd41-4f13-92c5-1fba0c56e74d";
        try {
            URL url = new URL(urlJSON);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String linea = null;
            StringBuffer lecturaCompleta = new StringBuffer();
            while ((linea = br.readLine())!=null){
                lecturaCompleta.append(linea);
            }
            br.close();
            JSONArray array = new JSONArray(lecturaCompleta.toString());
            for (int i = 0; i < array.length(); i++) {
                String nombre = array.getString(i);
                listaCombo.add(nombre);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonRegistrar) {
                controller.agregarUsuario(setUsuario());
                Stage ventana = (Stage) botonRegistrar.getScene().getWindow();
                ventana.close();
            } else if (actionEvent.getSource() == botonCerrar) {
                Stage ventana = (Stage) botonCerrar.getScene().getWindow();
                ventana.close();
            }
        }
    }


}





















