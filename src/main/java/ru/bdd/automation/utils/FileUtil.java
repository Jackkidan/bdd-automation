package ru.bdd.automation.utils;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;

import static java.lang.String.*;

public class FileUtil {
    private String FILE_NOT_FOUND_MESSAGE = "file %s not found in directory %s";
    Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public void uploadFile(WebElement element, String fileName) {
        element.sendKeys(new File(format("./TestData/Files/%s", fileName)).getAbsolutePath());
        logger.info(format("Загружен файл %s", fileName));
    }

    public void checkFile(String dir, String fileName) {
        String home = System.getProperty("user.home");
        File file = new File(home + "/" + dir + "/" + fileName);
        file.exists();
        Assert.assertTrue(format(FILE_NOT_FOUND_MESSAGE, fileName, dir), file.exists());
        if (file.exists() && file.isFile()) {
            logger.info(format("file %s exists in directory %s", fileName, dir));
        } else {
            try {
                Assert.fail();
                throw new FileNotFoundException(format(FILE_NOT_FOUND_MESSAGE, fileName, dir));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteFile(String dir, String fileName) {
        String home = System.getProperty("user.home");
        File file = new File(home + "/" + dir + "/" + fileName);
        Assert.assertTrue(format(FILE_NOT_FOUND_MESSAGE, fileName, dir), file.exists());
        if (file.exists() && file.isFile()) {
            file.delete();
            logger.info(format("file %s removed from directory %s", fileName, dir));
        } else {
            try {
                Assert.fail();
                throw new FileNotFoundException(format(FILE_NOT_FOUND_MESSAGE, fileName, dir));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
