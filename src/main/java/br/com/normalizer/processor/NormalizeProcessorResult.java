package br.com.normalizer.processor;

public interface NormalizeProcessorResult<T> {
    Result<T> apply();
}
