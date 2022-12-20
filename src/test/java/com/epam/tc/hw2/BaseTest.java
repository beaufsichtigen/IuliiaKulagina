package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    public static WebDriver driver;

    public static String getBaseURL() {
        return baseURL;
    }

    private static final String baseURL = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeClass
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("jdi-frame-site")));

    }


    @AfterClass
    public static void tearDownDriver()  {
        if (driver != null) {
            driver.quit();
        }
    }
}
