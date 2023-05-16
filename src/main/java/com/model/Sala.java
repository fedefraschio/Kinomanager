package com.model;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private int numeroPosti;
    private int numeroSala;
    private List<Posto> listaPosti;

    public Sala(int numeroPosti, int numeroSala, List<Posto> listaPosti) {
        super();
        this.numeroPosti = numeroPosti;
        this.numeroSala = numeroSala;
        this.listaPosti = new ArrayList<>(listaPosti);
    }

    public Sala(int numeroSala) //specifico solo il numero della sala, il resto è standard
    {
        this(200,numeroSala,new ArrayList<Posto>());
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    private void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    private void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public List<Posto> getListaPosti() {
        return listaPosti;
    }

    private void setListaPosti(List<Posto> listaPosti) {
        this.listaPosti = new ArrayList<>(listaPosti);
    }
}
