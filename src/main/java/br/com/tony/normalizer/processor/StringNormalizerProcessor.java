package br.com.tony.normalizer.processor;

import br.com.tony.normalizer.domain.NormalizerProcessor;
import br.com.tony.normalizer.domain.Result;
import br.com.tony.normalizer.util.StringNormalizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class StringNormalizerProcessor implements NormalizerProcessor<String> {

    private final String string;
    private final List<String> errors = new ArrayList<>();

    public StringNormalizerProcessor(String string) {
        this.string = string;
    }

    @Override
    public Result normalize(Predicate<String> precondition) {
        if (!precondition.test(string)) {
            return new Result(string, Collections.emptyList());
        }
        return normalize();
    }

    @Override
    public Result normalize() {
        return new Result(StringNormalizer.removeAccents(string), errors);
    }
}
