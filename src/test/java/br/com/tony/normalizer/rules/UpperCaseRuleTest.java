package br.com.tony.normalizer.rules;

import br.com.tony.normalizer.processor.impl.NormalizeProcessorImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UpperCaseRuleTest {

    @ParameterizedTest
    @CsvSource({
            "cCaeiouyA, CCAEIOUYA",
            "Joao Nobrega, JOAO NOBREGA",
            "Sao Paulo, SAO PAULO",
            "São Paulo, SÃO PAULO",
    })
    void shouldTransformValueToUpperCaseWhenApplyUpperCaseNormalizeRule(String value, String expectedValue) {
        var result = new NormalizeProcessorImpl<String>()
                .forValue(value)
                .withRule(new UpperCaseRule())
                .apply();

        assertEquals(expectedValue, result.value());
    }
}
