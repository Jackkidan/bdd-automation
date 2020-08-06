package ru.bdd.automation.elementTypes;

import org.openqa.selenium.WebElement;
import ru.bdd.automation.core.AbstractElement;

public class RadioButton extends AbstractElement {
    public RadioButton(WebElement element) {
        super(element);
    }

    WebElement radioButtonElement = super.element;
}
