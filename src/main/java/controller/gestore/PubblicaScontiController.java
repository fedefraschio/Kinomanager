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

public class PubblicaScontiController implements Initializable{

    @FXML
    private Button backButton;

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
    private Button pubblica;

    @FXML
    private TableView<Sconto> scontiTab;

    @FXML
    private TableColumn<Sconto, Integer> sconto;

    @FXML
    private TextField scontoText;
    
    private Stage stage;
	private Scene scene; 
	private Parent root;

    Sconto s1=new Sconto(50,"Sotto i 5 anni",
            LocalDate.of(2023, Month.JUNE,01),LocalDate.of(2023,Month.JUNE,30));
    Sconto s2=new Sconto(10,"11 - 13 anni",
            LocalDate.of(2023,Month.JUNE,01),LocalDate.of(2023,Month.AUGUST,31));
    ObservableList<Sconto> list=FXCollections.observableArrayList(
            s1,s2);

    @FXML
    void back(MouseEvent event) throws IOException {
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/gestore/HomeGestore.fxml"));
		root=loader.load();
		
		stage=(Stage)((Node)event.getSource()).getScene().getWindow();
		scene=new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
    
    @FXML
    void submit(MouseEvent e)
    {
        Sconto rigaSconto =new Sconto(Integer.parseInt(scontoText.getText()),
                etaBox.getValue(),
                dataStart.getValue(),
                dataEnd.getValue());
        ObservableList<Sconto> righe=scontiTab.getItems();
        righe.add(rigaSconto);
        scontiTab.setItems(righe);

    	scontoText.clear();
    	dataStart.setValue(null);
    	dataEnd.setValue(null);
    	etaBox.setValue(null);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		etaBox.setItems(FXCollections.observableArrayList("Sotto i 5 anni","6 - 10 anni",
                "11 - 13 anni","14 - 16 anni"));
		sconto.setCellValueFactory(new PropertyValueFactory<Sconto,Integer>("percentuale"));
        eta.setCellValueFactory(new PropertyValueFactory<Sconto,String>("eta"));
        inizio.setCellValueFactory(new PropertyValueFactory<Sconto,Date>("inizio"));
        fine.setCellValueFactory(new PropertyValueFactory<Sconto,Date>("fine"));

        scontiTab.setItems(list);
	}
    
}



