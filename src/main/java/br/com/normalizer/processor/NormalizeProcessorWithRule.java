package br.com.normalizer.processor;

import br.com.normalizer.rules.Rule;

import java.util.List;

public interface NormalizeProcessorWithRule<T> {
    /**
     * Apply the provided Rule<T> in a value.
     * @param rule a single rule to apply.
     * @return a NormalizerProcessorResult<T>
     */
    NormalizeProcessorResult<T> withRule(Rule<T> rule);

    /**
     * Apply rules list, sequentially and cumulative in a value.
     * @param rules a list with all rules to apply.
     * @return a NormalizerProcessorResult<T>
     */
    NormalizeProcessorResult<T> withRules(List<Rule<T>> rules);
}
