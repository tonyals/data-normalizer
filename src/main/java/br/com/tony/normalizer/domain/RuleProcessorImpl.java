package br.com.tony.normalizer.domain;

import br.com.tony.normalizer.rules.ResultRules;
import br.com.tony.normalizer.rules.Rule;

import java.security.InvalidParameterException;

public class RuleProcessorImpl<T> implements RuleProcessor.ForValue<T>, RuleProcessor.WithRule<T>, RuleProcessor.ProcessorResult<T> {
    private Rule<T> rule;
    private T value;

    @Override
    public RuleProcessor.WithRule<T> forValue(T value) {
        this.value = value;
        return this;
    }

    @Override
    public RuleProcessor.ProcessorResult<T> withRule(Rule<T> rule) {
        if (rule == null) throw new InvalidParameterException("Rule invalid");
        this.rule = rule;
        return this;
    }

    @Override
    public ResultRules<T> apply() {
        return rule.apply(value);
    }
}
