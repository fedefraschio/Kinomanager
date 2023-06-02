package com.model;

public class Film {

    private String titolo;
    private String genere;
    
    public Film(String titolo, String genere) {
        super();
        this.titolo = titolo;
        this.genere = genere;

    }

    public Film(String titolo)
    {
        this(titolo,"-");
    }

    public String getTitolo() {
        return titolo;
    }

    private void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getGenere() {
        return genere;

    }

    private void setGenere(String genere) {
        this.genere = genere;
    }
}
