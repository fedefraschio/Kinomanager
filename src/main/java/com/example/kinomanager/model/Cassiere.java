package com.example.kinomanager.model;

import java.time.LocalDate;

public class Cassiere extends Utente{


    public Cassiere(String username, String email, String nome, String cognome, LocalDate datadDiNascita, String password) {
        super(username, email, nome, cognome, datadDiNascita, password);
    }
}
