package controller.cassiere;

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

public class HomeCassiereController implements Initializable {


	@FXML
	private Label nameLabel;
	private Stage stage;
	private Scene scene;
	private Parent root;
	Database data= Database.getInstance();

	@FXML
	void toAggiungiCliente(MouseEvent event) throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/cassiere/ViewAggiungiCliente.fxml"));
		root=loader.load();

		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void toRimuoviCliente(MouseEvent event) throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/cassiere/ViewRimuoviCliente.fxml"));
		root=loader.load();

		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void toVendiAbbonamento(MouseEvent event) throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/cassiere/ViewVenditaAbbonamento.fxml"));
		root=loader.load();

		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void toVendiBiglietto(MouseEvent event) throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/cassiere/ViewVenditaBiglietto.fxml"));
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
