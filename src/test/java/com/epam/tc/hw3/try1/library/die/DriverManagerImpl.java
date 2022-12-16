//package com.epam.tc.hw3.try1.library.die;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.util.concurrent.TimeUnit;
//
//public class DriverManagerImpl implements DriverService {
//
//    public DriverManagerImpl() {
//
//    }
//
//    private void setupChromeDriver() {
//        WebDriverManager.chromedriver()
//                .setup();
//    }
//
//    @Override
//    public WebDriver setupDriver() {
//        setupChromeDriver();
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        return webDriver;
//    }
//
//}


