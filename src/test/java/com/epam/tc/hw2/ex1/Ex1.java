package com.epam.tc.hw2.ex1;

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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

       //3. Perform login username: Roman pass: Jdi1234
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

       //5. Assert that there are 4 items on the header section are displayed and they have proper texts
       WebElement homeButton = driver.findElement(By.cssSelector("a[href='index.html']"));
       System.out.println(homeButton.getText());
       assertThat(homeButton.getText()).as("Incorrect Home button name").isEqualTo("HOME");

       WebElement contactFormButton = driver.findElement(By.cssSelector("a[href='contacts.html']"));
       softly.assertThat(contactFormButton.getText()).as("Incorrect Contacts button name").isEqualTo("CONTACT FORM");

       //WebElement serviceButton = driver.findElement(By.cssSelector("a[href='contacts.html']"));
       //softly.assertThat(serviceButton.getText()).as("Incorrect Home button name").isEqualTo("SERVICE");

       WebElement metalsColorsButton = driver.findElement(By.cssSelector("a[href='metals-colors.html']"));
       softly.assertThat(metalsColorsButton.getText()).as("Incorrect METALS & COLORS button name").isEqualTo("METALS & COLORS");


       //6. Assert that there are 4 images on the Index Page and they are displayed
       //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
       //8. Assert that there is the iframe with “Frame Button” exist
       //9. Switch to the iframe and check that there is “Frame Button” in the iframe
       //10. Switch to original window back
       //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
       //12. Close Browser




       softly.assertAll();
       //Thread.sleep(10000);

   }
}













