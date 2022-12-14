package com.epam.tc.hw3.driverutils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private void setupChromeDriver() {
        WebDriverManager.chromedriver()
                .setup();
    }

//    public WebDriver setupDriver() {
//        setupChromeDriver();
//        WebDriver webDriver = new ChromeDriver();
//        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        return webDriver;
//    }

    public WebDriver setupDriverMaximize() {
        setupChromeDriver();
        WebDriver webDriver = new ChromeDriver();

        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage()
                .window()
                .maximize();
        return webDriver;
    }

    //    WebDriver driver;
//
//    @BeforeSuite
//    static void setupAll() {
//        WebDriverManager.chromedriver().setup();
//
//    }
//
//    @BeforeTest
//    void setup() {
//        driver = new ChromeDriver();
//    }
//
//
//    @Test
//    //1. Open test site by URL
//    public void ex1() {
//
//        driver.manage()
//                .window()
//                .maximize();
//        driver.navigate()
//                .to("https://jdi-testing.github.io/jdi-light/index.html");
//        new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("jdi-frame-site")));
//        SoftAssertions softly = new SoftAssertions();
//        assertThat(driver.getCurrentUrl()).as("Incorrect page opened").isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");



}
