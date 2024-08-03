package br.com.tony.normalizer;

import br.com.tony.normalizer.processor.Result;
import br.com.tony.normalizer.processor.StringNormalizerProcessor;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Result result = new StringNormalizerProcessor("joão")
                .normalize();

        Result result2 = new StringNormalizerProcessor(null)
                .normalize(s -> Objects.nonNull(s) && !s.isEmpty());

        System.out.println(result);
        System.out.println(result2);
    }
}