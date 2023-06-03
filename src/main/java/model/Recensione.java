package model;

public class Recensione {
    private String commento;
    private int valutazione;

    private Film film;



    public Recensione(String commento, int valutazione,Film film) {
        this.commento = commento;
        this.valutazione = valutazione;
        this.film=film;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public int getValutazione() {
        return valutazione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
