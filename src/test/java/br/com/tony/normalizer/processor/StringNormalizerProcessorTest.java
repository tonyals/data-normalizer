package br.com.tony.normalizer.processor;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StringNormalizerProcessorTest {

    @Test
    void shouldReturnStringNormalized() {
        var result = new StringNormalizerProcessor("João Carlos").normalize();

        assertEquals("Joao Carlos", result.value());
    }

    @Test
    void shouldReturnValueWithoutChangesWhenPreconditionIsFalse() {
        var result = new StringNormalizerProcessor(null).normalize(s -> Objects.nonNull(s) && !s.isEmpty());

        assertNull(result.value());
    }
}
