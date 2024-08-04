package br.com.tony.normalizer.processor;

import br.com.tony.normalizer.rules.NormalizeRule;

import java.security.InvalidParameterException;

public class NormalizeProcessorImpl<T> implements NormalizeProcessor.ForValue<T>, NormalizeProcessor.WithRule<T>, NormalizeProcessor.ProcessorResult<T> {
    private NormalizeRule<T> normalizeRule;
    private T value;

    @Override
    public NormalizeProcessor.WithRule<T> forValue(T value) {
        this.value = value;
        return this;
    }

    @Override
    public NormalizeProcessor.ProcessorResult<T> withRule(NormalizeRule<T> normalizeRule) {
        if (normalizeRule == null) throw new InvalidParameterException("Rule cannot be null");
        this.normalizeRule = normalizeRule;
        return this;
    }

    @Override
    public Result<T> apply() {
        return normalizeRule.apply(value);
    }
}
