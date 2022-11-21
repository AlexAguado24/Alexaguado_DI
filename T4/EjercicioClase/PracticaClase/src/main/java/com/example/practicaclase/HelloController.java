package com.example.practicaclase;

import com.example.practicaclase.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableView<Usuario> tabla;
    @FXML
    private TableColumn columnaId, columnaNombre, columnaCorreo;
    @FXML
    private Button botonAgregar,botonDetalles, botonEliminar;
    @FXML
    private MenuItem menuAniadir, menuDetalles, menuEliminar;

    private ObservableList<Usuario> listaTabla;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        asociarDatos();
        instancias();
        acciones();

    }

    private void acciones() {
        menuAniadir.setOnAction(new ManejoPulsaciones());
        botonAgregar.setOnAction(new ManejoPulsaciones());
        menuDetalles.setOnAction(new ManejoPulsaciones());
        botonDetalles.setOnAction(new ManejoPulsaciones());
        menuEliminar.setOnAction(new ManejoPulsaciones());
        botonEliminar.setOnAction(new ManejoPulsaciones());
    }

    private void instancias() {
        listaTabla = FXCollections.observableArrayList();

    }

    private void asociarDatos() {
        tabla.setItems(listaTabla);
        columnaId.setCellValueFactory(new PropertyValueFactory("id"));
        columnaId.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaId.setCellValueFactory(new PropertyValueFactory("correo"));
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == menuAniadir || actionEvent.getSource() == botonAgregar) {
                Stage ventanaAniadir = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("aniadir-view.fxml"));
                try {
                    Parent root = fxmlLoader.load();
                    Scene escenaAniadir = new Scene(root,500,500);
                    ventanaAniadir.setScene(escenaAniadir);
                    AniadirController controller = fxmlLoader.getController();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (actionEvent.getSource() == menuDetalles || actionEvent.getSource() == botonDetalles) {
                Stage ventanaAniadir = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("detail-view.fxml"));
                try {
                    Parent root = fxmlLoader.load();
                    Scene escenaAniadir = new Scene(root,500,500);
                    ventanaAniadir.setScene(escenaAniadir);
                    DetailController controller = fxmlLoader.getController();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }else if (actionEvent.getSource() == menuEliminar || actionEvent.getSource() == botonEliminar){
                if (tabla.getSelectionModel().getSelectedIndex()>-1) {
                    //borro
                    listaTabla.remove(tabla.getSelectionModel().getSelectedIndex());
                } else {
                    System.out.println("");
                }
            }
        }
    }
}