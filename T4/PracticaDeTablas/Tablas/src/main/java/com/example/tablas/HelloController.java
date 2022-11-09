package com.example.tablas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class HelloController implements Initializable {
    @FXML
    private TableView tabla;
    @FXML
    private TableColumn columnaNombre, columnaApellido, columnaDni;
    @FXML
    private TextField campoFiltrar;

    private ObservableList listaTabla;

    private FilteredList listaFiltrada;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarDatos();
        acciones();
    }

    private void acciones() {
        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                System.out.println(((Usuario)t1).getId());
            }
        });
        campoFiltrar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                //System.out.println(t1);
                listaFiltrada.setPredicate(new Predicate() {
                    @Override
                    public boolean test(Object o) {
                        Usuario u = (Usuario) o;
                        return u.getNombre().toLowerCase().contains(t1.toLowerCase());
                    }
                });
            }
        });
    }

    private void asociarDatos() {
        tabla.setItems(listaFiltrada);
        columnaNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        columnaDni.setCellValueFactory(new PropertyValueFactory("dni"));
    }

    private void instancias() {
        listaTabla = FXCollections.observableArrayList();
        listaTabla.addAll(new Usuario("Usuario1","Apellido1", "1234A", "correo@correo.com",123,1),
        new Usuario("Ejemplo","Apellido2", "1234b", "correo@correo.com",123,2),
        new Usuario("NombreCompleto","Apellido3", "1234c", "correo@correo.com",123,3),
        new Usuario("OtroNom","Apellido4", "1234d", "correo@correo.com",123,4),
        new Usuario("NoFiltre","Apellido5", "1234e", "correo@correo.com",123,5));

        listaFiltrada = new FilteredList(listaTabla);
    }
}