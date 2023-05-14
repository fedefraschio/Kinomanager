package com.example.kinomanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PubblicaScontiController implements Initializable{

    @FXML
    private Button backButton;
    
    @FXML
    private DatePicker dataEnd;

    @FXML
    private DatePicker dataStart;

    @FXML
    private ComboBox<String> etaBox;

    @FXML
    private Button pubblica;

    @FXML
    private TextField scontoText;
    
    
    private Stage stage;
	private Scene scene; 
	private Parent root;

    @FXML
    void back(MouseEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("com/example/kinomanager/HomeGestore.fxml"));
		root=loader.load();
		
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    
    @FXML
    void submit(MouseEvent e)
    {
    	scontoText.clear();
    	dataStart.setValue(null);
    	dataEnd.setValue(null);
    	etaBox.setValue(null);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		etaBox.setItems(FXCollections.observableArrayList("Sotto i 5 anni","6 - 10 anni","11 - 13 anni","14 - 16 anni"));
		
	}
    
}



