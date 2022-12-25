package com.epam.tc.hw4.testcases;

import com.epam.tc.hw4.library.steps.Steps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    WebDriver testDriver;

    public static String getBaseURL() {
        return baseURL;
    }

    protected Steps step;

    private static final String baseURL = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeSuite
    public static void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setupAll() {
        testDriver = new ChromeDriver();
        testDriver.manage().window().maximize();
        testDriver.get(baseURL);
        step = new Steps(testDriver);
    }

    @BeforeClass
    public void screenshotSetup(ITestContext context) {
        context.setAttribute("driver", testDriver);
    }

    @AfterMethod
    public void tearDownDriver() {
        if (testDriver != null) {
            testDriver.quit();
        }
    }
}
