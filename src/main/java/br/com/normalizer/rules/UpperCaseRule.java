package br.com.normalizer.rules;

import br.com.normalizer.processor.Result;

public class UpperCaseRule implements Rule<String> {

    @Override
    public Result<String> apply(String value) {
        return new Result<>(value.toUpperCase());
    }
}
