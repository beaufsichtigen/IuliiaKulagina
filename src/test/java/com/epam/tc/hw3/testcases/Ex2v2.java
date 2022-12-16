package com.epam.tc.hw3.testcases;

import com.epam.tc.hw3.library.pages.DifElementsPage;
import com.epam.tc.hw3.library.pages.Header;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Ex2v2 extends BaseTest {


    //1. Open test site by URL - in parent class

    @Test(priority = 0)
    public void titleAssert() {
        //2. Assert Browser title
        SoftAssertions softly = new SoftAssertions();
        String browserTitle = testDriver.getTitle();
        softly.assertThat(browserTitle).as("Incorrect browser title").isEqualTo("Home Page");
        softly.assertAll();
    }

    @Test(priority = 1)
    public void loginAssert() {
        SoftAssertions softly = new SoftAssertions();
        Header header = new Header(testDriver);

        //3. Perform login
        header.login();
        softly.assertThat(testDriver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");

        //4. Assert Username is loggined
        softly.assertThat(header.getUserNameText())
                .as("Incorrect user name")
                .isEqualTo("ROMAN IOVLEV");

        softly.assertAll();
    }

    @Test(priority = 2)
    public void openDiffElementsAssert() {

        Header header = new Header(testDriver);
        //5. Open through the header menu Service -> Different Elements Page
        header.getServiceButton().click();
        header.getDifElements().click();

        WebDriverWait wait = new WebDriverWait(testDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(testDriver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");

        softly.assertAll();
    }

    @Test(priority = 3)
    public void checkboxSelectAssert() throws InterruptedException {

        //6. Select checkboxes Water, Wind
        DifElementsPage difElementsPage = new DifElementsPage(testDriver);
        Thread.sleep(3000);
        difElementsPage.clickWater();
        difElementsPage.clickWind();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(difElementsPage.getCheckboxWater()
                .isEnabled()).as("Check box 'Water' was not enabled")
                .isEqualTo(true);
        softly.assertThat(difElementsPage.getCheckboxWater()
                .isEnabled()).as("Check box 'Wind' was not enabled")
                .isEqualTo(true);

        softly.assertAll();
    }


    @Test(priority = 3)
    public void radioSelenAssert() {
        SoftAssertions softly = new SoftAssertions();
        DifElementsPage difElementsPage = new DifElementsPage(testDriver);

        //7. Select radio Selen
        difElementsPage.clickSelen();
        softly.assertThat(difElementsPage.getRadioBtnSelen()
                .isEnabled()).as("Incorrect radio button state")
                .isEqualTo(true);

        softly.assertAll();
    }


    @Test(priority = 3)
    public void yellowDropDownAssert() {

        DifElementsPage difElementsPage = new DifElementsPage(testDriver);
        //8. Select in dropdown Yellow

        difElementsPage.chooseYellow();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(difElementsPage.getDropDownYellow()
                .isSelected()).as("Incorrect drop down state")
                .isEqualTo(true);

        softly.assertAll();
    }
    //10. Close Browser in parent class

}
