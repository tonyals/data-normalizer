package br.com.normalizer.processor;


public interface NormalizeProcessorForValue<T> {
    NormalizeProcessorWithRule<T> forValue(T value);
}
