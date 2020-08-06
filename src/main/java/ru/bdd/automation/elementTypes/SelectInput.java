package ru.bdd.automation.elementTypes;

import org.openqa.selenium.WebElement;
import ru.bdd.automation.core.AbstractElement;

public class SelectInput extends AbstractElement {
    public SelectInput(WebElement element) {
        super(element);
    }

    WebElement selectInputElement = super.element;
}
