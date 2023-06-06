package persistence;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final Database instance=new Database();

    //attributi accessibili ai vari controller
    private String usernameUtenteAttuale;
    private ObservableList<Cassiere> cassieri;
    private ObservableList<Cliente> clienti;
    private ObservableList<Spettacolo> spettacoli;
    private List<Abbonamento> abbonamenti;
    //
    private Database()
    {
        this.cassieri= FXCollections.observableArrayList();
        this.clienti=FXCollections.observableArrayList();
        this.spettacoli=FXCollections.observableArrayList();
        this.abbonamenti=new ArrayList<>();
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



}
