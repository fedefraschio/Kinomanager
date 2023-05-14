package viewgestore;

import java.time.LocalDate;
import java.time.LocalTime;

public class Riga {

	private String titolo;
	private int sala;
	private LocalDate data;
	private LocalTime ora;
	
	public Riga(String titolo, int sala, LocalDate data, LocalTime ora) {
		super();
		this.titolo = titolo;
		this.sala = sala;
		this.data = data;
		this.ora = ora;
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
	}
	
	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	
	
	
}
