package com.example.kinomanager.model;

import java.time.LocalDate;
import java.util.Date;

public class Utente{
    private String username;
    private String email;
    private String nome;
    private String cognome;
    private LocalDate datadDiNascita;
    private String password;

    public Utente(String username, String email, String nome, String cognome, LocalDate datadDiNascita, String password) {
        this.username = username;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.datadDiNascita = datadDiNascita;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDatadDiNascita() {
        return datadDiNascita;
    }

    public void setDatadDiNascita(LocalDate datadDiNascita) {
        this.datadDiNascita = datadDiNascita;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
