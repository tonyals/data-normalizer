package br.com.tony.normalizer.processor;

public interface NormalizeProcessorResult<T> {
    Result<T> apply();
}
