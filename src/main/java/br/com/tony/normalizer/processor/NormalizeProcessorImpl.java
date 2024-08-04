package br.com.tony.normalizer.processor;

import br.com.tony.normalizer.rules.NormalizeRule;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class NormalizeProcessorImpl<T> implements NormalizeProcessor.ForValue<T>, NormalizeProcessor.WithRule<T> {

    private final List<NormalizeRule<T>> normalizeRules = new ArrayList<>();
    private T value;

    @Override
    public NormalizeProcessor.WithRule<T> forValue(T value) {
        if (value == null) throw new InvalidParameterException("Value cannot be null");
        this.value = value;
        return this;
    }

    @Override
    public NormalizeProcessor.WithRule<T> withRule(NormalizeRule<T> normalizeRule) {
        if (normalizeRule == null) throw new InvalidParameterException("Rule cannot be null");
        this.normalizeRules.add(normalizeRule);
        return this;
    }

    @Override
    public Result<T> apply() {
        this.normalizeRules.forEach(n -> {
            var r = n.apply(value);
            this.value = r.value();
        });
        return new Result<>(value);
    }
}
