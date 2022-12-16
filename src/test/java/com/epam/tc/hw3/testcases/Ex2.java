package com.epam.tc.hw3.testcases;

import com.epam.tc.hw3.library.pages.DifElementsPage;
import com.epam.tc.hw3.library.pages.Header;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class Ex2 extends BaseTest {

    //1. Open test site by URL - in parent class

    @Test
    public void ex2() {

        SoftAssertions softly = new SoftAssertions();


        Header header = new Header(testDriver);

        //2. Assert Browser title
        String browserTitle = testDriver.getTitle();
        softly.assertThat(browserTitle).as("Incorrect browser title").isEqualTo("Home Page");

        //3. Perform login
        header.login();
        softly.assertThat(testDriver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");

        //4. Assert Username is loggined
        softly.assertThat(header.getUserNameText())
                .as("Incorrect user name")
                .isEqualTo("ROMAN IOVLEV");


        //5. Open through the header menu Service -> Different Elements Page
        header.getServiceButton().click();
        header.getDifElements().click();

        WebDriverWait wait = new WebDriverWait(testDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));
        softly.assertThat(testDriver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");

        //6. Select checkboxes Water, Wind
        DifElementsPage difElementsPage = new DifElementsPage(testDriver);
        difElementsPage.clickWater();
        difElementsPage.clickWind();

        softly.assertThat(difElementsPage.getCheckboxWater()
                .isEnabled()).as("Check box 'Water' was not enabled")
                .isEqualTo(true);
        softly.assertThat(difElementsPage.getCheckboxWater()
                .isEnabled()).as("Check box 'Wind' was not enabled")
                .isEqualTo(true);

        //7. Select radio Selen
        difElementsPage.clickSelen();
        softly.assertThat(difElementsPage.getRadioBtnSelen()
                .isEnabled()).as("Incorrect radio button state")
                .isEqualTo(true);

        //8. Select in dropdown Yellow

        difElementsPage.chooseYellow();
        softly.assertThat(difElementsPage.getDropDownYellow()
                .isSelected()).as("Incorrect drop down state")
                .isEqualTo(true);

        softly.assertAll();

        //10. Close Browser in parent class

    }
}
