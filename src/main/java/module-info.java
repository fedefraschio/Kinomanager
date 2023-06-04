module com {
    requires javafx.controls;
    requires javafx.fxml;


    opens model;
    exports model;
    exports controller.gestore;
    opens controller.gestore;
    exports controller.cliente;
    opens controller.cliente;
    exports controller.cassiere;
    opens controller.cassiere;
    exports app to javafx.graphics;
    opens app;

}