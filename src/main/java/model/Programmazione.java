package model;

import java.util.ArrayList;
import java.util.List;

public class Programmazione {

    private String nomeProgrammazione;
    private List<Spettacolo> spettacoli;

    public Programmazione(String nomeProgrammazione, List<Spettacolo> spettacoli) {
        super();
        this.nomeProgrammazione = nomeProgrammazione;
        this.spettacoli = new ArrayList<>(spettacoli);
    }

    private String getNomeProgrammazione() {
        return nomeProgrammazione;
    }

    private List<Spettacolo> getSpettacoli() {
        return spettacoli;
    }

    private void setNomeProgrammazione(String nomeProgrammazione) {
        this.nomeProgrammazione = nomeProgrammazione;
    }

    private void setSpettacoli(List<Spettacolo> spettacoli) {
        this.spettacoli = spettacoli;
    }

    public void addSpettacolo(Spettacolo spettacolo){
        this.spettacoli.add(spettacolo);
    }

    public Spettacolo getSpettacolo(int i){
        if( i >= this.spettacoli.size()){
            return null;
        }
        return spettacoli.get(i);
    }
}
