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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ImpostaPrezziController implements Initializable {

    @FXML
    private TextField textAbbonamento;

    @FXML
    private TextField textBiglietto;

    private float prezzoBiglietto;
    private float prezzoAbbonamento;

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
        this.prezzoBiglietto=Float.parseFloat(this.textBiglietto.getText());
        this.textBiglietto.setText(String.valueOf(this.prezzoBiglietto));
    }
    @FXML
    void submitAbbonamento()
    {
        this.prezzoAbbonamento=Float.parseFloat(this.textAbbonamento.getText());
        this.textAbbonamento.setText(String.valueOf(this.prezzoAbbonamento));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.prezzoBiglietto= 9.00F;
        this.prezzoAbbonamento= 40.00F;
        this.textBiglietto.setText(String.valueOf(this.prezzoBiglietto));
        this.textAbbonamento.setText(String.valueOf(this.prezzoAbbonamento));
    }
}
