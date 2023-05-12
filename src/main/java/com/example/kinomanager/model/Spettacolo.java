package com.example.kinomanager.model;

import java.time.LocalTime;

public class Spettacolo {
    private GiornoDellaSettimana giornoDellaSettimana;
    private Film film;
    private Sala sala;
    private LocalTime orario;

    public Spettacolo(GiornoDellaSettimana giornoDellaSettimana, Film film, Sala sala, LocalTime orario) {
        this.giornoDellaSettimana = giornoDellaSettimana;
        this.film = film;
        this.sala = sala;
        this.orario = orario;
    }
}
