package com.controller.gestore;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Comparator;
import java.util.ResourceBundle;

import com.model.*;
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
    private TableView<Spettacolo> programmazione;
	
	@FXML
	private TableColumn<Spettacolo, String> titolo;
	
	@FXML
    private TableColumn<Spettacolo, Integer> sala;

	@FXML
	private TableColumn<Spettacolo, GiornoDellaSettimana> giornoDellaSettimana;
	
    @FXML
    private TableColumn<Spettacolo, LocalDate> data;

    @FXML
    private TableColumn<Spettacolo, LocalTime> ora;

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
	Comparator<Spettacolo> spettacoloComparator= Comparator.comparing(Spettacolo::getData).
			thenComparing(Spettacolo::getOrario).thenComparing(Spettacolo::getNumeroSala);


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
    
    ObservableList<Spettacolo> list=FXCollections.observableArrayList(s1,s2,s3);

	//

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		titolo.setCellValueFactory(new PropertyValueFactory<Spettacolo, String>("titoloFilm"));
		sala.setCellValueFactory(new PropertyValueFactory<Spettacolo, Integer>("numeroSala"));
		giornoDellaSettimana.setCellValueFactory(new PropertyValueFactory<Spettacolo,GiornoDellaSettimana>("giornoDellaSettimana"));
		data.setCellValueFactory(new PropertyValueFactory<Spettacolo, LocalDate>("data"));
		ora.setCellValueFactory(new PropertyValueFactory<Spettacolo, LocalTime>("orario"));
		giornoDellaSettimanaInput.setEditable(false);
		programmazione.setItems(list);
		list.sort(spettacoloComparator);
	}
	
	//Submit button
	@FXML
	void submit (MouseEvent event)
	{
		Spettacolo s =new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.parse(dataInput.getText()).getDayOfWeek()),
				new Film(nomeInput.getText()), new Sala(Integer.parseInt(salaInput.getText())),
				LocalDate.parse(dataInput.getText()), LocalTime.parse(orarioInput.getText()));

		ObservableList<Spettacolo> righe=programmazione.getItems();
		righe.add(s);
		programmazione.setItems(righe);
		list.sort(spettacoloComparator);

		nomeInput.clear();
		salaInput.clear();
		giornoDellaSettimanaInput.clear();
		dataInput.clear();
		orarioInput.clear();
	}
	
	@FXML
	void submitData(MouseEvent event)
	{
		ObservableList<Spettacolo> currentTableData=programmazione.getItems();
		String titolo=nomeInput.getText();
		int sala=Integer.parseInt(salaInput.getText());
		LocalTime orario=LocalTime.parse(orarioInput.getText());
		
		for(Spettacolo s: currentTableData)
		{
			if(s.getTitoloFilm().equals(titolo) &&
					s.getNumeroSala()==sala &&
					s.getOrario().equals(orario))
			{
				s.setData(LocalDate.parse(dataInput.getText()));
				programmazione.setItems(currentTableData);
				programmazione.refresh();
				list.sort(spettacoloComparator);
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
		ObservableList<Spettacolo> currentTableData=programmazione.getItems();
		String titolo=nomeInput.getText();
		int sala=Integer.parseInt(salaInput.getText());
		LocalDate data=LocalDate.parse(dataInput.getText());
		
		for(Spettacolo s: currentTableData)
		{
			if(s.getTitoloFilm().equals(titolo) &&
					s.getNumeroSala()==sala &&
					s.getData().isEqual(data)
					)
			{
				s.setOrario(LocalTime.parse(orarioInput.getText()));
				programmazione.setItems(currentTableData);
				programmazione.refresh();
				list.sort(spettacoloComparator);
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
		Spettacolo clicked =programmazione.getSelectionModel().getSelectedItem();
		nomeInput.setText(String.valueOf(clicked.getTitoloFilm()));
		salaInput.setText(String.valueOf(clicked.getNumeroSala()));
		giornoDellaSettimanaInput.setText(String.valueOf(clicked.getGiornoDellaSettimana()));
		dataInput.setText(String.valueOf(clicked.getData()));
		orarioInput.setText(String.valueOf(clicked.getOrario()));
	}


}



