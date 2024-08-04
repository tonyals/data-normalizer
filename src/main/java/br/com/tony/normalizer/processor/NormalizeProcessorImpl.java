package br.com.tony.normalizer.processor;

import br.com.tony.normalizer.rules.Rule;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class NormalizeProcessorImpl<T> implements NormalizeProcessor.ForValue<T>, NormalizeProcessor.WithRule<T> {

    private final List<Rule<T>> rules = new ArrayList<>();
    private T value;

    @Override
    public NormalizeProcessor.WithRule<T> forValue(T value) {
        if (value == null) throw new InvalidParameterException("Value cannot be null");
        this.value = value;
        return this;
    }

    @Override
    public NormalizeProcessor.WithRule<T> withRule(Rule<T> rule) {
        if (rule == null) throw new InvalidParameterException("Rule cannot be null");
        this.rules.add(rule);
        return this;
    }

    @Override
    public Result<T> apply() {
        this.rules.forEach(n -> {
            var r = n.apply(value);
            this.value = r.value();
        });
        return new Result<>(value);
    }
}
