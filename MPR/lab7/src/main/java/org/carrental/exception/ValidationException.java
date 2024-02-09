package org.carrental.exception;

import java.util.Map;

public class ValidationException extends RuntimeException {
    private String field;
    private String message;
    private Map<String, String> errors;

    public ValidationException(String field, String message) {
        super(message);
        this.field = field;
        this.message = message;
    }

    public ValidationException(Map<String, String> errors) {
        this.errors = errors;
    }

    public String getField() {
        return field;
    }

    @Override
    public String getMessage() {
        return field + " " + message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
