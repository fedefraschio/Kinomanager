package model;

import java.time.LocalDateTime;

public class Biglietto {
    private int id;
    private LocalDateTime timestampEmissione;
    private Cliente cliente;
    private Spettacolo spettacolo;
    private Posto posto;

    public Biglietto(int id, LocalDateTime timestampEmissione, Cliente cliente, Spettacolo spettacolo, Posto posto) {
        this.id = id;
        this.timestampEmissione = timestampEmissione;
        this.cliente = cliente;
        this.spettacolo = spettacolo;
        this.posto = posto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getTimestampEmissione() {
        return timestampEmissione;
    }

    public void setTimestampEmissione(LocalDateTime timestampEmissione) {
        this.timestampEmissione = timestampEmissione;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Spettacolo getSpettacolo() {
        return spettacolo;
    }

    public void setSpettacolo(Spettacolo spettacolo) {
        this.spettacolo = spettacolo;
    }

    public Posto getPosto() {
        return posto;
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }
}
