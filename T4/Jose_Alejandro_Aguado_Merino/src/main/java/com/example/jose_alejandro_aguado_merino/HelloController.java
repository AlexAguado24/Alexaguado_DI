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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField text_usuario, text_contrasenia;
    @FXML
    private Button boton_registrar, boton_acceder;
    private ObservableList<Usuario> listaUsuarios;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inicializar();
        acciones();

    }

    private void inicializar() {
        listaUsuarios = FXCollections.observableArrayList();
        listaUsuarios.add(new Usuario("admin",4567,"admin@admin","admin","admin"));
    }

    private void acciones() {
        boton_registrar.setOnAction(new ManejoPulsaciones());
        boton_acceder.setOnAction(new ManejoPulsaciones());
    }

    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == boton_registrar) {
                Stage ventana = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("formulario-view.fxml"));
                try {
                    Parent parent = fxmlLoader.load();
                    Scene scene = new Scene(parent, 400, 400);
                    ventana.setScene(scene);
                    ventana.show();
                    FormularioController controller = fxmlLoader.getController();
                    controller.setController(HelloController.this);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (actionEvent.getSource() == boton_acceder) {
                for (Usuario item : listaUsuarios) {
                    if (!item.getNombre().equalsIgnoreCase(text_usuario.getText())) {
                        System.out.println("El usuario no existe");
                    } else if (!item.getRol().equalsIgnoreCase("admin")) {
                        System.out.println("El usuario no tiene los permisos");
                    } else {
                        Stage ventana = new Stage();
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("acceder-view.fxml"));
                        try {
                            Parent parent = fxmlLoader.load();
                            Scene scene = new Scene(parent, 400, 400);
                            AccederController controller = fxmlLoader.getController();
                            controller.setearUsuario(listaUsuarios);
                            ventana.setScene(scene);
                            ventana.show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}