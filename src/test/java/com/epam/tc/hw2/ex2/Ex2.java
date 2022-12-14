package com.epam.tc.hw2.ex2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


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
    public void ex2() {

        driver.manage().window().maximize();
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("jdi-frame-site")));
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
        WebElement serviceButton = driver.findElement(By.cssSelector("a.dropdown-toggle"));
        serviceButton.click();
        WebElement difElements = driver.findElement(By.cssSelector("a[href='different-elements.html']"));
        difElements.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));

        assertThat(driver.getCurrentUrl()).as("Incorrect page opened").isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");

        //6. Select checkboxes Water, Wind
        WebElement checkboxWater = driver.findElement(By.xpath("//*[contains(text()[normalize-space(.)],'Water')]"));
        checkboxWater.click();
        WebElement checkboxWind = driver.findElement(By.xpath("//*[contains(text()[normalize-space(.)],'Wind')]"));
        checkboxWind.click();

        assertThat(checkboxWater.isEnabled()).as("Check box 'Water' was not enabled").isEqualTo(true);
        assertThat(checkboxWind.isEnabled()).as("Check box 'Wind' was not enabled").isEqualTo(true);

        //7. Select radio Selen
        WebElement radioBtnSelen = driver.findElement(By.xpath("//*[contains(text()[normalize-space(.)],'Selen')]"));
        radioBtnSelen.click();

        assertThat(radioBtnSelen.isEnabled()).as("Incorrect radio button state").isEqualTo(true);

        //8. Select in dropdown Yellow
        WebElement dropDownColors = driver.findElement(By.className("colors"));
        dropDownColors.click();
        WebElement dropDownYellow = driver.findElement(By.xpath("//option[text()='Yellow']"));
        dropDownYellow.click();

        assertThat(dropDownYellow.isSelected()).as("Incorrect drop down state").isEqualTo(true);

        //9. Assert that
        driver.navigate().refresh(); //clean all elements state
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        int checkboxesNumber = checkboxes.size();
        for (int i = 0; i < checkboxesNumber; i++) {
            checkboxes.get(i).click();
            String checkboxName = checkboxes.get(i).getText();
            WebElement log = driver
                    .findElement(By.cssSelector(".logs :first-child"));
            System.out.println(log.getText());
            softly.assertThat(log.getText())
                    .as("Incorrect log text")
                    .endsWith(checkboxName + ": condition changed to " + checkboxes.get(i).isSelected());

            checkboxes.get(i).click();
            WebElement log2 = driver.findElement(By.cssSelector(".logs :first-child"));
            System.out.println(log2.getText());
            softly.assertThat(log2.getText())
                    .as("Incorrect log text")
                    .endsWith(checkboxName + ": condition changed to " + checkboxes.get(i).isSelected());
        }
        //• for radio button there is a log row and value is corresponded to the status of radio button
        List<WebElement> radiobuttons = driver.findElements(By.className("label-radio"));

        int radiobuttonsNumber = radiobuttons.size();
        for (int i = 0; i < radiobuttonsNumber; i++) {
            radiobuttons.get(i).click();

            String radiobuttonName = radiobuttons.get(i).getText();
            WebElement log = driver.findElement(By.cssSelector(".logs :first-child"));
            System.out.println(log.getText());
            softly.assertThat(log.getText())
                    .as("Incorrect log text").endsWith("metal: value changed to " + radiobuttonName);
        }

        //• for dropdown there is a log row and value is corresponded to the selected value.

        List<WebElement> dropDown = driver
                .findElements(By.cssSelector(".colors>select>option"));

        int dropDownNumber = dropDown.size();
        for (int i = 1; i < dropDownNumber; i++) {
            dropDown.get(i).click();
            String dropDownName = dropDown.get(i).getText();
            WebElement log = driver.findElement(By.cssSelector(".logs :first-child"));
            System.out.println(log.getText());
            softly.assertThat(log.getText())
                    .as("Incorrect log text")
                    .endsWith("Colors: value changed to " + dropDownName);
        }

        dropDown.get(0).click();
        String dropDownName = dropDown.get(0).getText();
        WebElement log = driver.findElement(By.cssSelector(".logs :first-child"));
        System.out.println(log.getText());
        softly.assertThat(log.getText())
                .as("Incorrect log text")
                .endsWith("Colors: value changed to " + dropDownName);

        softly.assertAll();

        //10. Close Browser
        driver.quit();
    }
}
