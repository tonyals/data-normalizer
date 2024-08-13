package br.com.normalizer.processor;

import br.com.normalizer.rules.Rule;

import java.util.List;

public interface NormalizeProcessorWithRule<T> {
    NormalizeProcessorResult<T> withRule(Rule<T> rule);
    NormalizeProcessorResult<T> withRules(List<Rule<T>> rules);
}
