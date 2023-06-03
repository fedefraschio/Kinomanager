package controller.cliente;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeClienteController {
	
	@FXML
	Label nameLabel;
	
	@FXML
    private Button toAcquista;
	
	@FXML
    private Button toProgrammazione;
	
	@FXML
    private Button toRecensioni;
    
    private Stage stage;
	private Scene scene; 
	private Parent root;

	public void displayName(String username)
	{
		nameLabel.setText("Benvenuto "+username+"! Scegli un'operazione.");
	}
	
	public void toAcquista(MouseEvent event) throws IOException
	{
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/cliente/ViewAcquista.fxml"));
		root=loader.load();
		
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void toProgrammazione(MouseEvent event) throws IOException
	{
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/cliente/ViewMostraProgrammazione.fxml"));
		root=loader.load();
		
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void toRecensioni(MouseEvent event) throws IOException
	{
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/cliente/ViewRecensioni.fxml"));
		root=loader.load();
		
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
}
