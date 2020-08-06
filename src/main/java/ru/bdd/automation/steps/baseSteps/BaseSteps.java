package ru.bdd.automation.steps.baseSteps;

import org.junit.Assert;
import ru.bdd.automation.core.AbstractElement;
import ru.bdd.automation.core.AbstractPage;

public class BaseSteps {

    public void pageShouldBeLoaded(String page) {
        Assert.assertTrue("Failed to load page: " + page, AbstractPage.isPageLoad(page));
    }

    public void fillField(String fieldName, String value) {
        AbstractElement.getField(fieldName).fillField(value);
    }

    public void clickField(String fieldName) {
        AbstractElement element = AbstractElement.getField(fieldName);
        element.waitToBeClickable();
        element.click();
    }

    public void waitForVisible(String fieldName) {
        AbstractElement.getField(fieldName).waitForVisible();
    }

    public void waitForInvisible(String fieldName) {
        AbstractElement.getField(fieldName).waitForInvisible();
    }

    public void clearField(String fieldName) {
        AbstractElement.getField(fieldName).clear();
    }

    public void checkValue(String fieldName, String expectedValue) {
        AbstractElement element = AbstractElement.getField(fieldName);
        String actualText = element.getText().trim();
        Assert.assertTrue(String.format("expected \"%s\" but was \"%s\"", expectedValue, actualText), expectedValue.equals(actualText));
    }
}
