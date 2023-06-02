module com {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.model;
    exports com.model;
    opens com.controller;
    exports com.controller.gestore;
    opens com.controller.gestore;
    exports com.controller.cliente;
    opens com.controller.cliente;
    exports com.app to javafx.graphics;
    opens com.app;

}