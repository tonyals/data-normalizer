package br.com.tony.normalizer.processor.impl;

import br.com.tony.normalizer.processor.*;
import br.com.tony.normalizer.rules.Rule;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class NormalizeProcessorImpl<T> implements NormalizeProcessorForValue<T>, NormalizeProcessorResult<T>, NormalizeProcessorWithRule<T> {

    private static final String INVALID_RULE_EXCEPTION_MESSAGE = "Rule cannot be null";
    private static final String INVALID_VALUE_EXCEPTION_MESSAGE = "Value cannot be null";
    private final List<Rule<T>> rules = new ArrayList<>();
    private T value;

    @Override
    public NormalizeProcessorWithRule<T> forValue(T value) {
        if (value == null) throw new InvalidParameterException(INVALID_VALUE_EXCEPTION_MESSAGE);
        this.value = value;
        return this;
    }

    @Override
    public NormalizeProcessorResult<T> withRule(Rule<T> rule) {
        if (rule == null) throw new InvalidParameterException(INVALID_RULE_EXCEPTION_MESSAGE);
        this.rules.add(rule);
        return this;
    }

    @Override
    public NormalizeProcessorResult<T> withRules(List<Rule<T>> rules) {
        if (rules == null) throw new InvalidParameterException(INVALID_RULE_EXCEPTION_MESSAGE);
        rules.forEach(this::withRule);
        return this;
    }

    @Override
    public Result<T> apply() {
        this.rules.forEach(rule -> {
            var result = rule.apply(value);
            this.value = result.value();
        });
        return new Result<>(value);
    }
}
