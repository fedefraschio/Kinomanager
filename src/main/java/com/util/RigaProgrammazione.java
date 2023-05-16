package com.util;

import com.model.GiornoDellaSettimana;
import com.model.Spettacolo;

import java.time.LocalDate;
import java.time.LocalTime;

/*
classe di supporto per creare le righe con cui popolare la
table della programmazione
 */
public class RigaProgrammazione {

	private String titolo;
	private int sala;
	private LocalDate data;
	private LocalTime ora;
	private GiornoDellaSettimana giornoDellaSettimana;
	
	public RigaProgrammazione(String titolo, int sala, LocalDate data, LocalTime ora) {
		super();
		this.titolo = titolo;
		this.sala = sala;
		this.data = data;
		this.ora = ora;
		this.giornoDellaSettimana=GiornoDellaSettimana.getGiornoDaDay(data.getDayOfWeek());
	}

	public RigaProgrammazione(String titolo, int sala, GiornoDellaSettimana giornoDellaSettimana, LocalDate data, LocalTime ora) {
		super();
		this.titolo = titolo;
		this.sala = sala;
		this.data = data;
		this.ora = ora;
		this.giornoDellaSettimana=giornoDellaSettimana;
	}

	public RigaProgrammazione(Spettacolo s) //costruttore che crea la riga a partire dallo spettacolo
	{
		this.titolo=s.getFilm().getTitolo();
		this.sala=s.getSala().getNumeroSala();
		this.data=s.getData();
		this.ora=s.getOrario();
		this.giornoDellaSettimana=GiornoDellaSettimana.getGiornoDaDay(s.getData().getDayOfWeek());
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public int getSala() {
		return sala;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public LocalTime getOra() {
		return ora;
	}
	
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public void setSala(int sala) {
		this.sala = sala;
	}
	
	public void setData(LocalDate data) {

		this.data = data;
		//aggiorno anche il giorno della settimana
		this.giornoDellaSettimana=GiornoDellaSettimana.getGiornoDaDay(this.getData().getDayOfWeek());
	}
	
	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public GiornoDellaSettimana getGiornoDellaSettimana() {
		return giornoDellaSettimana;
	}

	public void setGiornoDellaSettimana(GiornoDellaSettimana giornoDellaSettimana) {
		this.giornoDellaSettimana = giornoDellaSettimana;
	}


}
