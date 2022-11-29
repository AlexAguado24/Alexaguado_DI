module com.example.jose_alejandro_aguado_merino {
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
    requires org.json;

    opens com.example.jose_alejandro_aguado_merino to javafx.fxml;
    exports com.example.jose_alejandro_aguado_merino;
}