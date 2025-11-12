package com.foursales.market.exception;

import java.util.List;

public class ValidationException extends RuntimeException {

    private final List<String> errors;

    public ValidationException(List<String> errors) {
        super("A validação falhou");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
