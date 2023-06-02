package model;

import java.time.LocalDate;

public class Sconto { //classe non presente nel dominio

    private int percentuale;
    private String eta;
    private LocalDate inizio;
    private LocalDate fine;

    public Sconto(int percentuale, String eta, LocalDate inizio, LocalDate fine) {
        this.percentuale = percentuale;
        this.eta = eta;
        this.inizio = inizio;
        this.fine = fine;
    }

    public int getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(int percentuale) {
        this.percentuale = percentuale;
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
