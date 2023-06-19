package controller.cliente;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import persistence.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeClienteController implements Initializable {
	
	@FXML
	Label nameLabel;
    
    private Stage stage;
	private Scene scene; 
	private Parent root;
	Database data= Database.getInstance();

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		this.nameLabel.setText("Benvenuto "+data.getUsernameUtenteAttuale()+"! Quale azione vuoi eseguire?");
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
