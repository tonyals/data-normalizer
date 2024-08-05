package br.com.tony.normalizer.processor;

import br.com.tony.normalizer.rules.Rule;

import java.util.List;

public interface NormalizeProcessorWithRule<T> {
    NormalizeProcessorResult<T> withRule(Rule<T> rule);
    NormalizeProcessorResult<T> withRules(List<Rule<T>> rules);
}
