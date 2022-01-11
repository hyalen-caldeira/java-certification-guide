package us.hyalen.ocp_two.JavaFundamentals.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import us.hyalen.tdd.ValidateISBN;

import static org.junit.jupiter.api.Assertions.*;

class ValidateISBNTest {
    private static final String VALID_ISBN_10_ONE = "0140449116";
    private static final String VALID_ISBN_10_TWO = "0140177396";
    private static final String VALID_ISBN_13_ONE = "9781853260087";
    private static final String VALID_ISBN_13_TWO = "9781853267338";
    private static final String VALID_ISBN_ENDING_WITH_X = "012000030X";
    private static final String INVALID_ISBN_10 = "0140449117";
    private static final String INVALID_ISBN_13 = "0140449118";
    private static final String LESS_THAN_10_DIGITS = "123456789";
    private static final String BAD_ISBN_FORMAT = "helloworld";

    ValidateISBN validator;
    boolean result;

    @BeforeEach
    void beforeEach() {
        validator = new ValidateISBN();
    }

    @Test
    void checkAValidISBNWith10Digits() {
        result = validator.checkISBN(VALID_ISBN_10_ONE);
        assertTrue(result, () -> "First ISBN with 10 digits ...");

        result = validator.checkISBN(VALID_ISBN_10_TWO);
        assertTrue(result, () -> "Second ISBN with 10 digits ...");
    }

    @Test
    void checkAValidISBNWith13Digits() {
        result = validator.checkISBN(VALID_ISBN_13_ONE);
        assertTrue(result, () -> "First ISBN with 13 digits ...");

        result = validator.checkISBN(VALID_ISBN_13_TWO);
        assertTrue(result, () -> "Second ISBN with 13 digits ...");
    }

    @Test
    void checkAnInvalidISBNWith10Digits() {
        result = validator.checkISBN(INVALID_ISBN_10);
        assertFalse(result, () -> "22");
    }

    @Test
    void checkAnInvalidISBNWith13Digits() {
        result = validator.checkISBN(INVALID_ISBN_13);
        assertFalse(result, () -> "33");
    }

    @Test
    void checkIfNumberOfDigitsIsValid() {
        // Second parameter expects the object to implement the Executable interface
        assertThrows(NumberFormatException.class, () -> validator.checkISBN(LESS_THAN_10_DIGITS));
    }

    @Test
    void when_ANonNumericISBNIsInformed_then_throwsNumberFormatException() {
        // Second parameter expects an Executable
        assertThrows(NumberFormatException.class, () -> validator.checkISBN(BAD_ISBN_FORMAT));
    }

    @Test
    void checkIfAnISBNEndingWithXIsValid() {
        result = validator.checkISBN(VALID_ISBN_ENDING_WITH_X);
        assertTrue(result, () -> "Third value ...");
    }
}