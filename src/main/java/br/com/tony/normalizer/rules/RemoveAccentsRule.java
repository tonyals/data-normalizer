package br.com.tony.normalizer.rules;

import br.com.tony.normalizer.util.StringNormalizer;

import java.util.ArrayList;

public class RemoveAccentsRule implements Rule<String> {

    @Override
    public ResultRules<String> apply(String value) {
        return new ResultRules<>(StringNormalizer.removeAccents(value), new ArrayList<>());
    }
}
