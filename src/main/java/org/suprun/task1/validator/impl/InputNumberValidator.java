package org.suprun.task1.validator.impl;

import org.suprun.task1.validator.Validator;

import java.util.regex.Pattern;

public class InputNumberValidator implements Validator<String> {

    private static final String VALID_PASSWORD_REGEX = "^([0-9]|1[0-9]|2[0])$";

    private static Validator<String> instance;

    private InputNumberValidator() {

    }

    public static Validator<String> getInstance() {
        if (instance == null) {
            instance = new InputNumberValidator();
        }
        return instance;
    }

    @Override
    public boolean validate(String matrixSize) {
        return Pattern.matches(VALID_PASSWORD_REGEX, matrixSize);
    }
}
