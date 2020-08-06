package ru.bdd.automation.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PropertiesHandler {
    private static volatile PropertiesHandler instance = null;
    private final java.util.Properties properties = new java.util.Properties();

    private PropertiesHandler() {
        try {
            properties.load(new FileInputStream(new File("./config.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertiesHandler getInstance() {
        PropertiesHandler localInstance = instance;
        if (localInstance == null) {
            synchronized (PropertiesHandler.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new PropertiesHandler();
                }
            }
        }
        return localInstance;
    }

    public java.util.Properties getProperties() {
        return properties;
    }

}
