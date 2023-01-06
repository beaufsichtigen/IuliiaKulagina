package com.epam.tc.hw2.ex2;

import com.epam.tc.hw2.BaseTest;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Exercise2 extends BaseTest {


    @Test
    //1. Open test site by URL
    public void checkDiffElementsPage() {

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(driver.getCurrentUrl()).as("Incorrect page opened").isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");

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

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));

        softly.assertThat(driver.getCurrentUrl()).as("Incorrect page opened").isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");

        //6. Select checkboxes Water, Wind
        WebElement checkboxWater = driver.findElement(By.xpath("//*[contains(text()[normalize-space(.)],'Water')]"));
        checkboxWater.click();
        WebElement checkboxWind = driver.findElement(By.xpath("//*[contains(text()[normalize-space(.)],'Wind')]"));
        checkboxWind.click();

        softly.assertThat(checkboxWater.isEnabled()).as("Check box 'Water' was not enabled").isTrue();
        softly.assertThat(checkboxWind.isEnabled()).as("Check box 'Wind' was not enabled").isTrue();

        //7. Select radio Selen
        WebElement radioBtnSelen = driver.findElement(By.xpath("//*[contains(text()[normalize-space(.)],'Selen')]"));
        radioBtnSelen.click();

        softly.assertThat(radioBtnSelen.isEnabled()).as("Incorrect radio button state").isTrue();

        //8. Select in dropdown Yellow
        WebElement dropDownColors = driver.findElement(By.className("colors"));
        dropDownColors.click();
        WebElement dropDownYellow = driver.findElement(By.xpath("//option[text()='Yellow']"));
        dropDownYellow.click();

        softly.assertThat(dropDownYellow.isSelected()).as("Incorrect drop down state").isTrue();

        //9. Assert that
        driver.navigate().refresh(); //clean all elements state
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        Iterator<WebElement> checkboxesIterator = checkboxes.iterator();
        for (WebElement checkbox : checkboxes) {
            checkbox.click();
            String checkboxName = checkbox.getText();
            WebElement log = driver
                    .findElement(By.cssSelector(".logs :first-child"));
            System.out.println(log.getText());
            softly.assertThat(log.getText())
                    .as("Incorrect log text")
                    .endsWith(checkboxName + ": condition changed to " + checkbox.isSelected());

            checkbox.click();
            WebElement log2 = driver.findElement(By.cssSelector(".logs :first-child"));
            System.out.println(log2.getText());
            softly.assertThat(log2.getText())
                    .as("Incorrect log text")
                    .endsWith(checkboxName + ": condition changed to " + checkbox.isSelected());

        }

        //• for radio button there is a log row and value is corresponded to the status of radio button
        List<WebElement> radiobuttons = driver.findElements(By.className("label-radio"));
        Iterator<WebElement> radiobuttonsIterator = radiobuttons.iterator();
        for (WebElement radiobutton : radiobuttons) {
            radiobutton.click();
            WebElement log = driver.findElement(By.cssSelector(".logs :first-child"));
            System.out.println(log.getText());
            softly.assertThat(log.getText())
                    .as("Incorrect log text").endsWith("metal: value changed to " + radiobutton.getText());
        }


        //• for dropdown there is a log row and value is corresponded to the selected value.

        List<WebElement> dropDown = driver
                .findElements(By.cssSelector(".colors>select>option"));
        dropDown.get(2).click(); //otherwise the first click doesn't work
        Iterator<WebElement> dropDownIterator = dropDown.iterator();
        for (WebElement dropDownElement : dropDown) {
            dropDownElement.click();
            WebElement log = driver.findElement(By.cssSelector(".logs :first-child"));
            System.out.println(log.getText());
            softly.assertThat(log.getText())
                    .as("Incorrect log text")
                    .endsWith("Colors: value changed to " + dropDownElement.getText());
        }

        softly.assertAll();

    }
}
