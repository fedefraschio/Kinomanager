package controller.cassiere;


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
import persistence.Database;

import java.io.IOException;

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
		for(Cassiere c:data.getCassieri())
		{
			if(c.getUsername().equalsIgnoreCase(username) &&
			c.getPassword().equals(password))
			{
				found=true;
				data.setUsernameUtenteAttuale(c.getUsername());
				break;
			}
		}
		if(found)
		{
			FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/cassiere/HomeCassiere.fxml"));
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
