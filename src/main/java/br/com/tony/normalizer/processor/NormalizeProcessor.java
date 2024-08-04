package br.com.tony.normalizer.processor;


import br.com.tony.normalizer.rules.NormalizeRule;

public interface NormalizeProcessor {

    interface ForValue<T> {
        NormalizeProcessor.WithRule<T> forValue(T value);
    }
    interface WithRule<T> {
        NormalizeProcessor.WithRule<T> withRule(NormalizeRule<T> normalizeRule);
        Result<T> apply();
    }
}
