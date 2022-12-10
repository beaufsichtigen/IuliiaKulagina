package com.epam.tc.hw2.ex1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Ex1 {


    WebDriver driver;

    @BeforeSuite
    static void setupAll() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeTest
    void setup() {
            driver = new ChromeDriver();
        }

@AfterTest
void teardown() {
    driver.quit();
}


    @Test

    //1. Open test site by URL
    //2. Assert Browser title
    //3. Perform login
    //4. Assert Username is loggined
    //5. Assert that there are 4 items on the header section are displayed and they have proper texts
    //6. Assert that there are 4 images on the Index Page and they are displayed
    //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
    //8. Assert that there is the iframe with “Frame Button” exist
    //9. Switch to the iframe and check that there is “Frame Button” in the iframe
    //10. Switch to original window back
    //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
    //12. Close Browser


    public void Ex1() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.epam.com");

        driver.close();
    }
}







