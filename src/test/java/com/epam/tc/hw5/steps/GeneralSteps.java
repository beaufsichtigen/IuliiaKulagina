package com.epam.tc.hw5.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GeneralSteps extends AbstractStep {

    @Then("I see {string} Browser title")
    public void browserTitleIsCorrect(String expectedTitle) {
        softly.assertThat(driver.getTitle()).as("Incorrect browser title").isEqualTo(expectedTitle);
        softly.assertAll();
    }

    @Then("I see page URL {string}")
    public void pageUrlIsCorrect(String url) {
        softly.assertThat(driver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo(url);
        softly.assertAll();
    }

    @Then("I see {string} name is displayed in the left-top side of screen")
    public void usernameIsDisplayed(String expectedUserName) {
        softly.assertThat(anyPage.getHeader().getUserNameText())
                .as("Incorrect user name")
                .isEqualTo(expectedUserName);
        softly.assertAll();
    }

    @When("I clear elements status")
    public void refreshPage() {
        driver.navigate().refresh();
    }

    @When("I click on {string} button in Header")
    public void clickOnButtonInHeader(String headerButton) {
        anyPage.getHeader().clickHeaderButton(headerButton);
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOnServiceDropdown(String serviceDropdown) {
        anyPage.getHeader().clickServiceDropDownUserTable(serviceDropdown);
    }
}
