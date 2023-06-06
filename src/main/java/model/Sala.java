package model;

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

    public Sala(int numeroSala, List<Posto> listaPosti)
    {
        this.numeroSala=numeroSala;
        this.listaPosti=new ArrayList<>(listaPosti);
        this.numeroPosti=this.listaPosti.size();
    }

    public Sala(int numeroSala)
    {
        this(numeroSala,100);
    }

    public Sala(int numeroSala, int numeroPosti) //specifico solo il numero della sala, il resto è standard
    {
        this.numeroPosti = numeroPosti;
        this.numeroSala = numeroSala;
        this.listaPosti=new ArrayList<Posto>();
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
    }


    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
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
        int postiLiberi=0;
        for(Posto p:listaPosti)
        {
            if(p.isFree())
                postiLiberi++;
        }
        return postiLiberi;
    }


    public int occupaPosti(int numeroPosti) //occupa i primi -numeroPosti- posti liberi
    {
        int result=0;
        if(this.getPostiRimanenti()-numeroPosti<0)
        {
            result=-1;
        }
        else //aggiorno i posti e il numero di posti
        {
            //ho abbastanza posti, ciclo finchè non raggiungo quel numero
            for(Posto p:this.listaPosti)
            {
                if(result==numeroPosti)
                    break;
                if(p.isFree())
                {
                    p.setFree(false);
                    result++;
                    this.numeroPosti--;
                }

            }
        }
        return result;
    }
}
