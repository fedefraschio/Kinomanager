package controller.cliente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Abbonamento;
import model.GiornoDellaSettimana;
import model.Spettacolo;
import persistence.Database;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.Random;
import java.util.ResourceBundle;

public class AcquistaController implements Initializable {

    @FXML
    private Text abbonamentoAttivoLabel;

    @FXML
    private DatePicker abbonamentoDatePicker;

    @FXML
    private ComboBox<GiornoDellaSettimana> giornoComboBox;

    @FXML
    private ComboBox<String> filmComboBox;

    @FXML
    private ListView<String> filmList;

    @FXML
    private TextField postiTextField;

    @FXML
    private TextField quantitaPostiField;


    Database data=Database.getInstance();
    ObservableList<GiornoDellaSettimana> giorni;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        giorni=FXCollections.observableArrayList(GiornoDellaSettimana.Lunedì,GiornoDellaSettimana.Martedì,
                GiornoDellaSettimana.Mercoledì,GiornoDellaSettimana.Giovedì,GiornoDellaSettimana.Venerdì,
                GiornoDellaSettimana.Sabato,GiornoDellaSettimana.Domenica);
        giornoComboBox.setItems(giorni);
        filmComboBox.setItems(data.getTitoliSpettacoli());
    }


    @FXML
    void acquistaBiglietto() {
        String[] parametri=filmList.getSelectionModel().getSelectedItem().split(" ; ");
        for(Spettacolo s: data.getSpettacoli())
        {
            if(s.getTitoloFilm().equalsIgnoreCase(parametri[0])&&
                    s.getNumeroSala()==Integer.parseInt(parametri[1]) &&
                    s.getGiornoDellaSettimana().equals(GiornoDellaSettimana.getGiornoDaString(parametri[2])) &&
                    s.getOrario().equals(LocalTime.parse(parametri[3]))) {
                int bigliettiDaAcquistare = Integer.parseInt(quantitaPostiField.getText());
                if (data.acquistaBiglietti(bigliettiDaAcquistare, s) > 0) {
                    postiTextField.clear();
                    quantitaPostiField.clear();
                } else {
                    quantitaPostiField.setText("Posti insufficienti!");
                    postiTextField.clear();
                }
                break;
            }

        }
        filmComboBox.setValue(null);
        giornoComboBox.setValue(null);
        filmList.setItems(null);
    }



    @FXML
    void back(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/cliente/HomeCliente.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cercaBiglietto() {
        postiTextField.clear();
        quantitaPostiField.clear();
        String titolo=filmComboBox.getSelectionModel().getSelectedItem();
        GiornoDellaSettimana giorno=giornoComboBox.getSelectionModel().getSelectedItem();
        ObservableList<String> spettacoliMostrati=FXCollections.observableArrayList();
        for(Spettacolo s:data.getSpettacoli())
        {
            if(s.getFilm().getTitolo().equalsIgnoreCase(titolo) &&
                    s.getGiornoDellaSettimana().equals(giorno))
            {
                spettacoliMostrati.add(s.toString());
            }
        }
        filmList.setItems(spettacoliMostrati);
    }


    @FXML
    void creaAbbonamento() {
        Random r=new Random();
        Abbonamento a=new Abbonamento(r.nextInt(1000),abbonamentoDatePicker.getValue());
        data.addAbbonamento(a);
        this.abbonamentoAttivoLabel.setText("Hai 1 abbonamento attivo! Data di scadenza: "+
                a.getDataAttivazione().plusDays(90));


    }

    @FXML
    void rowClicked() {
        String[] parametri=filmList.getSelectionModel().getSelectedItem().split(" ; ");
        for(Spettacolo s: data.getSpettacoli())
        {
            if(s.getTitoloFilm().equalsIgnoreCase(parametri[0])&&
            s.getNumeroSala()==Integer.parseInt(parametri[1]) &&
                    s.getGiornoDellaSettimana().equals(GiornoDellaSettimana.getGiornoDaString(parametri[2])) &&
                    s.getOrario().equals(LocalTime.parse(parametri[3])))
            {
                postiTextField.setText(Integer.toString(s.getSala().getPostiRimanenti()));
                break;
            }
        }

    }

}
