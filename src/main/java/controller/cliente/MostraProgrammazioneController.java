package controller.cliente;

import model.Film;
import model.GiornoDellaSettimana;
import model.Sala;
import model.Spettacolo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Comparator;
import java.util.ResourceBundle;

public class MostraProgrammazioneController implements Initializable {

    @FXML
    private Button back;

    @FXML
    private TableColumn<Spettacolo, LocalDate> data;

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

    private Stage stage;
    private Scene scene;
    private Parent root;

    Comparator<Spettacolo> spettacoloComparator= Comparator.comparing(Spettacolo::getData).
            thenComparing(Spettacolo::getOrario).thenComparing(Spettacolo::getNumeroSala);

    Spettacolo s1=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
            new Film("Fast X","Azione"), new Sala(5,200),
            LocalDate.of(2023, Month.JUNE, 23), LocalTime.of(21,00));
    Spettacolo s2=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
            new Film("Love Again","Romantico"), new Sala(4,100),
            LocalDate.of(2023, Month.JUNE, 23), LocalTime.of(15,30));
    Spettacolo s3=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 21).getDayOfWeek()),
            new Film("Borromini e Bernini","Storico"), new Sala(1,50),
            LocalDate.of(2023, Month.JUNE, 21), LocalTime.of(21,00));

    ObservableList<Spettacolo> list= FXCollections.observableArrayList(s1,s2,s3);


    @FXML
    void back(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/cliente/HomeCliente.fxml"));
        root=loader.load();

        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titolo.setCellValueFactory(new PropertyValueFactory<Spettacolo, String>("titoloFilm"));
        sala.setCellValueFactory(new PropertyValueFactory<Spettacolo, Integer>("numeroSala"));
        giornoDellaSettimana.setCellValueFactory(new PropertyValueFactory<Spettacolo,GiornoDellaSettimana>("giornoDellaSettimana"));
        data.setCellValueFactory(new PropertyValueFactory<Spettacolo, LocalDate>("data"));
        ora.setCellValueFactory(new PropertyValueFactory<Spettacolo, LocalTime>("orario"));
        programmazione.setItems(list);
        list.sort(spettacoloComparator);
    }
}
