package br.com.tony.normalizer.processor;


import br.com.tony.normalizer.rules.NormalizeRule;

public interface NormalizeProcessor {

    interface ForValue<T> {
        NormalizeProcessor.WithRule<T> forValue(T value);
    }
    interface WithRule<T> {
        NormalizeProcessor.ProcessorResult<T> withRule(NormalizeRule<T> normalizeRule);
    }
    interface ProcessorResult<T> {
        Result<T> apply();
    }
}
