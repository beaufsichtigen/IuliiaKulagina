package com.epam.tc.hw5.utils;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

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
        }
    }

}
