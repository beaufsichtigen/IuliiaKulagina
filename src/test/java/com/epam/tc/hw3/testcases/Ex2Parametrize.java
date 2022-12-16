package com.epam.tc.hw3.testcases;

import com.epam.tc.hw3.library.data.DataProviders;
import com.epam.tc.hw3.library.pages.DifElementsPage;
import com.epam.tc.hw3.library.pages.Header;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ex2Parametrize extends BaseTest {


    @BeforeClass
    static void login() {
        //1. Open test site by URL - in parent class
        System.out.println("1. Open test site by URL - in parent class");
        Header header = new Header(testDriver);

        WebDriverWait wait = new WebDriverWait(testDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));
        //3. Perform login
        System.out.println("3. Perform login");
        header.login();

        // 5. Open through the header menu Service -> Different Elements Page

        header.getServiceButton().click();
        header.getDifElements().click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));

    }

    @Test(dataProvider = "DiffElementsCheckboxesTrue", dataProviderClass = DataProviders.class)
    public void checkboxesTrue(int parameter, String checkboxName, boolean isSelected) {
        SoftAssertions softly = new SoftAssertions();
        DifElementsPage difElementsPage = new DifElementsPage(testDriver);

        //Checking page is correct
        softly.assertThat(testDriver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");

        //9. Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        testDriver.navigate().refresh(); //clean all elements state

        difElementsPage.getAllCheckboxes().get(parameter).click();
        softly.assertThat(difElementsPage.getLastLog().getText())
                .as("Incorrect log text")
                .endsWith(checkboxName + ": condition changed to " + isSelected);

        softly.assertAll();

        //10. Close Browser - in parent class
    }

    @Test(dataProvider = "DiffElementsCheckboxesFalse", dataProviderClass = DataProviders.class)
    public void checkboxesFalse(int parameter, String checkboxName, boolean isSelected) {
        SoftAssertions softly = new SoftAssertions();
        DifElementsPage difElementsPage = new DifElementsPage(testDriver);

        //Checking page is correct
        softly.assertThat(testDriver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");


        //9. Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        testDriver.navigate().refresh(); //clean all elements state

        difElementsPage.getAllCheckboxes().get(parameter).click();
        difElementsPage.getAllCheckboxes().get(parameter).click();
        softly.assertThat(difElementsPage.getLastLog().getText())
                .as("Incorrect log text")
                .endsWith(checkboxName + ": condition changed to " + isSelected);

        softly.assertAll();

        //10. Close Browser - in parent class

    }

    //9. Assert that
    //• for radio button there is a log row and value is corresponded to the status of radio button

    @Test(dataProvider = "DiffElementsRadiobutton", dataProviderClass = DataProviders.class)
    public void radiobuttons(int parameter, String radiobuttonName) {
        SoftAssertions softly = new SoftAssertions();
        DifElementsPage difElementsPage = new DifElementsPage(testDriver);

        //Checking page is correct
        softly.assertThat(testDriver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");

        //9. Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        testDriver.navigate().refresh(); //clean all elements state

        difElementsPage.getAllradiobuttons().get(parameter).click();
        softly.assertThat(difElementsPage.getLastLog().getText())
                .as("Incorrect log text")
                .endsWith("metal: value changed to " + radiobuttonName);

        softly.assertAll();

        //10. Close Browser - in parent class

    }

    //9. Assert that
    //• for dropdown there is a log row and value is corresponded to the selected value.
    @Test(dataProvider = "DiffElementsDropdown", dataProviderClass = DataProviders.class)
    public void dropdown(int parameter, String dropdownName) {
        SoftAssertions softly = new SoftAssertions();
        Header header = new Header(testDriver);

        WebDriverWait wait = new WebDriverWait(testDriver, Duration.ofSeconds(10));

        //Checking page is correct
        softly.assertThat(testDriver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");

        DifElementsPage difElementsPage = new DifElementsPage(testDriver);

        //9. Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox

        difElementsPage.getAlldropDown().get(parameter).click();
        softly.assertThat(difElementsPage.getLastLog().getText())
                .as("Incorrect log text")
                .endsWith("Colors: value changed to " + dropdownName);
        softly.assertAll();

        //10. Close Browser - in parent class

    }
}
