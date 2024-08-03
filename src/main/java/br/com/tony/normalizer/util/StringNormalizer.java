package br.com.tony.normalizer.util;

import java.text.Normalizer;

public class StringNormalizer {

    private StringNormalizer() { }

    public static String removeAccents(String value) {
        if (value == null) return null;
        if (Normalizer.isNormalized(value, Normalizer.Form.NFD)) {
            return value;
        }
        return Normalizer.normalize(value, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
    }
}
