package com.calculatrice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatriceTest {
    
    @Test
    public void testAddition() {
        Calculatrice calculatrice = new Calculatrice();
        assertEquals(5.0, calculatrice.addition(2, 3));
        assertEquals(6.0, calculatrice.addition(2.5, 3.5), 0.0001);
        assertEquals(-1.0, calculatrice.addition(-3, 2));
    }

    @Test
    public void testSoustraction() {
        Calculatrice calculatrice = new Calculatrice();
        assertEquals(1.0, calculatrice.soustraction(3, 2));
        assertEquals(-1.0, calculatrice.soustraction(2.5, 3.5), 0.0001);
        assertEquals(-5.0, calculatrice.soustraction(-3, 2));
    }

    @Test
    public void testMultiplication() {
        Calculatrice calculatrice = new Calculatrice();
        assertEquals(6.0, calculatrice.multiplication(2, 3));
        assertEquals(8.75, calculatrice.multiplication(2.5, 3.5), 0.0001);
        assertEquals(-6.0, calculatrice.multiplication(-3, 2));
    }

    @Test
    public void testDivision() {
        Calculatrice calculatrice = new Calculatrice();
        assertEquals(2.0, calculatrice.division(6, 3));
        assertEquals(2.5, calculatrice.division(5, 2), 0.0001);
        assertEquals(-1.5, calculatrice.division(-3, 2), 0.0001);
    }

    @Test
    public void testDivisionParZero() {
        Calculatrice calculatrice = new Calculatrice();
        assertThrows(IllegalArgumentException.class, () -> {
            calculatrice.division(5, 0);
        });
    }
}