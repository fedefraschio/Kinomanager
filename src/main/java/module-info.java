module com {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.model;
    exports com.model;
    exports com to javafx.graphics;
    opens com;
    exports com.controller;
    opens com.controller;
    exports com.controller.gestore;
    opens com.controller.gestore;
    exports com.util;
    opens com.util;

}