module com.example.biblioteca3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.biblioteca3 to javafx.fxml;
    exports com.example.biblioteca3;
    exports com.example.biblioteca3.Controllers;
    opens com.example.biblioteca3.Controllers to javafx.fxml;
}