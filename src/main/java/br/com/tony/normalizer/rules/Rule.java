package br.com.tony.normalizer.rules;


public interface Rule<T> {
    ResultRules<T> apply(T value);
}
