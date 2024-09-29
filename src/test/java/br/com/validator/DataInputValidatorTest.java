package br.com.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataInputValidatorTest {

    @Test
    void shouldReturnTrueWhenInputIsAValidEmail() {
        var validator = new DataInputValidator();

        var isEmail = validator.forInput("a@a.com").isEmail();

        assertTrue(isEmail);
    }

    @Test
    void shouldReturnFalseWhenInputIsAnInvalidEmail() {
        var validator = new DataInputValidator();

        var isEmail = validator.forInput("invalid.mail.com").isEmail();

        assertFalse(isEmail);
    }
}
