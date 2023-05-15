package com.example.kinomanager;

import java.time.LocalDate;

public class RigaSconto {

    private int sconto;
    private String eta;
    private LocalDate inizio;
    private LocalDate fine;

    public RigaSconto(int sconto, String eta, LocalDate inizio, LocalDate fine) {
        this.sconto = sconto;
        this.eta = eta;
        this.inizio = inizio;
        this.fine = fine;
    }

    public int getSconto() {
        return sconto;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public LocalDate getInizio() {
        return inizio;
    }

    public void setInizio(LocalDate inizio) {
        this.inizio = inizio;
    }

    public LocalDate getFine() {
        return fine;
    }

    public void setFine(LocalDate fine) {
        this.fine = fine;
    }


}
