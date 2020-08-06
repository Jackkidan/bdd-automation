package ru.bdd.automation.elementTypes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.bdd.automation.core.AbstractElement;

public class TextInput extends AbstractElement {
    public TextInput(WebElement element) {
        super(element);
    }

    WebElement textInputElement = super.element;

    @Override
    public void fillField(String value) {
        textInputElement.findElement(By.xpath("./input")).clear();
        textInputElement.findElement(By.xpath("./input")).sendKeys(value);
    }
}

