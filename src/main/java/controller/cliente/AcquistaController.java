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
import model.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
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


    ObservableList<Spettacolo> listSpettacoli;
    ObservableList<GiornoDellaSettimana> giorni;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Film f1=new Film("Fast X","Azione");
        Film f2=new Film("Love Again","Romantico");
        Film f3=new Film("Borromini e Bernini","Storico");


        Spettacolo s1=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
                new Film("Fast X","Azione"), new Sala(5,200),
                 LocalTime.of(21, 0));
        Spettacolo s2=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
                new Film("Love Again","Romantico"), new Sala(4,50),
                 LocalTime.of(15,30));
        Spettacolo s3=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 21).getDayOfWeek()),
                new Film("Borromini e Bernini","Storico"), new Sala(1,25),
                 LocalTime.of(21, 0));

        listSpettacoli=FXCollections.observableArrayList(s1,s2,s3);
        giorni=FXCollections.observableArrayList(GiornoDellaSettimana.Lunedì,GiornoDellaSettimana.Martedì,
                GiornoDellaSettimana.Mercoledì,GiornoDellaSettimana.Giovedì,GiornoDellaSettimana.Venerdì,
                GiornoDellaSettimana.Sabato,GiornoDellaSettimana.Domenica);
        giornoComboBox.setItems(giorni);
        filmComboBox.setItems(FXCollections.observableArrayList(f1.getTitolo(),f2.getTitolo(),f3.getTitolo()));


    }


    @FXML
    void acquistaBiglietto() {
        String[] parametri=filmList.getSelectionModel().getSelectedItem().split(" ; ");
        ObservableList<Spettacolo> newListSpettacoli=FXCollections.observableArrayList();
        for(Spettacolo s:listSpettacoli)
        {
            if(s.getTitoloFilm().equalsIgnoreCase(parametri[0])&&
                    s.getNumeroSala()==Integer.parseInt(parametri[1]) &&
                    s.getGiornoDellaSettimana().equals(GiornoDellaSettimana.getGiornoDaString(parametri[2])) &&
                    s.getOrario().equals(LocalTime.parse(parametri[3]))) {
                int bigliettiDaAcquistare = Integer.parseInt(quantitaPostiField.getText());
                s.acquistaBiglietti(bigliettiDaAcquistare);
                postiTextField.clear();
                quantitaPostiField.clear();
            }

                newListSpettacoli.add(s);

        }
        filmComboBox.setValue(null);
        giornoComboBox.setValue(null);
        filmList.setItems(null);
        listSpettacoli.clear();
        listSpettacoli.addAll(newListSpettacoli);

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
        for(Spettacolo s:listSpettacoli)
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
        Abbonamento abbonamento=new Abbonamento(92346,abbonamentoDatePicker.getValue());
        this.abbonamentoAttivoLabel.setText("Hai 1 abbonamento attivo! Data di scadenza: "+
                abbonamento.getDataAttivazione().plusDays(90));


    }

    @FXML
    void rowClicked() {
        String[] parametri=filmList.getSelectionModel().getSelectedItem().split(" ; ");
        for(Spettacolo s:listSpettacoli)
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
