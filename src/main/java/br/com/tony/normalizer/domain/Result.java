package br.com.tony.normalizer.domain;

import java.util.List;

public record Result(String value, List<String> errors) { }
