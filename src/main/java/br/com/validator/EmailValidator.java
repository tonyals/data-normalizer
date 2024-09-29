package br.com.validator;

public interface EmailValidator {
    EmailValidator forInput(String email);
    boolean isEmail();
}
