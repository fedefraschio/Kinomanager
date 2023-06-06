package controller.gestore;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.ResourceBundle;

import model.Sconto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import persistence.Database;

public class PubblicaScontiController implements Initializable{

    @FXML
    private DatePicker dataEnd;

    @FXML
    private DatePicker dataStart;

    @FXML
    private TableColumn<Sconto, String> eta;

    @FXML
    private ComboBox<String> etaBox;

    @FXML
    private TableColumn<Sconto, Date> fine;

    @FXML
    private TableColumn<Sconto, Date> inizio;

    @FXML
    private TableView<Sconto> scontiTab;

    @FXML
    private TableColumn<Sconto, Integer> sconto;

    @FXML
    private TextField scontoText;

    Database data=Database.getInstance();
    @FXML
    void back(MouseEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/gestore/HomeGestore.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    
    @FXML
    void submit()
    {
        Sconto sconto =new Sconto(Integer.parseInt(scontoText.getText()),
                etaBox.getValue(),
                dataStart.getValue(),
                dataEnd.getValue());
        data.addSconto(sconto);
        scontiTab.refresh();

    	scontoText.clear();
    	dataStart.setValue(null);
    	dataEnd.setValue(null);
    	etaBox.setValue(null);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		etaBox.setItems(FXCollections.observableArrayList("Sotto i 5 anni","6 - 10 anni",
                "11 - 13 anni","14 - 16 anni"));
		sconto.setCellValueFactory(new PropertyValueFactory<>("percentuale"));
        eta.setCellValueFactory(new PropertyValueFactory<>("eta"));
        inizio.setCellValueFactory(new PropertyValueFactory<>("inizio"));
        fine.setCellValueFactory(new PropertyValueFactory<>("fine"));

        scontiTab.setItems(data.getSconti());
	}
    
}



