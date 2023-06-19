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
import persistence.Database;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
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

	Database data= Database.getInstance();

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
		data.removeSpettacolo(selectedID);
		programmazione.refresh();
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

		data.addSpettacolo(s);
		data.sortSpettacoli();
		programmazione.refresh();

		nomeInput.clear();
		salaInput.clear();
		giornoComboBox.setValue(null);
		orarioInput.clear();
	}

	@FXML
	void submitGiorno() {
		String titolo=nomeInput.getText();
		int sala=Integer.parseInt(salaInput.getText());
		LocalTime orario=LocalTime.parse(orarioInput.getText());

		for(Spettacolo s: data.getSpettacoli())
		{
			if(s.getTitoloFilm().equals(titolo) &&
					s.getNumeroSala()==sala &&
					s.getOrario().equals(orario))
			{
				s.setGiornoDellaSettimana(giornoComboBox.getSelectionModel().getSelectedItem());
				data.sortSpettacoli();
				programmazione.refresh();
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
		String titolo=nomeInput.getText();
		int sala=Integer.parseInt(salaInput.getText());
		GiornoDellaSettimana giorno=giornoComboBox.getSelectionModel().getSelectedItem();

		for(Spettacolo s: data.getSpettacoli())
		{
			if(s.getTitoloFilm().equals(titolo) &&
					s.getNumeroSala()==sala
					&& s.getGiornoDellaSettimana().equals(giorno)
			)
			{
				s.setOrario(LocalTime.parse(orarioInput.getText()));
				data.sortSpettacoli();
				programmazione.refresh();
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
		titolo.setCellValueFactory(new PropertyValueFactory<>("titoloFilm"));
		sala.setCellValueFactory(new PropertyValueFactory<>("numeroSala"));
		giornoDellaSettimana.setCellValueFactory(new PropertyValueFactory<>("giornoDellaSettimana"));
		ora.setCellValueFactory(new PropertyValueFactory<>("orario"));
		programmazione.setItems(data.getSpettacoli());
		giornoList=FXCollections.observableArrayList(GiornoDellaSettimana.Lunedì,GiornoDellaSettimana.Martedì,
				GiornoDellaSettimana.Mercoledì,GiornoDellaSettimana.Giovedì,GiornoDellaSettimana.Venerdì,
				GiornoDellaSettimana.Sabato,GiornoDellaSettimana.Domenica);
		giornoComboBox.setItems(giornoList);
	}

}



