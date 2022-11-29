package com.example.jose_alejandro_aguado_merino;

import com.almasb.fxgl.app.MenuItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AccederController implements Initializable {

    @FXML
    private MenuItem menuGuest;

    @FXML
    private MenuItem menuUser;

    @FXML
    private MenuItem menuDev;

    @FXML
    private MenuItem menuTest;

    @FXML
    private MenuItem menuAll;

    @FXML
    private TableView<Usuario> tabla;

    @FXML
    private TableColumn columNombre;

    @FXML
    private TableColumn columCorreo;

    @FXML
    private TableColumn columRoll;

    private ObservableList<Usuario> listaTabla;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inicializar();
        asociarDatos();
    }

    private void asociarDatos() {
        tabla.setItems(listaTabla);
        columNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
        columRoll.setCellValueFactory(new PropertyValueFactory("roll"));
    }

    private void inicializar() {
        listaTabla = FXCollections.observableArrayList();
    }

    public void setearUsuario(ObservableList<Usuario> usuarios) {
        for (Usuario item : usuarios) {
            listaTabla.add(item);
        }
    }


}
