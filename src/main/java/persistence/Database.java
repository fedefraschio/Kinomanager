package persistence;

import javafx.collections.ObservableList;
import model.Cassiere;

public class Database {

    private static final Database instance=new Database();

    //attributi accessibili ai vari controller
    private String usernameUtenteAttuale;
    private ObservableList<Cassiere> cassieri;
    //
    private Database(){}

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

    public ObservableList<Cassiere> getCassieri() {
        return cassieri;
    }

    public void addCassiere(Cassiere cassiere)
    {
        this.cassieri.add(cassiere);
    }

}
