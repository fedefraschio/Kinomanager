package controller.cliente;

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
import model.GiornoDellaSettimana;
import model.Spettacolo;
import persistence.Database;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
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

    Database data= Database.getInstance();


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
        titolo.setCellValueFactory(new PropertyValueFactory<>("titoloFilm"));
        sala.setCellValueFactory(new PropertyValueFactory<>("numeroSala"));
        giornoDellaSettimana.setCellValueFactory(new PropertyValueFactory<>("giornoDellaSettimana"));
        ora.setCellValueFactory(new PropertyValueFactory<>("orario"));
        data.sortSpettacoli();
        programmazione.setItems(data.getSpettacoli());
    }
}
