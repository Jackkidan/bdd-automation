package ru.bdd.automation.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.bdd.automation.utils.TimeOutUtil;

import java.util.List;

public class AbstractElement implements WebElement {
    public WebElement element;

    public AbstractElement(WebElement element) {
        this.element = element;
    }

    public static AbstractElement getField(String fieldName) {
        return FieldsExtractor.getField(fieldName);
    }

    public void fillField(String value) {
        element.sendKeys(value);
    }

    public void waitForVisible() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), TimeOutUtil.SHORT_IMPLICITLY_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForInvisible() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), TimeOutUtil.SHORT_IMPLICITLY_WAIT);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitToBeClickable() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), TimeOutUtil.SHORT_IMPLICITLY_WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToElement() {
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void handleVariable(String variable) {
        //TODO
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        element.clear();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return element.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return element.getScreenshotAs(target);
    }
}
