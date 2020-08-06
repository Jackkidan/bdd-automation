package ru.bdd.automation.exceptions;

public class PageLoadException extends NullPointerException {
    public PageLoadException(Exception e) {
    }

    @Override
    public String toString() {
        return "Field extraction exception. Page is not loaded";
    }
}
