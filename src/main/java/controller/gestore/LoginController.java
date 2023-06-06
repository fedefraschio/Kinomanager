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

public class LoginController {

	@FXML
	TextField usernameField;

	@FXML
	private PasswordField passwordField;
	
	@FXML
	Label errorLabel;

	public void eseguiVerificaCredenziali(MouseEvent event) throws IOException
	{
		String username=usernameField.getText();
		String password=passwordField.getText();

		String usernameTest = "Mario";
		String passwordTest = "Rossi";
		if(username.contentEquals(usernameTest) && password.contentEquals(passwordTest))
		{
			FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/gestore/HomeGestore.fxml"));
			Parent root = loader.load();
			HomeGestoreController homeGestoreController=loader.getController();
			
			homeGestoreController.displayName(username);

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
