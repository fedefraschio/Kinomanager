package controller.gestore;

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

public class HomeGestoreController implements Initializable {
	
	@FXML
	Label nameLabel;

    private Stage stage;
	private Scene scene; 
	private Parent root;

	Database data= Database.getInstance();


	public void toSconti(MouseEvent event) throws IOException
	{
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/gestore/ViewPubblicaSconti.fxml"));
		root=loader.load();
		
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void toProgrammazione(MouseEvent event) throws IOException
	{
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/gestore/ViewGestioneProgrammazione.fxml"));
		root=loader.load();
		
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void toPrezzi(MouseEvent event) throws IOException
	{
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/gestore/ViewImpostaPrezzi.fxml"));
		root=loader.load();
		
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void toAggiungiCassiere(MouseEvent event) throws IOException
	{
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/gestore/ViewAggiungiCassiere.fxml"));
		root=loader.load();
		
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void toRimuoviCassiere(MouseEvent event) throws IOException
	{
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/gestore/ViewRimuoviCassiere.fxml"));
		root=loader.load();
		
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		this.nameLabel.setText("Benvenuto "+data.getUsernameUtenteAttuale()+"! Quale azione vuoi eseguire?");
	}
}
