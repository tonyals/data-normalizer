package br.com.tony.normalizer.processor;

import java.util.List;

public record Result<T>(T value, List<String> errors) { }
