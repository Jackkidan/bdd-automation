package ru.bdd.automation.core;

import lombok.Getter;
import lombok.Setter;
import ru.bdd.automation.models.CSVPageModel;

public abstract class AbstractPage {

    @Getter
    @Setter
    private static String curentPage = null;
    private static AbstractElement element;

    public static boolean isPageLoad(String page) {
        element = FieldsExtractor.getField(
                CSVPageModel.modelsMap.get(page)
        );
        element.waitForVisible();
        return element.isDisplayed();
    }


}

