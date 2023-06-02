package com.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Spettacolo {
    private GiornoDellaSettimana giornoDellaSettimana;
    private Film film;
    private Sala sala;
    private LocalTime orario;
    private LocalDate data;
    private String titoloFilm; //attributo extra per riempire le table
    private int numeroSala;//attributo extra per riempire le table

    public Spettacolo(GiornoDellaSettimana giornoDellaSettimana, Film film, Sala sala, LocalDate data, LocalTime orario) {
        this.giornoDellaSettimana = giornoDellaSettimana;
        this.film = film;
        this.sala = sala;
        this.data=data;
        this.orario = orario;
        this.titoloFilm=this.film.getTitolo();
        this.numeroSala=this.sala.getNumeroSala();
    }
    public Spettacolo() //costruttore util
    {
        this(GiornoDellaSettimana.Lunedì,new Film("Ciao"),new Sala(1),LocalDate.now(),LocalTime.now());
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

    public String getTitoloFilm() {
        return titoloFilm;
    }

    public void setTitoloFilm(String titoloFilm) {
        this.titoloFilm = titoloFilm;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String toString()
    {
        return this.titoloFilm + " ; " +this.numeroSala+ " ; " +this.giornoDellaSettimana+ " ; " +
                this.data+ " ; " +this.orario;
    }
}
