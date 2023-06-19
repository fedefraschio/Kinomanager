package controller.gestore;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import persistence.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ImpostaPrezziController implements Initializable {

    @FXML
    private TextField textAbbonamento;

    @FXML
    private TextField textBiglietto;

    Database data=Database.getInstance();

    @FXML
    void back(MouseEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/gestore/HomeGestore.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    
    @FXML
    void submitBiglietto()
    {
        data.setPrezzoBiglietto(Float.parseFloat(this.textBiglietto.getText()));
        //this.textBiglietto.setText(String.valueOf(this.prezzoBiglietto));
    }
    @FXML
    void submitAbbonamento()
    {
        data.setPrezzoAbbonamento(Float.parseFloat(this.textAbbonamento.getText()));
        //this.textAbbonamento.setText(String.valueOf(this.prezzoAbbonamento));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.textBiglietto.setText(String.valueOf(data.getPrezzoBiglietto()));
        this.textAbbonamento.setText(String.valueOf(data.getPrezzoAbbonamento()));
    }
}
