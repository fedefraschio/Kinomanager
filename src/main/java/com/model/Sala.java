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
        this.numeroPosti = 200;
        this.numeroSala = numeroSala;
        List<Posto> listaPosti=new ArrayList<Posto>();
        int numPosto=1;
        int fila=1;
        for(int i=0;i<numeroPosti;i++)
        {
            if(numPosto==20)
            {
                numPosto=1;
                fila++;
            }
            listaPosti.add(new Posto(numPosto,fila));
            numPosto++;
        }
        this.listaPosti = new ArrayList<>(listaPosti);
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

    public int getPostiRimanenti()
    {
        int result=0;
        for(Posto p:listaPosti)
        {
            if(p.isFree())
                result++;
        }
        return result;
    }

    public void acquistaBiglietti(int numBiglietti) //aggiorna il numero di posti disponibili
    {
        int count=0;
        for(Posto p:this.listaPosti)
        {
            if(count==numBiglietti)
                break;
            if(p.isFree())
            {
                p.setFree(false);
                count++;
            }
        }
    }
}
