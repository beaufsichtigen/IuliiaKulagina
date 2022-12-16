package com.epam.tc.hw3.try1.testcases;

import com.epam.tc.hw3.try1.library.pages.DifElementsPage;
import com.epam.tc.hw3.try1.library.pages.Header;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Ex2 extends BaseTest {


    @Test
    //   1. Open test site by URL
    public void ex2() {

        SoftAssertions softly = new SoftAssertions();

        //1. Open test site by URL - in parent class
        Header header = new Header(testDriver);

        //2. Assert Browser title
        String browserTitle = testDriver.getTitle();
        softly.assertThat(browserTitle).as("Incorrect browser title").isEqualTo("Home Page");

        //3. Perform login
        header.login();
        assertThat(testDriver.getCurrentUrl()).as("Incorrect page opened").isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");

        //4. Assert Username is loggined
        softly.assertThat(header.getUserNameText()).as("Incorrect user name").isEqualTo("ROMAN IOVLEV");


        //5. Open through the header menu Service -> Different Elements Page
        header.getServiceButton().click();
        header.getDifElements().click();

        WebDriverWait wait = new WebDriverWait(testDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));
        assertThat(testDriver.getCurrentUrl()).as("Incorrect page opened").isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");

      //6. Select checkboxes Water, Wind
        DifElementsPage difElementsPage = new DifElementsPage(testDriver);
        difElementsPage.clickWater();
        difElementsPage.clickWind();

        assertThat(difElementsPage.getCheckboxWater().isEnabled()).as("Check box 'Water' was not enabled").isEqualTo(false);
        assertThat(difElementsPage.getCheckboxWater().isEnabled()).as("Check box 'Wind' was not enabled").isEqualTo(false);

        //7. Select radio Selen
        difElementsPage.clickSelen();
        assertThat(difElementsPage.getRadioBtnSelen().isEnabled()).as("Incorrect radio button state").isEqualTo(false);
//
//        //8. Select in dropdown Yellow
//        WebElement dropDownColors = driver.findElement(By.className("colors"));
//        dropDownColors.click();
//        WebElement dropDownYellow = driver.findElement(By.xpath("//option[text()='Yellow']"));
//        dropDownYellow.click();
//
//        assertThat(dropDownYellow.isSelected()).as("Incorrect drop down state").isEqualTo(true);
//
//        //9. Assert that
//        driver.navigate().refresh(); //clean all elements state
//        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
//        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
//        int checkboxesNumber = checkboxes.size();
//        for (int i = 0; i < checkboxesNumber; i++) {
//            checkboxes.get(i).click();
//            String checkboxName = checkboxes.get(i).getText();
//            WebElement log = driver
//                    .findElement(By.cssSelector(".logs :first-child"));
//            System.out.println(log.getText());
//            softly.assertThat(log.getText())
//                    .as("Incorrect log text")
//                    .endsWith(checkboxName + ": condition changed to " + checkboxes.get(i).isSelected());
//
//            checkboxes.get(i).click();
//            WebElement log2 = driver.findElement(By.cssSelector(".logs :first-child"));
//            System.out.println(log2.getText());
//            softly.assertThat(log2.getText())
//                    .as("Incorrect log text")
//                    .endsWith(checkboxName + ": condition changed to " + checkboxes.get(i).isSelected());
//        }
//        //• for radio button there is a log row and value is corresponded to the status of radio button
//        List<WebElement> radiobuttons = driver.findElements(By.className("label-radio"));
//
//        int radiobuttonsNumber = radiobuttons.size();
//        for (int i = 0; i < radiobuttonsNumber; i++) {
//            radiobuttons.get(i).click();
//
//            String radiobuttonName = radiobuttons.get(i).getText();
//            WebElement log = driver.findElement(By.cssSelector(".logs :first-child"));
//            System.out.println(log.getText());
//            softly.assertThat(log.getText())
//                    .as("Incorrect log text").endsWith("metal: value changed to " + radiobuttonName);
//        }
//
//        //• for dropdown there is a log row and value is corresponded to the selected value.
//
//        List<WebElement> dropDown = driver
//                .findElements(By.cssSelector(".colors>select>option"));
//
//        int dropDownNumber = dropDown.size();
//        for (int i = 1; i < dropDownNumber; i++) {
//            dropDown.get(i).click();
//            String dropDownName = dropDown.get(i).getText();
//            WebElement log = driver.findElement(By.cssSelector(".logs :first-child"));
//            System.out.println(log.getText());
//            softly.assertThat(log.getText())
//                    .as("Incorrect log text")
//                    .endsWith("Colors: value changed to " + dropDownName);
//        }
//
//        dropDown.get(0).click();
//        String dropDownName = dropDown.get(0).getText();
//        WebElement log = driver.findElement(By.cssSelector(".logs :first-child"));
//        System.out.println(log.getText());
//        softly.assertThat(log.getText())
//                .as("Incorrect log text")
//                .endsWith("Colors: value changed to " + dropDownName);
//
        softly.assertAll();

        //10. Close Browser

    }
}
