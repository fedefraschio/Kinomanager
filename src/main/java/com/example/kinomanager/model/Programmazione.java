package com.example.kinomanager.model;

import java.util.ArrayList;

public class Programmazione {

    private ArrayList<Spettacolo> programmazione;

    public Programmazione(ArrayList<Spettacolo> programmazione) {
        this.programmazione = programmazione;
    }

    public void addSpettacolo(Spettacolo spettacolo){
        this.programmazione.add(spettacolo);
    }

    public Spettacolo getSpettacolo(int i){
        if( i >= this.programmazione.size()){
            return null;
        }
        return programmazione.get(i);
    }
}
