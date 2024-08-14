package br.com.normalizer.processor.impl;

import br.com.normalizer.rules.RemoveAccentsRule;
import br.com.normalizer.rules.UpperCaseRule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.security.InvalidParameterException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NormalizeProcessorImplTest {

    @ParameterizedTest
    @CsvSource({
            "çÇáéíóúýÁ, CCAEIOUYA",
            "João Nóbrega, JOAO NOBREGA",
            "São Paulo, SAO PAULO"
    })
    void shouldApplyAllRulesWhenProvideMoreThanOneRule(String value, String expectedValue) {
        var result = new NormalizeProcessorImpl<String>()
                .forValue(value)
                .withRules(List.of(new RemoveAccentsRule(), new UpperCaseRule()))
                .apply();

        assertEquals(expectedValue, result.value());
    }

    @Test
    void shouldThrowInvalidParameterExceptionWhenValueIsNull() {
        var processor = new NormalizeProcessorImpl<String>();

        assertThrows(InvalidParameterException.class, () -> processor.forValue(null));
    }

    @Test
    void shouldThrowInvalidParameterExceptionWhenRuleIsNull() {
        var processor = new NormalizeProcessorImpl<String>()
                .forValue("any value");

        assertThrows(InvalidParameterException.class, () -> processor.withRule(null));
    }

    @Test
    void shouldThrowInvalidParameterExceptionWhenRuleListIsNull() {
        var processor = new NormalizeProcessorImpl<String>()
                .forValue("any value");

        assertThrows(InvalidParameterException.class, () -> processor.withRules(null));
    }
}
