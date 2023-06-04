package controller.cassiere;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
import java.util.ResourceBundle;

public class VenditaBigliettoController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Button cercaButton;

    @FXML
    private ComboBox<String> filmComboBox;

    @FXML
    private DatePicker dataDatePicker;

    @FXML
    private TextArea postiDisponibiliTextArea;

    @FXML
    private TextField postiSceltiTexBox;

    @FXML
    private ListView<String> filmTrovatiListView;

    @FXML
    private TextField usernameTextBox;

    @FXML
    private Button vendiButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    Film f1=new Film("Fast X","Azione");
    Film f2=new Film("Love Again","Romantico");
    Film f3=new Film("Borromini e Bernini","Storico");


    Spettacolo s1=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
            new Film("Fast X","Azione"), new Sala(5,200),
            LocalDate.of(2023, Month.JUNE, 23), LocalTime.of(21,00));
    Spettacolo s2=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
            new Film("Love Again","Romantico"), new Sala(4,50),
            LocalDate.of(2023, Month.JUNE, 23), LocalTime.of(15,30));
    Spettacolo s3=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 21).getDayOfWeek()),
            new Film("Borromini e Bernini","Storico"), new Sala(1,25),
            LocalDate.of(2023, Month.JUNE, 21), LocalTime.of(21,00));

    ObservableList<Spettacolo> listSpettacoli;

    @FXML
    void back(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/cassiere/HomeCassiere.fxml"));
        root=loader.load();

        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cerca(MouseEvent event) {
        postiDisponibiliTextArea.clear();
        postiSceltiTexBox.clear();
        String titolo=filmComboBox.getSelectionModel().getSelectedItem();
        LocalDate data=dataDatePicker.getValue();
        ObservableList<String> spettacoliMostrati=FXCollections.observableArrayList();
        for(Spettacolo s:listSpettacoli)
        {
            if(s.getFilm().getTitolo().equalsIgnoreCase(titolo) &&
                    s.getData().isEqual(data))
            {
                spettacoliMostrati.add(s.toString());
            }
        }
        filmTrovatiListView.setItems(spettacoliMostrati);
    }

    @FXML
    void vendi(MouseEvent event) {
        String[] parametri=filmTrovatiListView.getSelectionModel().getSelectedItem().split(" ; ");
        ObservableList<Spettacolo> newListSpettacoli=FXCollections.observableArrayList();
        for(Spettacolo s:listSpettacoli)
        {
            if(s.getTitoloFilm().equalsIgnoreCase(parametri[0])&&
                    s.getNumeroSala()==Integer.parseInt(parametri[1]) &&
                    s.getData().isEqual(LocalDate.parse(parametri[3])) &&
                    s.getOrario().equals(LocalTime.parse(parametri[4]))) {
                int bigliettiDaAcquistare = Integer.parseInt(postiSceltiTexBox.getText());
                s.acquistaBiglietti(bigliettiDaAcquistare);
                postiSceltiTexBox.clear();
                postiDisponibiliTextArea.clear();
            }

            newListSpettacoli.add(s);

        }
        filmComboBox.setValue(null);
        dataDatePicker.setValue(null);
        filmTrovatiListView.setItems(null);
        listSpettacoli.clear();
        listSpettacoli.addAll(newListSpettacoli);
        usernameTextBox.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listSpettacoli= FXCollections.observableArrayList(s1,s2,s3);
        //viene riempita la combobox di film
        filmComboBox.setItems(FXCollections.observableArrayList(f1.getTitolo(),f2.getTitolo(),f3.getTitolo()));
    }

    @FXML
    void rowClicked(MouseEvent event) {
        String[] parametri=filmTrovatiListView.getSelectionModel().getSelectedItem().split(" ; ");
        for(Spettacolo s:listSpettacoli)
        {
            if(s.getTitoloFilm().equalsIgnoreCase(parametri[0])&&
                    s.getNumeroSala()==Integer.parseInt(parametri[1]) &&
                    s.getData().isEqual(LocalDate.parse(parametri[3])) &&
                    s.getOrario().equals(LocalTime.parse(parametri[4])))
            {
                postiDisponibiliTextArea.setText(Integer.toString(s.getSala().getPostiRimanenti()));
                break;
            }
        }

    }
}
