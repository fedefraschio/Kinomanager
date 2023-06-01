package com.controller.cliente;

import com.model.Abbonamento;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class AcquistaController {

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
    private ComboBox<?> filmComboBox;

    @FXML
    private ListView<?> filmList;

    @FXML
    private TextField postiTextField;

    @FXML
    private TextField quantitaPostiField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void acquistaBiglietto(MouseEvent event) {

    }

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

    }

    @FXML
    void creaAbbonamento(MouseEvent event) {
        Abbonamento abbonamento=new Abbonamento(92346,abbonamentoDatePicker.getValue());
        this.abbonamentoAttivoLabel.setText("Hai 1 abbonamento attivo! Data di scadenza: "+
                abbonamento.getDataAttivazione().plusDays(90).toString());
    }

}
