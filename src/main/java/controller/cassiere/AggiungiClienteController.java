package controller.cassiere;

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
import model.Cassiere;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class AggiungiClienteController implements Initializable {

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

    ObservableList<Cassiere> list;

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
    void submit() {
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

        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        Cassiere c1=new Cassiere("Mark123","marcoverdi@gmail.com","Marco","Verdi",
                LocalDate.of(1980, Month.AUGUST, 1),"password1234");
        Cassiere c2=new Cassiere("ClaraX","Clara_Bianchi@gmail.com","Clara","Bianchi",
                LocalDate.of(1995,Month.DECEMBER,14),"Psw98");
        list= FXCollections.observableArrayList(c1,c2);
        table.setItems(list);
    }
}
