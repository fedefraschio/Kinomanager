package com.controller.model;

import model.Sala;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaTest {

    Sala s1,s2,s3;


@BeforeEach
void setUp()
{
    s1=new Sala(1,100);
    s2=new Sala(1,50);
    s3=new Sala(1,20);
}

    @Test
    @DisplayName("Test posti rimanenti")
    void testPostiRimanenti()
    {
        //s1.occupaPosti(40);
        assertEquals(100,s1.getPostiRimanenti());
       // s1.occupaPosti(12);
        assertEquals(50,s2.getPostiRimanenti());
        assertEquals(20,s3.getPostiRimanenti());
        assertEquals(40,s1.occupaPosti(40));
        assertEquals(-1,s1.occupaPosti(100));
    }



}
