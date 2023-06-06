package controller.gestore;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Cassiere;
import model.Gestore;
import persistence.Database;

public class LoginController {

	@FXML
	TextField usernameField;

	@FXML
	private PasswordField passwordField;
	
	@FXML
	Label errorLabel;
	Database data= Database.getInstance();

	public void eseguiVerificaCredenziali(MouseEvent event) throws IOException
	{
		String username=usernameField.getText();
		String password=passwordField.getText();


		boolean found=false;
		for(Gestore g:data.getGestori())
		{
			if(g.getUsername().equalsIgnoreCase(username) &&
					g.getPassword().equals(password))
			{
				found=true;
				data.setUsernameUtenteAttuale(g.getUsername());
				break;
			}
		}
		if(found)
		{
			FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/gestore/HomeGestore.fxml"));
			Parent root = loader.load();

			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		else
		{
			errorLabel.setText("Errore! Username o password errati.");
			usernameField.clear();
			passwordField.clear();
		}

	}
	
}
