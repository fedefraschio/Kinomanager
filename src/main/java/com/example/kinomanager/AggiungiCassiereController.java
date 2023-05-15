import com.example.kinomanager.RigaProgrammazione;
import com.example.kinomanager.model.Cassiere;
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

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ResourceBundle;

public class AggiungiCassiereController implements Initializable {

    @FXML
    private Button buttonAggiungi;

    @FXML
    private Button buttonback;

    @FXML
    private TableColumn<Cassiere, String> cognome;

    @FXML
    private TableColumn<Cassiere, LocalDate> data;

    @FXML
    private TableColumn<Cassiere, String> email;

    @FXML
    private TableColumn<Cassiere, String> nome;

    @FXML
    private TableColumn<Cassiere, String> password;

    @FXML
    private TableView<Cassiere> table;

    @FXML
    private TextField textBoxCognome;

    @FXML
    private DatePicker textBoxDataDiNascita;

    @FXML
    private TextField textBoxEmail;

    @FXML
    private TextField textBoxNome;

    @FXML
    private TextField textBoxPassword;

    @FXML
    private TextField textBoxUsername;

    @FXML
    private TableColumn<Cassiere, String> username;
    private Stage stage;
    private Scene scene;
    private Parent root;

    Cassiere c1=new Cassiere("Mark123","marcoverdi@gmail.com","Marco","Verdi",
            LocalDate.of(1980, Month.AUGUST,01),"password1234");
    Cassiere c2=new Cassiere("ClaraX","Clara_Bianchi@gmail.com","Clara","Bianchi",
            LocalDate.of(1995,Month.DECEMBER,14),"Psw98");
    ObservableList<Cassiere> list= FXCollections.observableArrayList(
            c1,c2);

    @FXML
    void back(MouseEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("HomeGestore.fxml"));
        root=loader.load();

        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void submit(MouseEvent event) {
        Cassiere cassiere =new Cassiere(textBoxUsername.getText(),
                textBoxEmail.getText(),textBoxNome.getText(),
                textBoxCognome.getText(),
                textBoxDataDiNascita.getValue(),
                textBoxPassword.getText());

        ObservableList<Cassiere> righe=table.getItems();
        righe.add(cassiere);
        table.setItems(righe);

        textBoxUsername.clear();
        textBoxEmail.clear();
        textBoxDataDiNascita.setValue(null);
        textBoxNome.clear();
        textBoxCognome.clear();
        textBoxPassword.clear();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        username.setCellValueFactory(new PropertyValueFactory<Cassiere, String>("username"));
        email.setCellValueFactory(new PropertyValueFactory<Cassiere, String>("email"));
        data.setCellValueFactory(new PropertyValueFactory<Cassiere,LocalDate>("data"));
        nome.setCellValueFactory(new PropertyValueFactory<Cassiere, String>("nome"));
        cognome.setCellValueFactory(new PropertyValueFactory<Cassiere, String>("cognome"));
        password.setCellValueFactory(new PropertyValueFactory<Cassiere,String>("password"));
        table.setItems(list);
    }
}
