package controller.cassiere;

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

public class HomeCassiereController {

	@FXML
	private Label nameLabel;

	@FXML
	private Button toAggiungiClienteButton;

	@FXML
	private Button toRimuoviClienteButton;

	@FXML
	private Button toVendiAbbonamentoButton;

	@FXML
	private Button toVendiButton;

	private Stage stage;
	private Scene scene;
	private Parent root;

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

	public void displayName(String username) {
	}
}
