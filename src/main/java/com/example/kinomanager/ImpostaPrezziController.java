package com.example.kinomanager;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ImpostaPrezziController {


    @FXML
    private Button backButton;

    @FXML
    private Button submitAbbonamento;

    @FXML
    private Button submitBiglietto;

    @FXML
    private TextField textAbbonamento;

    @FXML
    private TextField textBiglietto;
    
    private Stage stage;
	private Scene scene; 
	private Parent root;

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
    void submit(MouseEvent e)
    {
    	textBiglietto.clear();
    	textAbbonamento.clear();
    }
	
}
