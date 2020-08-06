package ru.bdd.automation.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class DataGenerationUtil {

    private static Logger logger = LoggerFactory.getLogger(DataGenerationUtil.class);
    enum Type {
        NUMERICAL,
        SYMBOLIC,
        COMBINED
    }

    public static String generateUniqueMail() {
        String uniqueMail = "%s@yandex.ru";
        uniqueMail = String.format(uniqueMail, generateUniqueValue(Type.SYMBOLIC));
        return uniqueMail;
    }

    public static String generateUniqueValue(Type type) {
        String uniqueValue = "generation failed";
        switch (type) {
            case NUMERICAL:
                uniqueValue = String.valueOf(new Date().getTime());
                logger.info(uniqueValue);
                break;
            case SYMBOLIC:

                String charsString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                        + "abcdefghijklmnopqrstuvxyz";
                StringBuilder sb = new StringBuilder(10);
                for (int i = 0; i < 10; i++) {
                    int index
                            = (int) (charsString.length()
                            * Math.random());
                    sb.append(charsString
                            .charAt(index));
                }
                uniqueValue = sb.toString();
                break;
            case COMBINED:
                uniqueValue = new Date().toString().replaceAll("[ :]", "").toLowerCase();
                logger.info(uniqueValue);
                break;
        }
        return uniqueValue;
    }
}
