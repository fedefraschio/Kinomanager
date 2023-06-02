package com.controller.cliente;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

	@FXML
	TextField usernameField;
	
	@FXML
	TextField passwordField;
	
	@FXML
	Label errorLabel;
	
	private Stage stage;
	private Scene scene; 
	private Parent root;
	
	private String usernameTest="Mario";
	private String passwordTest="Rossi";
	
	public void eseguiVerificaCredenziali(MouseEvent event) throws IOException
	{
		String username=usernameField.getText();
		String password=passwordField.getText();
		
		if(username.contentEquals(usernameTest) && password.contentEquals(passwordTest))
		{
			FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/controller/cliente/HomeCliente.fxml"));
			root=loader.load();
			HomeClienteController homeClienteController=loader.getController();
			
			homeClienteController.displayName(username);
			
			stage=(Stage)((Node)event.getSource()).getScene().getWindow();
			scene=new Scene(root);
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