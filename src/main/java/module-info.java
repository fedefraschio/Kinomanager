module com.example.kinomanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kinomanager to javafx.fxml;
    exports com.example.kinomanager;
}