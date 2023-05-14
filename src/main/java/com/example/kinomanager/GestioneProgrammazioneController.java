package com.example.kinomanager;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;

public class GestioneProgrammazioneController implements Initializable{
	
	private Stage stage;
	private Scene scene; 
	private Parent root;

	@FXML
    private TableView<Riga> programmazione;
	
	@FXML
	private TableColumn<Riga, String> titolo;
	
	@FXML
    private TableColumn<Riga, Integer> sala;
	
    @FXML
    private TableColumn<Riga, LocalDate> data;

    @FXML
    private TableColumn<Riga, LocalTime> ora;

    @FXML
    private TextField nomeInput;
    
    @FXML
    private TextField salaInput;
    
    @FXML
    private TextField dataInput;
    
    @FXML
    private TextField orarioInput;
    
    @FXML
    private Button immetti;
    
    @FXML
    private Button rimuovi;
    
    @FXML
    private Button immettiData;
    
    @FXML
    private Button immettiOra;
    
    @FXML
    private Button pulisciCampi;
    
    @FXML
    private Button back;

   
    
    ObservableList<Riga> list=FXCollections.observableArrayList(
    		new Riga("Fast X", 5, LocalDate.of(2023, Month.JUNE, 23), LocalTime.of(21,00)),
			new Riga("Love Again", 4, LocalDate.of(2023, Month.JUNE, 23), LocalTime.of(15,30)),
			new Riga("Borromini e Bernini", 1, LocalDate.of(2023, Month.JUNE, 21), LocalTime.of(21,00)));

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		titolo.setCellValueFactory(new PropertyValueFactory<Riga, String>("titolo"));
		sala.setCellValueFactory(new PropertyValueFactory<Riga, Integer>("sala"));
		data.setCellValueFactory(new PropertyValueFactory<Riga, LocalDate>("data"));
		ora.setCellValueFactory(new PropertyValueFactory<Riga, LocalTime>("ora"));
		
		programmazione.setItems(list);
	}
	
	//Submit button
	@FXML
	void submit (MouseEvent event)
	{
		Riga riga=new Riga(nomeInput.getText(),
				Integer.parseInt(salaInput.getText()),
				LocalDate.parse(dataInput.getText()),
				LocalTime.parse(orarioInput.getText()));
		ObservableList<Riga> righe=programmazione.getItems();
		righe.add(riga);
		programmazione.setItems(righe);
	}
	
	@FXML
	void submitData(MouseEvent event)
	{
		ObservableList<Riga> currentTableData=programmazione.getItems();
		String titolo=nomeInput.getText();
		int sala=Integer.parseInt(salaInput.getText());
		LocalTime orario=LocalTime.parse(orarioInput.getText());
		
		for(Riga r: currentTableData)
		{
			if(r.getTitolo().equals(titolo) &&
					r.getSala()==sala &&
					r.getOra().equals(orario))
			{
				r.setData(LocalDate.parse(dataInput.getText()));
				programmazione.setItems(currentTableData);
				programmazione.refresh();
				break;
			}
		}
			
	}
	
	@FXML
	void clear(MouseEvent event)
	{
		nomeInput.clear();
		salaInput.clear();
		orarioInput.clear();
		dataInput.clear();
	}
	
	@FXML
	void submitOra(MouseEvent event)
	{
		ObservableList<Riga> currentTableData=programmazione.getItems();
		String titolo=nomeInput.getText();
		int sala=Integer.parseInt(salaInput.getText());
		LocalDate data=LocalDate.parse(dataInput.getText());
		
		for(Riga r: currentTableData)
		{
			if(r.getTitolo().equals(titolo) &&
					r.getSala()==sala &&
					r.getData().isEqual(data)
					)
			{
				r.setOra(LocalTime.parse(orarioInput.getText()));
				programmazione.setItems(currentTableData);
				programmazione.refresh();
				break;
			}
		}
			
	}
	
	@FXML
	void removeRiga(MouseEvent event)
	{
		int selectedID=programmazione.getSelectionModel().getSelectedIndex();
		programmazione.getItems().remove(selectedID);
	}
	
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
	void rowClicked(MouseEvent event)
	{
		Riga clickedRiga=programmazione.getSelectionModel().getSelectedItem();
		nomeInput.setText(String.valueOf(clickedRiga.getTitolo()));
		salaInput.setText(String.valueOf(clickedRiga.getSala()));
		dataInput.setText(String.valueOf(clickedRiga.getData()));
		orarioInput.setText(String.valueOf(clickedRiga.getOra()));
	}

}



