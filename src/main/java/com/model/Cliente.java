package com.model;

import java.time.LocalDate;

public class Cliente extends Utente{


    public Cliente(String username, String email, String nome, String cognome, LocalDate data, String password) {
        super(username, email, nome, cognome, data, password);
    }


}
