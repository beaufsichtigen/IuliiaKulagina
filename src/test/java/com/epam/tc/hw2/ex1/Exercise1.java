package com.epam.tc.hw2.ex1;

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




public class Exercise1 {


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
    public void ex1() {

        driver.manage()
                .window()
                .maximize();
        driver.navigate()
                .to("https://jdi-testing.github.io/jdi-light/index.html");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("jdi-frame-site")));
        SoftAssertions softly = new SoftAssertions();
        assertThat(driver.getCurrentUrl()).as("Incorrect page opened").isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");

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

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement homeButton = driver.findElement(By.cssSelector("a[href='index.html']"));
        System.out.println(homeButton.getText());
        assertThat(homeButton.getText()).as("Incorrect Home button name").isEqualTo("HOME");

        WebElement contactFormButton = driver.findElement(By.cssSelector("a[href='contacts.html']"));
        softly.assertThat(contactFormButton.getText())
                .as("Incorrect Contacts button name")
                .isEqualTo("CONTACT FORM");

        WebElement serviceButton = driver.findElement(By.cssSelector("a.dropdown-toggle"));
        softly.assertThat(serviceButton.getText()).as("Incorrect Service button name").isEqualTo("SERVICE");

        WebElement metalsColorsButton = driver.findElement(By.cssSelector("a[href='metals-colors.html']"));
        softly.assertThat(metalsColorsButton.getText())
                .as("Incorrect METALS & COLORS button name").isEqualTo("METALS & COLORS");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> icons = driver.findElements(By.cssSelector(".benefit-icon"));
        softly.assertThat(icons.size()).as("Number of images are " + icons.size() + " not 4").isEqualTo(4);
        softly.assertThat(icons).as("One or more image not displayed").isNotEmpty();
        //other way: assertTrue(isImageDisplayed);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> iconTexts = driver.findElements(By.cssSelector(".benefit-txt"));
        softly.assertThat(iconTexts.size())
                .as("Number of texts are " + iconTexts.size() + " not 4").isEqualTo(4);
        softly.assertThat(iconTexts.get(0).getText())
                .as("To include good...text differs")
                .isEqualTo("To include good practices\nand ideas from successful\nEPAM project");
        softly.assertThat(iconTexts.get(1).getText())
                .as("To be flexible...text differs").isEqualTo("To be flexible and\ncustomizable");
        softly.assertThat(iconTexts.get(2).getText())
                .as("To be multiplatform").isEqualTo("To be multiplatform");
        softly.assertThat(iconTexts.get(3).getText())
                .as("Already have good base...text differs")
                .isEqualTo("Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\nwish to get more…");

        //8. Assert that there is the iframe with “Frame Button” exist
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        int buttonInCurrentFrame = 0; //count buttons “Frame Button” in current frame
        int totalButtonsInFrames = 0; //counter of frames with button “Frame Button”
        for (int i = 0; i < size; i++) {

            //9. Switch to the iframe and check that there is “Frame Button” in the iframe
            driver.switchTo().frame(i);
            buttonInCurrentFrame = driver.findElements(By.cssSelector("input#frame-button")).size();

            if (buttonInCurrentFrame > 0) {
                totalButtonsInFrames = 0 + buttonInCurrentFrame;
                WebElement frameButton = driver
                        .findElement(By.cssSelector("input#frame-button"));
                softly.assertThat(frameButton.getAttribute("value"))
                        .as("Frame Button text differs")
                        .isEqualTo("Frame Button");
            }

            System.out.println(buttonInCurrentFrame);
            //softly.assertThat(buttonInCurrentFrame).as("No button “Frame Button”").isNotZero();

            //10. Switch to original window back
            driver.switchTo().defaultContent();
        }
        softly.assertThat(totalButtonsInFrames).as("Button not found").isNotZero();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sidebarItems = driver.findElements(By.cssSelector(".sidebar-menu > li"));
        softly.assertThat(sidebarItems.size())
                .as("Number of menu items " + sidebarItems.size() + " not 5").isEqualTo(5);
        softly.assertThat(sidebarItems.get(0)
                .getText()).as("Home menu text differs").isEqualTo("Home");
        softly.assertThat(sidebarItems.get(1)
                .getText()).as("Contact form text differs").isEqualTo("Contact form");
        softly.assertThat(sidebarItems.get(2)
                .getText()).as("Service text differs").isEqualTo("Service");
        softly.assertThat(sidebarItems.get(3)
                .getText()).as("Metals & Colors text differs").isEqualTo("Metals & Colors");
        softly.assertThat(sidebarItems.get(4)
                .getText()).as("Elements text packs").isEqualTo("Elements packs");

        softly.assertAll();

        //12. Close Browser
        driver.quit();

    }

}













