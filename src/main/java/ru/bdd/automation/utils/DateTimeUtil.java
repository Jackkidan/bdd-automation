package ru.bdd.automation.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DateTimeUtil {

    private DateTimeUtil() {}
    private static final String ARITHMETIC_EXCEPTION_MESSAGE = "Некорректный формат для вычисления даты, ошибка в знаке";
    private static final String ARITHMETIC_SIGN_PLUS = "plus";
    private static final String ARITHMETIC_SIGN_MINUS = "minus";

    public static String generateDate(String dateToGenerate) {
        LocalDate newDate = null;
        LocalDate currentDate = LocalDate.now();
        int diff = Integer.parseInt(dateToGenerate.replaceAll("\\D+", ""));
        if (dateToGenerate.contains("день")
                || dateToGenerate.contains("дней")
                || dateToGenerate.contains("дня")) {
            newDate = changeDays(dateToGenerate, currentDate, diff);
        } else if (dateToGenerate.contains("неделя")
                || dateToGenerate.contains("недели")
                || dateToGenerate.contains("недель")) {
            newDate = changeWeeks(dateToGenerate, currentDate, diff);
        } else if (dateToGenerate.contains("месяц")
                || dateToGenerate.contains("месяца")
                || dateToGenerate.contains("месяцев")) {
            newDate = changeMonths(dateToGenerate, currentDate, diff);
        } else if (dateToGenerate.contains("год")
                || dateToGenerate.contains("года")
                || dateToGenerate.contains("лет")) {
            newDate = changeYears(dateToGenerate, currentDate, diff);
        } else {
            try {
                throw new NumberFormatException("Некорректно указаны параметры изменения даты");
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        return Objects.requireNonNull(newDate).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    private static LocalDate changeDays(String dateToGenerate, LocalDate currentDate, int diff) {
        LocalDate newDate;
        switch (checkArithmeticSign(dateToGenerate)) {
            case ARITHMETIC_SIGN_PLUS:
                newDate = currentDate.plusDays(diff);
                break;
            case ARITHMETIC_SIGN_MINUS:
                newDate = currentDate.minusDays(diff);
                break;
            default:
                throw new ArithmeticException(ARITHMETIC_EXCEPTION_MESSAGE);
        }
        return newDate;
    }

    private static LocalDate changeWeeks(String dateToGenerate, LocalDate currentDate, int diff) {
        LocalDate newDate;

        switch (checkArithmeticSign(dateToGenerate)) {
            case ARITHMETIC_SIGN_PLUS:
                newDate = currentDate.plusWeeks(diff);
                break;
            case ARITHMETIC_SIGN_MINUS:
                newDate = currentDate.minusWeeks(diff);
                break;
            default:
                throw new ArithmeticException(ARITHMETIC_EXCEPTION_MESSAGE);
        }
        return newDate;
    }

    private static LocalDate changeMonths(String dateToGenerate, LocalDate currentDate, int diff) {
        LocalDate newDate;

        switch (checkArithmeticSign(dateToGenerate)) {
            case ARITHMETIC_SIGN_PLUS:
                newDate = currentDate.plusMonths(diff);
                break;
            case ARITHMETIC_SIGN_MINUS:
                newDate = currentDate.minusMonths(diff);
                break;
            default:
                throw new ArithmeticException(ARITHMETIC_EXCEPTION_MESSAGE);
        }
        return newDate;
    }

    private static LocalDate changeYears(String dateToGenerate, LocalDate currentDate, int diff) {
        LocalDate newDate;

        switch (checkArithmeticSign(dateToGenerate)) {
            case ARITHMETIC_SIGN_PLUS:
                newDate = currentDate.plusYears(diff);
                break;
            case ARITHMETIC_SIGN_MINUS:
                newDate = currentDate.minusYears(diff);
                break;
            default:
                throw new ArithmeticException(ARITHMETIC_EXCEPTION_MESSAGE);
        }
        return newDate;
    }

    private static String checkArithmeticSign(String stringToCheck) {
        String result = "empty string";
        if (stringToCheck.contains("+")) {
            result = ARITHMETIC_SIGN_PLUS;
        } else if (stringToCheck.contains("-")) {
            result = ARITHMETIC_SIGN_MINUS;
        }
        return result;
    }
}
