package controller.gestore;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Cassiere;
import persistence.Database;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RimuoviCassiereController implements Initializable {

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
    private TableColumn<Cassiere, String> username;

    Database datas=Database.getInstance();

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
    void remove() {
        int selectedID=table.getSelectionModel().getSelectedIndex();
        datas.removeCassiere(selectedID);
        table.refresh();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        nome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cognome.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        table.setItems(datas.getCassieri());
    }
}
