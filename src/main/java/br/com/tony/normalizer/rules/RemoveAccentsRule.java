package br.com.tony.normalizer.rules;

import br.com.tony.normalizer.processor.Result;

import java.text.Normalizer;

public class RemoveAccentsRule implements Rule<String> {

    @Override
    public Result<String> apply(String value) {
        var result = removeAccents(value);
        return new Result<>(result);
    }

    private String removeAccents(String value) {
        if (value == null) return null;
        if (Normalizer.isNormalized(value, Normalizer.Form.NFD)) {
            return value;
        }
        return Normalizer.normalize(value, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
    }
}
