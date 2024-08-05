package br.com.tony.normalizer.processor;


public interface NormalizeProcessorForValue<T> {
    NormalizeProcessorWithRule<T> forValue(T value);
}
