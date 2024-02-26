package calculator.calculatordemo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();

    @Test
    void testPlus() {
        assertEquals(3,calculatorService.plus(1, 2));
        assertEquals(1,calculatorService.plus(-1, 2));
        assertEquals(-1,calculatorService.plus(1, -2));
        assertEquals(-3,calculatorService.plus(-1, -2));
        assertEquals(2,calculatorService.plus(0, 2));
        assertEquals(1,calculatorService.plus(1, 0));
        assertEquals(0,calculatorService.plus(0, 0));
        assertEquals(-10,calculatorService.plus(0, -10));
        assertEquals(-20,calculatorService.plus(-20, 0));
    }


    @Test
    void testMinus() {
        assertEquals(-1,calculatorService.minus(1, 2));
        assertEquals(-3,calculatorService.minus(-1, 2));
        assertEquals(3,calculatorService.minus(1, -2));
        assertEquals(1,calculatorService.minus(-1, -2));
        assertEquals(-2,calculatorService.minus(0, 2));
        assertEquals(1,calculatorService.minus(1, 0));
        assertEquals(0,calculatorService.minus(0, 0));
        assertEquals(10,calculatorService.minus(0, -10));
        assertEquals(-20,calculatorService.minus(-20, 0));
    }

    @Test
    void testMultiply() {
        assertEquals(2,calculatorService.multiply(1, 2));
        assertEquals(-2,calculatorService.multiply(-1, 2));
        assertEquals(-2,calculatorService.multiply(1, -2));
        assertEquals(2,calculatorService.multiply(-1, -2));
        assertEquals(0,calculatorService.multiply(0, 2));
        assertEquals(0,calculatorService.multiply(1, 0));
        assertEquals(0,calculatorService.multiply(0, 0));
        assertEquals(0,calculatorService.multiply(0, -10));
        assertEquals(0,calculatorService.multiply(-20, 0));
    }

    @Test
    void testDivide() {
        assertEquals(0,calculatorService.divide(1, 2));
        assertEquals(0,calculatorService.divide(0, 2));
        assertEquals(-1,calculatorService.divide(10, -10));
        assertEquals(-1,calculatorService.divide(-20, 20));
        assertEquals(2,calculatorService.divide(40, 20));
        assertEquals(1,calculatorService.divide(-20, -20));

        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(1, 0));
    }
}