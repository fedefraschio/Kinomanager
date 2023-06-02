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

//    public void addSpettacolo(String titolo, String genere, int numSala, int anno, int mese, int giorno, int ora, int minuti)
//    {
//        ProcessHandle LocalDateTime;
//        this.spettacoli.add(new Spettacolo(new Film(titolo,genere),
//                new Sala(numSala),
//                LocalDateTime.of(anno,mese,giorno,ora,minuti)));
//    }

    public Spettacolo getSpettacolo(int i){
        if( i >= this.spettacoli.size()){
            return null;
        }
        return spettacoli.get(i);
    }
}
