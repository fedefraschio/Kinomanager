package com.example.kinomanager;

import java.time.LocalDate;
import java.time.LocalTime;

public class Spettacolo {
    private GiornoDellaSettimana giornoDellaSettimana;
    private Film film;
    private Sala sala;
    private LocalTime orario;
    private LocalDate data;

    public Spettacolo(GiornoDellaSettimana giornoDellaSettimana, Film film, Sala sala, LocalDate data, LocalTime orario) {
        this.giornoDellaSettimana = giornoDellaSettimana;
        this.film = film;
        this.sala = sala;
        this.data=data;
        this.orario = orario;
    }

    public GiornoDellaSettimana getGiornoDellaSettimana() {
        return giornoDellaSettimana;
    }

    public void setGiornoDellaSettimana(GiornoDellaSettimana giornoDellaSettimana) {
        this.giornoDellaSettimana = giornoDellaSettimana;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public LocalTime getOrario() {
        return orario;
    }

    public void setOrario(LocalTime orario) {
        this.orario = orario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
