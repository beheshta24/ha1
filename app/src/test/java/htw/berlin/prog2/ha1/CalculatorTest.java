package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen
    @Test
    @DisplayName("should correctly change the sign of a number")
    void testChangeSign() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);
        calc.pressNegativeKey(); // Macht die Zahl negativ

        String expected = "-5";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should repeat the last operation when equals is pressed multiple times")
    void testRepeatedEqualsKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(5);  // Benutzer gibt 5 ein
        calc.pressBinaryOperationKey("+");  // Benutzer drückt Plus-Taste
        calc.pressDigitKey(3);  // Benutzer gibt 3 ein
        calc.pressEqualsKey();  // Benutzer drückt Gleichheitstaste (Ergebnis: 8)
        calc.pressEqualsKey();  // Benutzer drückt erneut die Gleichheitstaste (Ergebnis sollte 11 sein, da 3 wieder hinzugefügt wird)

        String expected = "11";  // 5 + 3 + 3 = 11
        String actual = calc.readScreen();

        assertEquals(expected, actual);  // Dieser Test schlägt fehl, weil das Verhalten bei wiederholtem Drücken von "=" nicht implementiert ist
    }

    @Test
    @DisplayName("should display 0 when calculating the square root of 0")
    void testSquareRootOfZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);  // Benutzer gibt 0 ein
        calc.pressUnaryOperationKey("√");  // Benutzer drückt die Quadratwurzel-Taste

        String expected = "0";  // Quadratwurzel von 0 sollte 0 sein
        String actual = calc.readScreen();

        assertEquals(expected, actual);  // Der Test schlägt fehl, wenn die Quadratwurzel von 0 falsch berechnet wird
    }




}

