package com.example.kinomanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ImpostaPrezziController implements Initializable {


    @FXML
    private Button backButton;

    @FXML
    private Button buttonAbbonamento;

    @FXML
    private Button buttonBiglietto;

    @FXML
    private TextField textAbbonamento;

    @FXML
    private TextField textBiglietto;
    
    private Stage stage;
	private Scene scene; 
	private Parent root;

    private float prezzoBiglietto;
    private float prezzoAbbonamento;

    @FXML
    void back(MouseEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("HomeGestore.fxml"));
		root=loader.load();
		
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    
    @FXML
    void submitBiglietto(MouseEvent e)
    {
        this.prezzoBiglietto=Float.parseFloat(this.textBiglietto.getText());
        this.textBiglietto.setText(""+this.prezzoBiglietto);
    }
    @FXML
    void submitAbbonamento(MouseEvent e)
    {
        this.prezzoAbbonamento=Float.parseFloat(this.textAbbonamento.getText());
        this.textAbbonamento.setText(""+this.prezzoAbbonamento);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.prezzoBiglietto= 9.00F;
        this.prezzoAbbonamento= 40.00F;
        this.textBiglietto.setText(""+this.prezzoBiglietto);
        this.textAbbonamento.setText(""+this.prezzoAbbonamento);
    }
}
