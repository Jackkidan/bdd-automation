package ru.bdd.automation.core;

import ru.bdd.automation.exceptions.*;
import lombok.Getter;
import ru.bdd.automation.models.CSVElementModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FieldsExtractor {
    @Getter
    private static AbstractElement abstractElement;

    FieldsExtractor(){}

    public static AbstractElement getField(String fieldName) {
        StringBuilder stringBuilder = new StringBuilder();
        String mapKey = stringBuilder
                .append(AbstractPage.getCurentPage())
                .append(" - ")
                .append(fieldName)
                .toString();

        CSVElementModel elementModel = CSVElementModel.modelsMap.get(mapKey);
        Class<?> clazz = null;
        try {
            StringBuilder className = new StringBuilder();
            clazz = Class.forName(className.append("ru.bdd.automation.elementTypes.").append(elementModel.getFieldType()).toString());

            WebElement webElement;
            switch (elementModel.getSearchType().toLowerCase()) {
                case "xpath":
                    webElement = DriverManager.getDriver()
                            .findElement(By.xpath(elementModel.getLocator()));
                    break;
                case "name":
                    webElement = DriverManager.getDriver()
                            .findElement(By.name(elementModel.getLocator()));
                    break;
                case "classname":
                    webElement = DriverManager.getDriver()
                            .findElement(By.className(elementModel.getLocator()));
                    break;
                //TODO
                default:
                    webElement = DriverManager.getDriver()
                            .findElement(By.xpath(elementModel.getLocator()));
                    break;
            }
            Constructor[] construct = clazz.getDeclaredConstructors();
            abstractElement = (AbstractElement) construct[0].newInstance(webElement);
        } catch (NullPointerException e) {
            throw new PageLoadException(e);
        } catch (ClassNotFoundException e) {
            throw new FieldExtractorException(e);
        } catch (InstantiationException
                | InvocationTargetException
                | IllegalAccessException e) {
            e.printStackTrace();
        }

        return abstractElement;
    }
}
