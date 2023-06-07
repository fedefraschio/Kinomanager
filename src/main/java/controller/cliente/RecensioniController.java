package controller.cliente;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Film;
import model.Recensione;
import persistence.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RecensioniController implements Initializable {

    @FXML
    private TextArea commentoTextArea;

    @FXML
    private ComboBox<String> filmComboBox;

    @FXML
    private ComboBox<String> filmVistiComboBox;

    @FXML
    private TextArea recensioniTextArea;

    @FXML
    private TextField valutazioneTextBox;

    Database data=Database.getInstance();

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
    void cercaRecensioni() {
        recensioniTextArea.clear();
        for(Recensione r: data.getRecensioni())
        {
            if(r.getFilm().getTitolo().equalsIgnoreCase(filmComboBox.getSelectionModel().getSelectedItem()))
            {
                recensioniTextArea.appendText(r.getValutazione()+" - "+r.getCommento());
                recensioniTextArea.appendText("\n");
            }
        }
    }

    @FXML
    void pubblica() {
        int valutazione=Integer.parseInt(valutazioneTextBox.getText());
        Film film=new Film(filmVistiComboBox.getSelectionModel().getSelectedItem());
        String commento=commentoTextArea.getText();
        Recensione r=new Recensione(commento,valutazione,film);
        data.addRecensione(r);
        filmVistiComboBox.setValue(null);
        valutazioneTextBox.clear();
        commentoTextArea.clear();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filmComboBox.setItems(data.getTitoliSpettacoli());
        filmVistiComboBox.setItems(data.getTitoliSpettacoli());

    }
}
