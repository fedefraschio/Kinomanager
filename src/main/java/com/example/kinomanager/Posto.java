package com.example.kinomanager;

public class Posto {
	private int numeroPosto;
	private int fila;
	private boolean isFree;
	
	
	public Posto(int numeroPosto, int fila) {
		super();
		this.numeroPosto = numeroPosto;
		this.fila = fila;
		this.isFree=true;
	}


	public int getNumero() {
		return numeroPosto;
	}


	private void setNumero(int numeroPosto) {
		this.numeroPosto = numeroPosto;
	}


	public int getFila() {
		return fila;
	}


	private void setFila(int fila) {
		this.fila = fila;
	}


	public boolean isFree() {
		return isFree;
	}


	private void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	
	
	
	
}
	
