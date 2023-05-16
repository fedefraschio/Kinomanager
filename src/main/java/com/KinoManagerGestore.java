package com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class KinoManagerGestore extends Application {
	


	    public void start(Stage primaryStage) throws Exception{

			Parent root = FXMLLoader.load(getClass().getResource("/com/controller/gestore/ViewLoginGestore.fxml"));

			primaryStage.setTitle("KinoManager");

			primaryStage.setScene(new Scene(root));

			primaryStage.show();

	    }


	    public static void main(String[] args) {

	        launch(args);

	    }

	
}
