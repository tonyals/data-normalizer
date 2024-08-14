package br.com.normalizer.rules;


import br.com.normalizer.processor.Result;

public interface Rule<T> {
    Result<T> apply(T value);
}
