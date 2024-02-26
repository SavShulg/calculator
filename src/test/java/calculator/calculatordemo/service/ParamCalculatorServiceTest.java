package calculator.calculatordemo.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ParamCalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();

    public static Stream<Arguments> args() {
        return Stream.of(
        Arguments.of(1, 2),
        Arguments.of(-1, 2),
        Arguments.of(1, -2),
        Arguments.of(-1, -2),
        Arguments.of(0, 2),
        Arguments.of(1, 0),
        Arguments.of(0, 0),
        Arguments.of(0, -10),
        Arguments.of(-20, 0));

    }

    @ParameterizedTest
    @MethodSource("args")
    void namePlus(Integer num1, Integer num2) {
        assertEquals(num1 + num2, calculatorService.plus(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("args")
    void nameMinus(Integer num1, Integer num2) {
        assertEquals(num1 - num2, calculatorService.minus(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("args")
    void nameMultiply(Integer num1, Integer num2) {
        assertEquals(num1 * num2, calculatorService.multiply(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("args")
    void nameDivide(Integer num1, Integer num2) {
        if (num2 == 0) {
            assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(num1, num2));
            return;
        }
        assertEquals(num1 / num2, calculatorService.divide(num1, num2));
    }
}