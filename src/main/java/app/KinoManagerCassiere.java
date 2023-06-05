package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;


public class KinoManagerCassiere extends Application {
	


	    public void start(Stage primaryStage) throws Exception{

			Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/cassiere/ViewLoginCassiere.fxml")));

			primaryStage.setTitle("KinoManager - Cassiere");

			primaryStage.getIcons().add(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/logoWithoutName.png"))));

			primaryStage.setScene(new Scene(root));

			primaryStage.show();

	    }


	    public static void main(String[] args) {

	        launch(args);

	    }

	
}
