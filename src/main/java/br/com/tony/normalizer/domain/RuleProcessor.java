package br.com.tony.normalizer.domain;


import br.com.tony.normalizer.rules.ResultRules;
import br.com.tony.normalizer.rules.Rule;

public interface RuleProcessor {

    interface ForValue<T> {
        RuleProcessor.WithRule<T> forValue(T value);
    }
    interface WithRule<T> {
        RuleProcessor.ProcessorResult<T> withRule(Rule<T> rule);
    }
    interface ProcessorResult<T> {
        ResultRules<T> apply();
    }
}
