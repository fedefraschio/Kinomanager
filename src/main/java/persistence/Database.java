package persistence;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Database {

    private static final Database instance=new Database();

    //attributi accessibili ai vari controller
    private String usernameUtenteAttuale;
    private final ObservableList<Cassiere> cassieri;
    private final ObservableList<Cliente> clienti;
    private final List<Gestore> gestori;
    private final ObservableList<Spettacolo> spettacoli;
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final List<Abbonamento> abbonamenti;
    Comparator<Spettacolo> spettacoliComparator;
    private float prezzoBiglietto;
    private float prezzoAbbonamento;
    private final ObservableList<Sconto> sconti;
    //
    private Database()
    {
        this.cassieri= FXCollections.observableArrayList();
        this.clienti=FXCollections.observableArrayList();
        this.spettacoli=FXCollections.observableArrayList();
        this.abbonamenti=new ArrayList<>();
        this.gestori=new ArrayList<>();
        this.spettacoliComparator= Comparator.comparing(Spettacolo::getGiornoDellaSettimana).
                thenComparing(Spettacolo::getOrario).thenComparing(Spettacolo::getNumeroSala);
        this.sconti=FXCollections.observableArrayList();
    }

    public static Database getInstance()
    {
        return instance;
    }

    //metodi necessari ai vari controller
    public String getUsernameUtenteAttuale()
    {
        return usernameUtenteAttuale;
    }

    public void setUsernameUtenteAttuale(String usernameUtenteAttuale)
    {
        this.usernameUtenteAttuale=usernameUtenteAttuale;
    }

    public ObservableList<Cassiere> getCassieri()
    {
        return cassieri;
    }

    public void addCassiere(Cassiere cassiere)
    {
        this.cassieri.add(cassiere);
    }

    public ObservableList<Cliente> getClienti()
    {
        return clienti;
    }

    public void addCliente(Cliente cliente)
    {
        this.clienti.add(cliente);
    }

    public void removeCliente(int index)
    {
        this.clienti.remove(index);
    }

    public ObservableList<Spettacolo> getSpettacoli()
    {
        return spettacoli;
    }

    public void addSpettacolo(Spettacolo spettacolo)
    {
        this.spettacoli.add(spettacolo);
    }

    public ObservableList<String> getTitoliSpettacoli()
    {
        ObservableList<String> titoli=FXCollections.observableArrayList();
        for(Spettacolo s:spettacoli)
        {
            titoli.add(s.getTitoloFilm());
        }
        return titoli;
    }

    public int acquistaBiglietti(int numBiglietti, Spettacolo spettacolo) {
        int result=0;
        for (Spettacolo s : spettacoli) {
            if (s.equals(spettacolo)) {
                result = s.acquistaBiglietti(numBiglietti);
                break;
            }
        }
        return result;
    }

    public void addAbbonamento(Abbonamento abbonamento)
    {
        this.abbonamenti.add(abbonamento);
    }

    public List<Gestore> getGestori()
    {
        return gestori;
    }

    public void removeCassiere(int index) {
        this.cassieri.remove(index);
    }

    public void addGestore(Gestore gestore)
    {
        this.gestori.add(gestore);
    }

    public void removeSpettacolo(int index)
    {
        this.spettacoli.remove(index);
    }

    public void sortSpettacoli()
    {
        this.spettacoli.sort(spettacoliComparator);
    }

    public void setPrezzoBiglietto(float prezzoBiglietto) {
        this.prezzoBiglietto = prezzoBiglietto;
    }

    public void setPrezzoAbbonamento(float prezzoAbbonamento) {
        this.prezzoAbbonamento = prezzoAbbonamento;
    }

    public float getPrezzoBiglietto() {
        return prezzoBiglietto;
    }

    public float getPrezzoAbbonamento() {
        return prezzoAbbonamento;
    }

    public ObservableList<Sconto> getSconti()
    {
        return sconti;
    }

    public void addSconto(Sconto sconto)
    {
        this.sconti.add(sconto);
    }
}
