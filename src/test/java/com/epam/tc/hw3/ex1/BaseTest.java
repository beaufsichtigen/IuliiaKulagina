package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.driverutils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    static WebDriver webDriver;

    private String baseURL = "https://jdi-testing.github.io/jdi-light/index.html";


    @BeforeClass
    public static void prepareToTest() {
        webDriver = new DriverManager().setupDriverMaximize();

    }

    @BeforeTest
    public void openLink() {
    webDriver.navigate().to(baseURL);}

    @AfterTest
    public static void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
