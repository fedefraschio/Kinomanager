package com.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MostraProgrammazioneController {
    //private Programmazione programmazione = new Programmazione(new ArrayList<>());
    @FXML
    TableView<TableColumn> tabella;
    @FXML
    TableColumn lunedi;
    @FXML
    TableColumn martedi;
    @FXML
    TableColumn mercoledi;
    @FXML
    TableColumn giovedi;
    @FXML
    TableColumn venerdi;
    @FXML
    TableColumn sabato;
    @FXML
    TableColumn domenica;



//    public void mostraProgrammazione(MouseEvent mouseEvent) {
//        this.programmazione.addSpettacolo(new Spettacolo(GiornoDellaSettimana.Giovedì, new Film("Shrek", "avventura"),
//                new Sala(3, 100), LocalTime.of(20, 00)));
//        this.programmazione.addSpettacolo(new Spettacolo(GiornoDellaSettimana.Giovedì, new Film("Shrek", "avventura"),
//                new Sala(3, 100), LocalTime.of(20, 00)));
//        this.programmazione.addSpettacolo(new Spettacolo(GiornoDellaSettimana.Giovedì, new Film("Shrek", "avventura"),
//                new Sala(3, 100), LocalTime.of(20, 00)));
//    }
}
