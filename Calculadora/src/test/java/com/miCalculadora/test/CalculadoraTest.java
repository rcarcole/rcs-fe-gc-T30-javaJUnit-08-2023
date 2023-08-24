package com.miCalculadora.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void testAddition() {
        double result = 5 + 3;
        assertEquals(8, result, "Expected addition of 5 and 3 to be 8");
    }
}