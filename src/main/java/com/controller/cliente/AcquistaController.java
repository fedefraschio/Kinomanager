package com.controller.cliente;

import com.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    private Button abbonamentoButton;

    @FXML
    private DatePicker abbonamentoDatePicker;

    @FXML
    private Button acquistaBigliettoButton;

    @FXML
    private Button back;

    @FXML
    private DatePicker bigliettoDatePicker;

    @FXML
    private Button cercaBigliettoButton;

    @FXML
    private ComboBox<String> filmComboBox;

    @FXML
    private ListView<Spettacolo> filmList;

    @FXML
    private TextField postiTextField;

    @FXML
    private TextField quantitaPostiField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    Film f1=new Film("Fast X","Azione");
    Film f2=new Film("Love Again","Romantico");
    Film f3=new Film("Borromini e Bernini","Storico");


    Spettacolo s1=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
            new Film("Fast X","Azione"), new Sala(5),
            LocalDate.of(2023, Month.JUNE, 23), LocalTime.of(21,00));
    Spettacolo s2=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
            new Film("Love Again","Romantico"), new Sala(4),
            LocalDate.of(2023, Month.JUNE, 23), LocalTime.of(15,30));
    Spettacolo s3=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 21).getDayOfWeek()),
            new Film("Borromini e Bernini","Storico"), new Sala(1),
            LocalDate.of(2023, Month.JUNE, 21), LocalTime.of(21,00));

    ObservableList<Spettacolo> listSpettacoli=FXCollections.observableArrayList(s1,s2,s3);


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //viene riempita la combobox di film
        filmComboBox.setItems(FXCollections.observableArrayList(f1.getTitolo(),f2.getTitolo(),f3.getTitolo()));


    }

/*
    @FXML
    void acquistaBiglietto(MouseEvent event) {
        Spettacolo s=filmList.getSelectionModel().getSelectedItem();
        quantitaPostiField.setText();
    }

 */

    @FXML
    void back(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/com/controller/cliente/HomeCliente.fxml"));
        root=loader.load();

        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void cercaBiglietto(MouseEvent event) {
        String titolo=filmComboBox.getSelectionModel().getSelectedItem();
        LocalDate data=bigliettoDatePicker.getValue();
        ObservableList<Spettacolo> spettacoliMostrati=FXCollections.observableArrayList();
        for(Spettacolo s:listSpettacoli)
        {
            if(s.getFilm().getTitolo().equalsIgnoreCase(titolo) &&
            s.getData().isEqual(data))
            {
                spettacoliMostrati.add(s);
            }
        }
        filmList.setItems(spettacoliMostrati);
    }

    /*
    @FXML
    void creaAbbonamento(MouseEvent event) {
        Abbonamento abbonamento=new Abbonamento(92346,abbonamentoDatePicker.getValue());
        this.abbonamentoAttivoLabel.setText("Hai 1 abbonamento attivo! Data di scadenza: "+
                abbonamento.getDataAttivazione().plusDays(90).toString());
    }*/

}
