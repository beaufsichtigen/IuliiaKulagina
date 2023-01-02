package com.epam.tc.hw5.utils;

import java.util.Objects;
import org.openqa.selenium.WebDriver;

public class DriverManagerUtil {

    private static WebDriver driver;

    public static WebDriver setupDriver() {
        if (Objects.isNull(driver)) {
            driver = WebDriverFactory.getWebDriver("chrome");
        }
        return driver;
    }

    public static void tearDownDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
