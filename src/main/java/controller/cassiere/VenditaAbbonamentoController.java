package controller.cassiere;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Cliente;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class VenditaAbbonamentoController implements Initializable{

    @FXML
    private DatePicker abbonamentoDatePicker;

    @FXML
    private Label resultLabel;

    @FXML
    private TextField usernameText;

    ObservableList<Cliente> list;

    @FXML
    void attiva() {
        int found=0;
        String username=usernameText.getText();
        LocalDate data=abbonamentoDatePicker.getValue();
        for(Cliente c:list)
        {
            if (c.getUsername().equalsIgnoreCase(username))
            {
                resultLabel.setText("Abbonamento attivato per "+username+" - Scadenza: "+data.plusDays(90));
                found++;
                break;
            }
        }
        if(found==0)
        {
            resultLabel.setText("Cliente "+username+" non trovato!");
        }
        usernameText.clear();
        abbonamentoDatePicker.setValue(null);
    }

    @FXML
    void back(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/cassiere/HomeCassiere.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Cliente c1=new Cliente("Mark123","marcoverdi@gmail.com","Marco","Verdi",
                LocalDate.of(1980, Month.AUGUST, 1),"password1234");
        Cliente c2=new Cliente("ClaraX","Clara_Bianchi@gmail.com","Clara","Bianchi",
                LocalDate.of(1995,Month.DECEMBER,14),"Psw98");
        list= FXCollections.observableArrayList(c1,c2);
    }
}
