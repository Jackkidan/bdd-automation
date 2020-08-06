package ru.bdd.automation.utils;

import java.util.Properties;

import lombok.Getter;
import lombok.Setter;
import ru.bdd.automation.core.PropertiesHandler;

public class TimeOutUtil {
    private static Properties properties = PropertiesHandler.getInstance().getProperties();

    @Getter
    @Setter
    private static int MIDDLE_IMPLICITLY_WAIT = Integer.parseInt(properties.getProperty("middle.implicitly.wait"));
    @Getter
    public static final int SHORT_IMPLICITLY_WAIT = Integer.parseInt(properties.getProperty("short.implicitly.wait"));
    @Getter
    public static final int LONG_IMPLICITLY_WAIT = Integer.parseInt(properties.getProperty("long.implicitly.wait"));

    private TimeOutUtil() {
    }
}
