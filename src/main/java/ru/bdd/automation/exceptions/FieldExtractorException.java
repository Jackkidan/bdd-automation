package ru.bdd.automation.exceptions;

public class FieldExtractorException extends NullPointerException {
    public FieldExtractorException(Exception e) {
    }

    @Override
    public String toString() {
        return "Field extraction exception. Class not found";
    }

}
