package ru.bdd.automation.elementTypes;

import org.openqa.selenium.WebElement;
import ru.bdd.automation.core.AbstractElement;

public class Button extends AbstractElement {

    public Button(WebElement element) {
        super(element);
    }

    WebElement buttonElement = super.element;

    @Override
    public void fillField(String value) {
        buttonElement.click();
    }

}
