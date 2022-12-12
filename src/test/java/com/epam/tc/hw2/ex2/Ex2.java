package com.epam.tc.hw2.ex2;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Ex2 {


    WebDriver driver;

    @BeforeSuite
    static void setupAll() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeTest
    void setup() {
        driver = new ChromeDriver();
    }

    @Test
    //1. Open test site by URL
    public void openSite() throws InterruptedException {

        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.presenceOfElementLocated(By.id("jdi-frame-site")));
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
        String browserTitle = driver.getTitle();
        softly.assertThat(browserTitle).as("Incorrect browser title").isEqualTo("Home Page");

        //3. Perform login
        WebElement userIcon = driver.findElement(By.id("user-icon"));
        userIcon.click();
        WebElement login = driver.findElement(By.id("name"));
        login.sendKeys("Roman");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Jdi1234");
        WebElement enterButton = driver.findElement(By.id("login-button"));
        enterButton.click();

        //4. Assert Username is loggined
        WebElement userName = driver.findElement(By.id("user-name"));
        System.out.println(userName.getText());
        softly.assertThat(userName.getText()).as("Incorrect user name").isEqualTo("ROMAN IOVLEV");

        //5. Open through the header menu Service -> Different Elements Page

        //6. Select checkboxes Water, Wind

        //7. Select radio Selen

        //8. Select in dropdown Yellow

        //9. Assert that
//• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
//• for radio button there is a log row and value is corresponded to the status of radio button
//• for dropdown there is a log row and value is corresponded to the selected value.

        softly.assertAll();

        //10. Close Browser
        driver.quit();



    }
}