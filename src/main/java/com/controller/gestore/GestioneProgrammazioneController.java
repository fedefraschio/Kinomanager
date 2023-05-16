package com.controller.gestore;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Comparator;
import java.util.ResourceBundle;

import com.model.*;
import com.util.RigaProgrammazione;
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
    private TableView<RigaProgrammazione> programmazione;
	
	@FXML
	private TableColumn<RigaProgrammazione, String> titolo;
	
	@FXML
    private TableColumn<RigaProgrammazione, Integer> sala;

	@FXML
	private TableColumn<RigaProgrammazione, GiornoDellaSettimana> giornoDellaSettimana;
	
    @FXML
    private TableColumn<RigaProgrammazione, LocalDate> data;

    @FXML
    private TableColumn<RigaProgrammazione, LocalTime> ora;

    @FXML
    private TextField nomeInput;
    
    @FXML
    private TextField salaInput;

	@FXML
	private TextField giornoDellaSettimanaInput;
    
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

	//comparator per ordinare la table
	Comparator<RigaProgrammazione> rigaProgrammazioneComparator= Comparator.comparing(RigaProgrammazione::getData).
			thenComparing(RigaProgrammazione::getOra).thenComparing(RigaProgrammazione::getSala);


	//dati per la tabella
   	Spettacolo s1=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
			new Film("Fast X","Azione"), new Sala(5),
			LocalDate.of(2023, Month.JUNE, 23), LocalTime.of(21,00));
	Spettacolo s2=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
			new Film("Love Again","Romantico"), new Sala(4),
			LocalDate.of(2023, Month.JUNE, 23), LocalTime.of(15,30));
	Spettacolo s3=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 21).getDayOfWeek()),
			new Film("Borromini e Bernini","Storico"), new Sala(1),
			LocalDate.of(2023, Month.JUNE, 21), LocalTime.of(21,00));
    
    ObservableList<RigaProgrammazione> list=FXCollections.observableArrayList(
			new RigaProgrammazione(s1),new RigaProgrammazione(s2),new RigaProgrammazione(s3));

	//

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		titolo.setCellValueFactory(new PropertyValueFactory<RigaProgrammazione, String>("titolo"));
		sala.setCellValueFactory(new PropertyValueFactory<RigaProgrammazione, Integer>("sala"));
		giornoDellaSettimana.setCellValueFactory(new PropertyValueFactory<RigaProgrammazione,GiornoDellaSettimana>("giornoDellaSettimana"));
		data.setCellValueFactory(new PropertyValueFactory<RigaProgrammazione, LocalDate>("data"));
		ora.setCellValueFactory(new PropertyValueFactory<RigaProgrammazione, LocalTime>("ora"));
		giornoDellaSettimanaInput.setEditable(false);
		programmazione.setItems(list);
		list.sort(rigaProgrammazioneComparator);
	}
	
	//Submit button
	@FXML
	void submit (MouseEvent event)
	{
		RigaProgrammazione rigaProgrammazione =new RigaProgrammazione(nomeInput.getText(),
				Integer.parseInt(salaInput.getText()),
				GiornoDellaSettimana.getGiornoDaDay(LocalDate.parse(dataInput.getText()).getDayOfWeek()),
				LocalDate.parse(dataInput.getText()),
				LocalTime.parse(orarioInput.getText()));
		ObservableList<RigaProgrammazione> righe=programmazione.getItems();
		righe.add(rigaProgrammazione);
		programmazione.setItems(righe);
		list.sort(rigaProgrammazioneComparator);

		nomeInput.clear();
		salaInput.clear();
		giornoDellaSettimanaInput.clear();
		dataInput.clear();
		orarioInput.clear();
	}
	
	@FXML
	void submitData(MouseEvent event)
	{
		ObservableList<RigaProgrammazione> currentTableData=programmazione.getItems();
		String titolo=nomeInput.getText();
		int sala=Integer.parseInt(salaInput.getText());
		LocalTime orario=LocalTime.parse(orarioInput.getText());
		
		for(RigaProgrammazione r: currentTableData)
		{
			if(r.getTitolo().equals(titolo) &&
					r.getSala()==sala &&
					r.getOra().equals(orario))
			{
				r.setData(LocalDate.parse(dataInput.getText()));
				programmazione.setItems(currentTableData);
				programmazione.refresh();
				list.sort(rigaProgrammazioneComparator);
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
		giornoDellaSettimanaInput.clear();
	}
	
	@FXML
	void submitOra(MouseEvent event)
	{
		ObservableList<RigaProgrammazione> currentTableData=programmazione.getItems();
		String titolo=nomeInput.getText();
		int sala=Integer.parseInt(salaInput.getText());
		LocalDate data=LocalDate.parse(dataInput.getText());
		
		for(RigaProgrammazione r: currentTableData)
		{
			if(r.getTitolo().equals(titolo) &&
					r.getSala()==sala &&
					r.getData().isEqual(data)
					)
			{
				r.setOra(LocalTime.parse(orarioInput.getText()));
				programmazione.setItems(currentTableData);
				programmazione.refresh();
				list.sort(rigaProgrammazioneComparator);
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
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/controller/gestore/HomeGestore.fxml"));
		root=loader.load();
		
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	void rowClicked(MouseEvent event)
	{
		RigaProgrammazione clickedRigaProgrammazione =programmazione.getSelectionModel().getSelectedItem();
		nomeInput.setText(String.valueOf(clickedRigaProgrammazione.getTitolo()));
		salaInput.setText(String.valueOf(clickedRigaProgrammazione.getSala()));
		giornoDellaSettimanaInput.setText(String.valueOf(clickedRigaProgrammazione.getGiornoDellaSettimana()));
		dataInput.setText(String.valueOf(clickedRigaProgrammazione.getData()));
		orarioInput.setText(String.valueOf(clickedRigaProgrammazione.getOra()));
	}


}



