package ru.bdd.automation.elementTypes;

import org.openqa.selenium.WebElement;
import ru.bdd.automation.core.AbstractElement;

public class StaticText extends AbstractElement {
    public StaticText(WebElement element) {
        super(element);
    }

    WebElement staticTextElement = super.element;
}
