package com.epam.tc.hw3.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    static WebDriver testDriver;

    public static String getBaseURL() {
        return baseURL;
    }

    private static final String baseURL = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeSuite
    public static void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    static void setupAll() {
        testDriver = new ChromeDriver();
        testDriver.manage().window().maximize();
        testDriver.get(baseURL);
    }

    @AfterClass
    public static void tearDownDriver() {
        if (testDriver != null) {
            testDriver.quit();
        }
    }
}
