package br.com.tony.normalizer.processor;

import java.util.function.Predicate;

public interface NormalizerProcessor<T> {
    Result normalize(Predicate<T> precondition);
    Result normalize();
}
