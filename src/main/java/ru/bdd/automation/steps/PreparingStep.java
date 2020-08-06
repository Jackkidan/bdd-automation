package ru.bdd.automation.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.bdd.automation.core.DriverManager;
import ru.yandex.qatools.allure.annotations.Attachment;

public class PreparingStep {

    @Before
    public static void setUp() throws Exception {
        DriverManager.initDriver();
    }


    @After
    public static void tearDown() throws Exception {
        DriverManager.getDriver().quit();
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
