package br.com.tony.normalizer.rules;

import br.com.tony.normalizer.domain.RuleProcessorImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveAccentsRuleTest {

    @ParameterizedTest
    @CsvSource({
            "çÇáéíóúýÁ, cCaeiouyA",
            "João Nóbrega, Joao Nobrega",
            "São Paulo, Sao Paulo"
    })
    void shouldRemoveAccentsWhenApplyRemoveAccentsRule(String value, String expectedValue) {
        ResultRules<String> resultRules = new RuleProcessorImpl<String>()
                .forValue(value)
                .withRule(new RemoveAccentsRule())
                .apply();

        assertEquals(expectedValue, resultRules.value());
    }
}
