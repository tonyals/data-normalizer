package br.com.tony.normalizer.rules;


import br.com.tony.normalizer.processor.Result;

public interface NormalizeRule<T> {
    Result<T> apply(T value);
}
