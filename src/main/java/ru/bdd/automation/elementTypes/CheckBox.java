package ru.bdd.automation.elementTypes;

import org.openqa.selenium.WebElement;
import ru.bdd.automation.core.AbstractElement;

public class CheckBox extends AbstractElement {
    public CheckBox(WebElement element) {
        super(element);
    }

    WebElement checkBoxElement = super.element;
}
