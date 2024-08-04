package br.com.tony.normalizer.processor;

import br.com.tony.normalizer.rules.RemoveAccentsNormalizeRule;
import br.com.tony.normalizer.rules.UpperCaseNormalizeRule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.security.InvalidParameterException;

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
                .withRule(new RemoveAccentsNormalizeRule())
                .withRule(new UpperCaseNormalizeRule())
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
}
