package controller.gestore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Film;
import model.GiornoDellaSettimana;
import model.Sala;
import model.Spettacolo;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Comparator;
import java.util.ResourceBundle;

public class GestioneProgrammazioneController implements Initializable{

	@FXML
	private TableColumn<Spettacolo, GiornoDellaSettimana> giornoDellaSettimana;

	@FXML
	private ComboBox<GiornoDellaSettimana> giornoComboBox;

	@FXML
	private TextField nomeInput;

	@FXML
	private TableColumn<Spettacolo, LocalTime> ora;

	@FXML
	private TextField orarioInput;

	@FXML
	private TableView<Spettacolo> programmazione;

	@FXML
	private TableColumn<Spettacolo, Integer> sala;

	@FXML
	private TextField salaInput;

	@FXML
	private TableColumn<Spettacolo, String> titolo;

	//comparator per ordinare la table
	Comparator<Spettacolo> spettacoloComparator;

	ObservableList<Spettacolo> list;

	ObservableList<GiornoDellaSettimana> giornoList;

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
	void removeRiga() {
		int selectedID=programmazione.getSelectionModel().getSelectedIndex();
		programmazione.getItems().remove(selectedID);
		nomeInput.clear();
		salaInput.clear();
		giornoComboBox.setValue(null);
		orarioInput.clear();
	}

	@FXML
	void rowClicked() {
		Spettacolo clicked =programmazione.getSelectionModel().getSelectedItem();
		nomeInput.setText(String.valueOf(clicked.getTitoloFilm()));
		salaInput.setText(String.valueOf(clicked.getNumeroSala()));
		giornoComboBox.setValue(clicked.getGiornoDellaSettimana());
		orarioInput.setText(String.valueOf(clicked.getOrario()));
	}

	@FXML
	void submit() {
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
	void submitGiorno() {
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
	void submitOra() {

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
		spettacoloComparator= Comparator.comparing(Spettacolo::getGiornoDellaSettimana).
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
		titolo.setCellValueFactory(new PropertyValueFactory<>("titoloFilm"));
		sala.setCellValueFactory(new PropertyValueFactory<>("numeroSala"));
		giornoDellaSettimana.setCellValueFactory(new PropertyValueFactory<>("giornoDellaSettimana"));
		ora.setCellValueFactory(new PropertyValueFactory<>("orario"));
		list=FXCollections.observableArrayList(s1,s2,s3);
		programmazione.setItems(list);
		list.sort(spettacoloComparator);
		giornoList=FXCollections.observableArrayList(GiornoDellaSettimana.Lunedì,GiornoDellaSettimana.Martedì,
				GiornoDellaSettimana.Mercoledì,GiornoDellaSettimana.Giovedì,GiornoDellaSettimana.Venerdì,
				GiornoDellaSettimana.Sabato,GiornoDellaSettimana.Domenica);
		giornoComboBox.setItems(giornoList);
	}

}



