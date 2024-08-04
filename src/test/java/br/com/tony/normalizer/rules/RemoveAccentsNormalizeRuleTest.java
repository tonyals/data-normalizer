package br.com.tony.normalizer.rules;

import br.com.tony.normalizer.processor.NormalizeProcessorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RemoveAccentsNormalizeRuleTest {

    @Test
    void shouldReturnNullWhenValueIsNull() {
        var result = new NormalizeProcessorImpl<String>()
                .forValue(null)
                .withRule(new RemoveAccentsNormalizeRule())
                .apply();

        assertNull(result.value());
    }

    @ParameterizedTest
    @CsvSource({
            "çÇáéíóúýÁ, cCaeiouyA",
            "João Nóbrega, Joao Nobrega",
            "São Paulo, Sao Paulo"
    })
    void shouldRemoveAccentsWhenUseRemoveAccentsRule(String value, String expectedValue) {
        var result = new NormalizeProcessorImpl<String>()
                .forValue(value)
                .withRule(new RemoveAccentsNormalizeRule())
                .apply();

        assertEquals(expectedValue, result.value());
    }
}
