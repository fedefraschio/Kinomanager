package model;

import java.time.LocalDate;

public class Gestore extends Utente{


    public Gestore(String username, String email, String nome, String cognome, LocalDate data, String password) {
        super(username, email, nome, cognome, data, password);
    }


}
