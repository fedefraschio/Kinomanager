package model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Abbonamento {
    private int id;
    private LocalDate dataAttivazione; // la data finale viene dedotta, in quanto ogni abbonamento vale 90 giorni


    public Abbonamento(int id, LocalDate dataAttivazione) {
        this.id = id;
        this.dataAttivazione=dataAttivazione;
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

    public long validitaRimanente()
    {
        return 90-(Duration.between(this.dataAttivazione,LocalDateTime.now()).toDays());
    }
}
