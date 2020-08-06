package ru.bdd.automation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.bdd.automation.utils.TimeOutUtil;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver driver;
    private static Properties properties = PropertiesHandler.getInstance().getProperties();
    private static String baseUrl;
    private static String OS = System.getProperty("os.name").toLowerCase();
    private static Logger logger = LoggerFactory.getLogger(DriverManager.class);

    public static void initDriver() {
        String driverPath = null;
        if (isWindows()) {
            driverPath = "src/main/resources/drivers/chrome/chromedriver.exe";
        } else if (isMac()) {
            driverPath = "src/main/resources/drivers/chrome/chromedriver-mac";
        }

        switch (properties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", driverPath);
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", driverPath);
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", driverPath);
                driver = new ChromeDriver();
        }

        baseUrl = properties.getProperty("app.url");
        logger.info(baseUrl);
        driver.manage().timeouts().implicitlyWait(TimeOutUtil.getMIDDLE_IMPLICITLY_WAIT(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    public static WebDriver getDriver() {
        return driver;
    }

    private static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    private static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    private DriverManager() {}

}
