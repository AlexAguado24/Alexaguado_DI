package com.example.calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculadoraAplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculadoraAplication.class.getResource("calculadora.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 670, 480);
        stage.setTitle("Proyecto Calculadora");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}