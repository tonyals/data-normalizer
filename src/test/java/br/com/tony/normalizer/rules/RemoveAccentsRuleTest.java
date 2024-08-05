package br.com.tony.normalizer.rules;

import br.com.tony.normalizer.processor.impl.NormalizeProcessorImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RemoveAccentsRuleTest {

    @ParameterizedTest
    @CsvSource({
            "çÇáéíóúýÁ, cCaeiouyA",
            "João Nóbrega, Joao Nobrega",
            "São Paulo, Sao Paulo"
    })
    void shouldRemoveAccentsWhenUseRemoveAccentsRule(String value, String expectedValue) {
        var result = new NormalizeProcessorImpl<String>()
                .forValue(value)
                .withRule(new RemoveAccentsRule())
                .apply();

        assertEquals(expectedValue, result.value());
    }
}
