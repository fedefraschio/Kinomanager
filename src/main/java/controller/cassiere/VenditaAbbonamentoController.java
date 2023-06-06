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
import model.Abbonamento;
import model.Cliente;
import persistence.Database;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import java.util.ResourceBundle;

public class VenditaAbbonamentoController{

    @FXML
    private DatePicker abbonamentoDatePicker;

    @FXML
    private Label resultLabel;

    @FXML
    private TextField usernameText;

    Database datas= Database.getInstance();

    @FXML
    void attiva() {
        int found=0;
        String username=usernameText.getText();
        LocalDate data=abbonamentoDatePicker.getValue();
        for(Cliente c:datas.getClienti())
        {
            if (c.getUsername().equalsIgnoreCase(username))
            {
                resultLabel.setText("Abbonamento attivato per "+username+" - Scadenza: "+data.plusDays(90));
                found++;
                Random r=new Random();
                datas.addAbbonamento(new Abbonamento(r.nextInt(1000),data));
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

}
