module com.example.practicaclase {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    /*requires validatorfx;*/
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    /*requires eu.hansolo.tilesfx;*/
    requires com.almasb.fxgl.all;

    opens com.example.practicaclase to javafx.fxml;
    exports com.example.practicaclase;
    exports com.example.practicaclase.model;
    opens com.example.practicaclase.model to javafx.fxml;
}