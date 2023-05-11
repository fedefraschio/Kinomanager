package com.example.kinomanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KinomanagerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KinomanagerApplication.class.getResource("kinomanager.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("KINOMANAGER");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}