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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Film;
import model.Recensione;

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

    ObservableList<Recensione> list;

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
        for(Recensione r: list)
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
        list.add(r);
        filmVistiComboBox.setValue(null);
        valutazioneTextBox.clear();
        commentoTextArea.clear();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filmComboBox.setItems(FXCollections.observableArrayList("Fast X",
                "Bernini e Borromini","Me contro Te: il film"));
        filmVistiComboBox.setItems(FXCollections.observableArrayList("Fast X",
                "Bernini e Borromini","Me contro Te: il film"));
        Recensione r1=new Recensione("Super topperia missile",5,new Film("Me contro Te: Il Film"));
        Recensione r2=new Recensione("Anvedi che monnezza",1,new Film("Fast X"));
        list= FXCollections.observableArrayList(r1,r2);
    }
}
