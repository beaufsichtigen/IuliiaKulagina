package com.epam.tc.hw5.steps;

import static com.epam.tc.hw4.pages.DifElementsPage.Color.Yellow;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferentElementsPageSteps extends AbstractStep {
    @When("I open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        anyPage.getHeader().getServiceButton().click();
        anyPage.getHeader().getDifElements().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));
    }

    @When("Select checkbox {string}")
    public void selectCheckbox(String element) {
        difElementsPage.clickCheckbox(element);
    }

    @When("Select radio {string}")
    public void selectRadio(String metal) {
        difElementsPage.clickWebElement(difElementsPage.getRadioBtn(metal));
    }

    @When("Select in dropdown {string}")
    public void selectInDropdown(String color) {
        difElementsPage.chooseFromClosedDropdown(color);
    }

    @Then("I see {string} element is checked")
    public void elementIsChecked(String element) {
        softly.assertThat(difElementsPage.getCheckbox(element).isEnabled())
                .as("Check box " + element + " was not enabled")
                .isTrue();
        softly.assertAll();
    }

    @Then("I see {string} metal is checked")
    public void metalIsChecked(String metal) {
        softly.assertThat(difElementsPage.getRadioBtn(metal)
                .isEnabled()).as("Incorrect radio button state").isTrue();
        softly.assertAll();
    }

    @Then("I see {string} color is selected")
    public void colorIsSelected(String color) {
        softly.assertThat(difElementsPage.getDropDown(color)
                .isSelected()).as("Incorrect drop down state").isTrue();
        softly.assertAll();
    }

    @Then("I see log line of checkbox {string} with {string}")
    public void logLineCheck(String checkboxName, String value) {
        softly.assertThat(difElementsPage.getLastLogText())
                .as("Incorrect log text")
                .endsWith(checkboxName + ": condition changed to " + value);
        softly.assertAll();
    }

    @Then("I see an individual log row and value is corresponded to the status of checkbox")
    public void checkboxLogLineIsCorrect() {
        for (WebElement checkbox : difElementsPage.getAllCheckboxes()) {
            checkbox.click();
            String checkboxName = checkbox.getText();
            System.out.println(difElementsPage.getLastLogText());
            softly.assertThat(difElementsPage.getLastLogText())
                    .as("Incorrect log text")
                    .endsWith(checkboxName + ": condition changed to " + checkbox.isSelected());

            checkbox.click();
            System.out.println(difElementsPage.getLastLogText());
            softly.assertThat(difElementsPage.getLastLogText())
                    .as("Incorrect log text")
                    .endsWith(checkboxName + ": condition changed to " + checkbox.isSelected());
        }
        softly.assertAll();
    }

    @Then("I see an individual log row and value is corresponded to the status of radio button")
    public void radioButtonLogLineIsCorrect() {
        for (WebElement radiobutton : difElementsPage.getAllradiobuttons()) {
            radiobutton.click();
            System.out.println(difElementsPage.getLastLogText());
            softly.assertThat(difElementsPage.getLastLogText())
                    .as("Incorrect log text").endsWith("metal: value changed to " + radiobutton.getText());
        }
        softly.assertAll();
    }

    @Then("I see an individual log row and value is corresponded to the selected value for dropdown")
    public void dropdownLogLineIsCorrect() {
        difElementsPage.chooseFromClosedDropdown(Yellow);
        for (WebElement dropDownElement : difElementsPage.getAlldropDown()) {
            dropDownElement.click();
            System.out.println(difElementsPage.getLastLogText());
            softly.assertThat(difElementsPage.getLastLogText())
                    .as("Incorrect log text")
                    .endsWith("Colors: value changed to " + dropDownElement.getText());
        }
        softly.assertAll();
    }
}
