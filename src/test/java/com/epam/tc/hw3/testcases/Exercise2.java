package com.epam.tc.hw3.testcases;

import com.epam.tc.hw3.library.pages.DifElementsPage;
import com.epam.tc.hw3.library.pages.Header;
import com.epam.tc.hw3.library.utils.GetProperties;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Exercise2 extends BaseTest {

    //1. Open test site by URL - in parent class
    @Test
    public void exercise2() {
        //2. Assert Browser title
        SoftAssertions softly = new SoftAssertions();
        String browserTitle = testDriver.getTitle();
        softly.assertThat(browserTitle).as("Incorrect browser title").isEqualTo("Home Page");

        //3. Perform login
        Header header = PageFactory.initElements(testDriver, Header.class);
        GetProperties getProperties = new GetProperties();
        header.login(getProperties.getUsernameProp(), getProperties.getPasswordProp());
        softly.assertThat(testDriver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");

        //4. Assert Username is loggined
        softly.assertThat(header.getUserNameText())
                .as("Incorrect user name")
                .isEqualTo(getProperties.getUsernameTextProp());

        //5. Open through the header menu Service -> Different Elements Page
        header.getServiceButton().click();
        header.getDifElements().click();

        WebDriverWait wait = new WebDriverWait(testDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));
        softly.assertThat(testDriver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");

        //6. Select checkboxes Water, Wind
        DifElementsPage difElementsPage = PageFactory.initElements(testDriver, DifElementsPage.class);
        difElementsPage.clickWebElement(difElementsPage.getCheckboxWater());
        difElementsPage.clickWebElement(difElementsPage.getCheckboxWater());
        softly.assertThat(difElementsPage.getCheckboxWater()
                        .isEnabled()).as("Check box 'Water' was not enabled")
                .isTrue();
        softly.assertThat(difElementsPage.getCheckboxWater()
                        .isEnabled()).as("Check box 'Wind' was not enabled")
                .isTrue();

        //7. Select radio Selen
        difElementsPage.clickWebElement(difElementsPage.getRadioBtnSelen());
        softly.assertThat(difElementsPage.getRadioBtnSelen()
                        .isEnabled()).as("Incorrect radio button state").isTrue();

        //8. Select in dropdown Yellow
        difElementsPage.chooseFromClosedDropdown(difElementsPage.getDropDownYellow());
        softly.assertThat(difElementsPage.getDropDownYellow()
                        .isSelected()).as("Incorrect drop down state").isTrue();

        //9. Assert that
        testDriver.navigate().refresh(); //clean all elements state
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        for (WebElement checkbox : difElementsPage.getAllCheckboxes()) {
            checkbox.click();
            String checkboxName = checkbox.getText();
            System.out.println(difElementsPage.getLastLog().getText());
            softly.assertThat(difElementsPage.getLastLog().getText())
                    .as("Incorrect log text")
                    .endsWith(checkboxName + ": condition changed to " + checkbox.isSelected());

            checkbox.click();
            System.out.println(difElementsPage.getLastLog().getText());
            softly.assertThat(difElementsPage.getLastLog().getText())
                    .as("Incorrect log text")
                    .endsWith(checkboxName + ": condition changed to " + checkbox.isSelected());
        }

        //• for radio button there is a log row and value is corresponded to the status of radio button
        for (WebElement radiobutton : difElementsPage.getAllradiobuttons()) {
            radiobutton.click();
            System.out.println(difElementsPage.getLastLog().getText());
            softly.assertThat(difElementsPage.getLastLog().getText())
                    .as("Incorrect log text").endsWith("metal: value changed to " + radiobutton.getText());
        }

        //• for dropdown there is a log row and value is corresponded to the selected value.
        difElementsPage.chooseFromClosedDropdown(difElementsPage.getDropDownYellow());
        for (WebElement dropDownElement : difElementsPage.getAlldropDown()) {
            dropDownElement.click();
            System.out.println(difElementsPage.getLastLog()
                    .getText());
            softly.assertThat(difElementsPage.getLastLog().getText())
                    .as("Incorrect log text")
                    .endsWith("Colors: value changed to " + dropDownElement.getText());
        }
        softly.assertAll();
    }
    //10. Close Browser in parent class
}
