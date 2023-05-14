import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	


	    public void start(Stage primaryStage) throws Exception{

			FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("gestoreController.ViewLoginGestore.fxml"));

			fxmlLoader.setRoot(new AnchorPane());

			Parent root = fxmlLoader.load();

	        primaryStage.setTitle("KinoManager");

	        primaryStage.setScene(new Scene(root));

	        primaryStage.show();

	    }


	    public static void main(String[] args) {

	        launch(args);

	    }

	
}
