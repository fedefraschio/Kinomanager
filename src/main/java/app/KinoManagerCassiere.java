package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Cassiere;
import persistence.Database;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;


public class KinoManagerCassiere extends Application {
	


	    public void start(Stage primaryStage) throws Exception{

			initData();

			Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/cassiere/ViewLoginCassiere.fxml")));

			primaryStage.setTitle("KinoManager - Cassiere");

			primaryStage.getIcons().add(new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/logoWithoutName.png"))));

			primaryStage.setScene(new Scene(root));

			primaryStage.show();

	    }


	    public static void main(String[] args) {

	        launch(args);

	    }

		private void initData()
		{
			Database data= Database.getInstance();

			//set dati utili al cassiere
			Cassiere c1=new Cassiere("Mark123","marcoverdi@gmail.com","Marco","Verdi",
					LocalDate.of(1980, Month.AUGUST, 1),"password1234");
			Cassiere c2=new Cassiere("ClaraX","Clara_Bianchi@gmail.com","Clara","Bianchi",
					LocalDate.of(1995,Month.DECEMBER,14),"Psw98");
			data.addCassiere(c1);
			data.addCassiere(c2);
		}

	
}
