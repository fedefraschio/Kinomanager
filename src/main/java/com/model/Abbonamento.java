package com.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Abbonamento {
    private int id;
    private LocalDate dataAttivazione; // la data finale viene dedotta, in quanto ogni abbonamento vale 90 giorni
    private Cliente cliente;


    public Abbonamento(int id, LocalDate dataAttivazione,Cliente cliente) {
        this.id = id;
        this.dataAttivazione=dataAttivazione;
        this.cliente=cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataAttivazione() {
        return dataAttivazione;
    }

    public void setDataAttivazione(LocalDate dataAttivazione) {
        this.dataAttivazione = dataAttivazione;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long validitaRimanente()
    {
        return 90-(Duration.between(this.dataAttivazione,LocalDateTime.now()).toDays());
    }
}
