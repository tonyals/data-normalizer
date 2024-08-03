package br.com.tony.normalizer.processor;

import java.util.List;

public record Result(String value, List<String> errors) { }
