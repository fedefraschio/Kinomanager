package com.example.kinomanager;

import java.time.LocalDate;
import java.util.Date;

public class Utente{
    private String username;
    private String email;
    private String nome;
    private String cognome;
    private LocalDate data;
    private String password;

    public Utente(String username, String email, String nome, String cognome, LocalDate data, String password) {
        this.username = username;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.data = data;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
