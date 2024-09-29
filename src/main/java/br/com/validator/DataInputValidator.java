package br.com.validator;

import java.security.InvalidParameterException;
import java.util.regex.Pattern;

public class DataInputValidator implements EmailValidator {

    private static final String REGEX = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    private String value;

    @Override
    public EmailValidator forInput(String email) {
        if (email == null || email.isBlank()) {
            throw new InvalidParameterException("Input should be a valid string");
        }
        this.value = email;
        return this;
    }

    @Override
    public boolean isEmail() {
        return Pattern.compile(REGEX).matcher(this.value).matches();
    }
}
