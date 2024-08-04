package br.com.tony.normalizer.processor;


import br.com.tony.normalizer.rules.Rule;

public interface NormalizeProcessor {

    interface ForValue<T> {
        NormalizeProcessor.WithRule<T> forValue(T value);
    }
    interface WithRule<T> {
        NormalizeProcessor.WithRule<T> withRule(Rule<T> rule);
        Result<T> apply();
    }
}
