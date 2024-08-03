package br.com.tony.normalizer.rules;

import java.util.List;

public record ResultRules<T>(T value, List<String> errors) { }
