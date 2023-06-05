package controller.gestore;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Comparator;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import model.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import model.Film;
import model.GiornoDellaSettimana;
import model.Sala;
import model.Spettacolo;

public class GestioneProgrammazioneController implements Initializable{
	
	private Stage stage;
	private Scene scene; 
	private Parent root;

	@FXML
	private Button back;

	@FXML
	private TableColumn<Spettacolo, GiornoDellaSettimana> giornoDellaSettimana;

	@FXML
	private Button immetti;

	@FXML
	private ComboBox<GiornoDellaSettimana> giornoComboBox;

	@FXML
	private Button immettiGiorno;

	@FXML
	private Button immettiOra;

	@FXML
	private TextField nomeInput;

	@FXML
	private TableColumn<Spettacolo, LocalTime> ora;

	@FXML
	private TextField orarioInput;

	@FXML
	private TableView<Spettacolo> programmazione;

	@FXML
	private Button rimuovi;

	@FXML
	private TableColumn<Spettacolo, Integer> sala;

	@FXML
	private TextField salaInput;

	@FXML
	private TableColumn<Spettacolo, String> titolo;

	//comparator per ordinare la table
	Comparator<Spettacolo> spettacoloComparator= Comparator.comparing(Spettacolo::getGiornoDellaSettimana).
			thenComparing(Spettacolo::getOrario).thenComparing(Spettacolo::getNumeroSala);


	//dati per la tabella
	Spettacolo s1=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
			new Film("Fast X","Azione"), new Sala(5,200),
			LocalTime.of(21, 0));
	Spettacolo s2=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
			new Film("Love Again","Romantico"), new Sala(4,100),
			LocalTime.of(15,30));
	Spettacolo s3=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 21).getDayOfWeek()),
			new Film("Borromini e Bernini","Storico"), new Sala(1,50),
			LocalTime.of(21, 0));

	ObservableList<Spettacolo> list=FXCollections.observableArrayList(s1,s2,s3);

	ObservableList<GiornoDellaSettimana> giornoList=FXCollections.observableArrayList(GiornoDellaSettimana.Lunedì,GiornoDellaSettimana.Martedì,
			GiornoDellaSettimana.Mercoledì,GiornoDellaSettimana.Giovedì,GiornoDellaSettimana.Venerdì,
			GiornoDellaSettimana.Sabato,GiornoDellaSettimana.Domenica);;

	@FXML
	void back(MouseEvent event) throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/gestore/HomeGestore.fxml"));
		root=loader.load();

		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	void removeRiga(MouseEvent event) {
		int selectedID=programmazione.getSelectionModel().getSelectedIndex();
		programmazione.getItems().remove(selectedID);
		nomeInput.clear();
		salaInput.clear();
		giornoComboBox.setValue(null);
		orarioInput.clear();
	}

	@FXML
	void rowClicked(MouseEvent event) {
		Spettacolo clicked =programmazione.getSelectionModel().getSelectedItem();
		nomeInput.setText(String.valueOf(clicked.getTitoloFilm()));
		salaInput.setText(String.valueOf(clicked.getNumeroSala()));
		giornoComboBox.setValue(clicked.getGiornoDellaSettimana());
		orarioInput.setText(String.valueOf(clicked.getOrario()));
	}

	@FXML
	void submit(MouseEvent event) {
		Spettacolo s =new Spettacolo(giornoComboBox.getSelectionModel().getSelectedItem(),
				new Film(nomeInput.getText()), new Sala(Integer.parseInt(salaInput.getText())),
				LocalTime.parse(orarioInput.getText()));

		ObservableList<Spettacolo> righe=programmazione.getItems();
		righe.add(s);
		programmazione.setItems(righe);
		list.sort(spettacoloComparator);

		nomeInput.clear();
		salaInput.clear();
		giornoComboBox.setValue(null);
		orarioInput.clear();
	}

	@FXML
	void submitGiorno(MouseEvent event) {
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
				s.setGiornoDellaSettimana(giornoComboBox.getSelectionModel().getSelectedItem());
				programmazione.setItems(currentTableData);
				programmazione.refresh();
				list.sort(spettacoloComparator);
				break;
			}
		}
		nomeInput.clear();
		salaInput.clear();
		giornoComboBox.setValue(null);
		orarioInput.clear();
	}

	@FXML
	void submitOra(MouseEvent event) {

		ObservableList<Spettacolo> currentTableData=programmazione.getItems();
		String titolo=nomeInput.getText();
		int sala=Integer.parseInt(salaInput.getText());
		GiornoDellaSettimana giorno=giornoComboBox.getSelectionModel().getSelectedItem();

		for(Spettacolo s: currentTableData)
		{
			if(s.getTitoloFilm().equals(titolo) &&
					s.getNumeroSala()==sala
					&& s.getGiornoDellaSettimana().equals(giorno)
			)
			{
				s.setOrario(LocalTime.parse(orarioInput.getText()));
				programmazione.setItems(currentTableData);
				programmazione.refresh();
				list.sort(spettacoloComparator);
				break;
			}
		}
		nomeInput.clear();
		salaInput.clear();
		giornoComboBox.setValue(null);
		orarioInput.clear();
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		titolo.setCellValueFactory(new PropertyValueFactory<Spettacolo, String>("titoloFilm"));
		sala.setCellValueFactory(new PropertyValueFactory<Spettacolo, Integer>("numeroSala"));
		giornoDellaSettimana.setCellValueFactory(new PropertyValueFactory<Spettacolo,GiornoDellaSettimana>("giornoDellaSettimana"));
		ora.setCellValueFactory(new PropertyValueFactory<Spettacolo, LocalTime>("orario"));
		programmazione.setItems(list);
		list.sort(spettacoloComparator);
		giornoComboBox.setItems(giornoList);
	}

}



