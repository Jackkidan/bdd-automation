package ru.bdd.automation.exceptions;

public class CSVModelException extends NullPointerException {
    public CSVModelException(Exception e) {
    }

    @Override
    public String toString() {
        return "Parse csv string error.";
    }

}
