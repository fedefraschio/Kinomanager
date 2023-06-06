package controller.cassiere;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.*;
import persistence.Database;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ResourceBundle;

public class VenditaBigliettoController implements Initializable {

    @FXML
    private ComboBox<String> filmComboBox;

    @FXML
    private ComboBox<GiornoDellaSettimana> giornoComboBox;

    @FXML
    private TextArea postiDisponibiliTextArea;

    @FXML
    private TextField postiSceltiTexBox;

    @FXML
    private ListView<String> filmTrovatiListView;

    @FXML
    private TextField usernameTextBox;

    Database data= Database.getInstance();

    @FXML
    void back(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/cassiere/HomeCassiere.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cerca() {
        postiDisponibiliTextArea.clear();
        postiSceltiTexBox.clear();
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
        filmTrovatiListView.setItems(spettacoliMostrati);
    }

    @FXML
    void vendi() {
        String[] parametri=filmTrovatiListView.getSelectionModel().getSelectedItem().split(" ; ");
        for(Spettacolo s: data.getSpettacoli())
        {
            if(s.getTitoloFilm().equalsIgnoreCase(parametri[0])&&
                    s.getNumeroSala()==Integer.parseInt(parametri[1]) &&
                    s.getGiornoDellaSettimana().equals(GiornoDellaSettimana.getGiornoDaString(parametri[2])) &&
                    s.getOrario().equals(LocalTime.parse(parametri[3]))) {
                int bigliettiDaAcquistare = Integer.parseInt(postiSceltiTexBox.getText());
                String username=usernameTextBox.getText();
                //controllo che il cliente esista prima di vendere
                boolean clienteFound=false;
                for(Cliente c:data.getClienti())
                {
                    if(c.getUsername().equalsIgnoreCase(username))
                    {
                        clienteFound=true;
                        break;
                    }
                }
                if(!clienteFound)
                {

                    postiDisponibiliTextArea.setText("Cliente non trovato!");
                }
                else
                {
                    //provo a vendere
                    if(data.acquistaBiglietti(bigliettiDaAcquistare,s)>0)
                    {
                        postiSceltiTexBox.clear();
                        postiDisponibiliTextArea.clear();
                    }
                    else
                    {
                        postiDisponibiliTextArea.setText("Posti insufficienti!");
                    }
                }
                break;
            }
        }
        filmComboBox.setValue(null);
        giornoComboBox.setValue(null);
        filmTrovatiListView.setItems(null);
        usernameTextBox.clear();
        postiSceltiTexBox.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<GiornoDellaSettimana> giorni=FXCollections.observableArrayList(GiornoDellaSettimana.Lunedì,GiornoDellaSettimana.Martedì,
        GiornoDellaSettimana.Mercoledì,GiornoDellaSettimana.Giovedì,GiornoDellaSettimana.Venerdì,
                GiornoDellaSettimana.Sabato,GiornoDellaSettimana.Domenica);
        filmComboBox.setItems(data.getTitoliSpettacoli());
        giornoComboBox.setItems(giorni);
    }

    @FXML
    void rowClicked() {
        String[] parametri=filmTrovatiListView.getSelectionModel().getSelectedItem().split(" ; ");
        for(Spettacolo s: data.getSpettacoli())
        {
            if(s.getTitoloFilm().equalsIgnoreCase(parametri[0])&&
                    s.getNumeroSala()==Integer.parseInt(parametri[1]) &&
                    s.getGiornoDellaSettimana().equals(GiornoDellaSettimana.getGiornoDaString(parametri[2])) &&
                    s.getOrario().equals(LocalTime.parse(parametri[3])))
            {
                postiDisponibiliTextArea.setText(Integer.toString(s.getSala().getPostiRimanenti()));
                break;
            }
        }

    }
}
