package controller.cliente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

public class MostraProgrammazioneController implements Initializable {

    @FXML
    private TableColumn<Spettacolo, GiornoDellaSettimana> giornoDellaSettimana;

    @FXML
    private TableColumn<Spettacolo, LocalTime> ora;

    @FXML
    private TableView<Spettacolo> programmazione;

    @FXML
    private TableColumn<Spettacolo, Integer> sala;

    @FXML
    private TableColumn<Spettacolo, String> titolo;

    Comparator<Spettacolo> spettacoloComparator;

    ObservableList<Spettacolo> list;


    @FXML
    void back(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/cliente/HomeCliente.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spettacoloComparator= Comparator.comparing(Spettacolo::getGiornoDellaSettimana).
                thenComparing(Spettacolo::getOrario).thenComparing(Spettacolo::getNumeroSala);
        titolo.setCellValueFactory(new PropertyValueFactory<>("titoloFilm"));
        sala.setCellValueFactory(new PropertyValueFactory<>("numeroSala"));
        giornoDellaSettimana.setCellValueFactory(new PropertyValueFactory<>("giornoDellaSettimana"));
        ora.setCellValueFactory(new PropertyValueFactory<>("orario"));
        Spettacolo s1=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
                new Film("Fast X","Azione"), new Sala(5,200),
                LocalTime.of(21, 0));
        Spettacolo s2=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
                new Film("Love Again","Romantico"), new Sala(4,100),
                LocalTime.of(15,30));
        Spettacolo s3=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 21).getDayOfWeek()),
                new Film("Borromini e Bernini","Storico"), new Sala(1,50),
                LocalTime.of(21, 0));
        list= FXCollections.observableArrayList(s1,s2,s3);
        programmazione.setItems(list);
        list.sort(spettacoloComparator);
    }
}
