package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;
import persistence.Database;

import java.time.LocalDate;
import java.time.LocalTime;
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
			Cassiere defaultCassiere=new Cassiere("Mario","mariorossi@gmail.com","Mario","Rossi",
					LocalDate.of(2000,Month.NOVEMBER,10),"Rossi");
			data.addCassiere(c1);
			data.addCassiere(c2);
			data.addCassiere(defaultCassiere);

			Cliente b1=new Cliente("Luke456","lucaneri@gmail.com","Luca","Neri",
					LocalDate.of(1981, Month.JULY, 2),"canegatto");
			Cliente b2=new Cliente("CoolKid","cool.kid@gmail.com","Cool","Kid",
					LocalDate.of(2015,Month.DECEMBER,20),"1234");
			Cliente defaultCliente=new Cliente("Mario","mariorossi@gmail.com","Mario","Rossi",
					LocalDate.of(2000,Month.NOVEMBER,10),"Rossi");
			data.addCliente(b1);
			data.addCliente(b2);
			data.addCliente(defaultCliente);

			Film f1=new Film("Fast X","Azione");
			Film f2=new Film("Love Again","Romantico");
			Film f3=new Film("Borromini e Bernini","Storico");
			Spettacolo s1=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
					new Film("Fast X","Azione"), new Sala(5,200),
					LocalTime.of(21, 0));
			Spettacolo s2=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
					new Film("Love Again","Romantico"), new Sala(4,50),
					LocalTime.of(15,30));
			Spettacolo s3=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 21).getDayOfWeek()),
					new Film("Borromini e Bernini","Storico"), new Sala(1,25),
					LocalTime.of(21, 0));
			data.addSpettacolo(s1);
			data.addSpettacolo(s2);
			data.addSpettacolo(s3);
		}

	
}
