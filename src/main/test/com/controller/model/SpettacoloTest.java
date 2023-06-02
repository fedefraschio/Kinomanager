package com.controller.model;

import model.Film;
import model.GiornoDellaSettimana;
import model.Sala;
import model.Spettacolo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpettacoloTest {

    Spettacolo s1,s2,s3;

    @BeforeEach
    void setUp()
    {
        s1=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
                new Film("Fast X","Azione"), new Sala(5,200),
                LocalDate.of(2023, Month.JUNE, 23), LocalTime.of(21,00));
        s2=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 23).getDayOfWeek()),
                new Film("Love Again","Romantico"), new Sala(4,50),
                LocalDate.of(2023, Month.JUNE, 23), LocalTime.of(15,30));
        s3=new Spettacolo(GiornoDellaSettimana.getGiornoDaDay(LocalDate.of(2023, Month.JUNE, 21).getDayOfWeek()),
                new Film("Borromini e Bernini","Storico"), new Sala(1,25),
                LocalDate.of(2023, Month.JUNE, 21), LocalTime.of(21,00));
    }

    @Test
    @DisplayName("Test acquista biglietti e posti rimanenti")
    void testPostiRimanenti()
    {
        assertEquals(40,s1.acquistaBiglietti(40));
        assertEquals(160,s1.getSala().getPostiRimanenti());
    }

}
