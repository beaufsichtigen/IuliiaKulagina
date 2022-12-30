package com.epam.tc.hw5.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

public class GeneralSteps extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void i_open_JDI_GitHub_site() {
        homePage.openHomePage(driver);
    }

    @Then("I see {string} Browser title")
    public void i_see_browser_title(String expectedTitle) {
        softly.assertThat(driver.getTitle()).as("Incorrect browser title").isEqualTo(expectedTitle);
        softly.assertAll();
    }

    @Then("I see page URL {string}")
    public void i_see_page_url(String URL) {
        softly.assertThat(driver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo(URL);
        softly.assertAll();
    }

    @Then("I see {string} name is displayed in the left-top side of screen")
    public void i_see_user_name_is_displayed_in_the_left_top_side_of_screen(String expectedUserName) {
        softly.assertThat(anyPage.getHeader().getUserNameText())
                .as("Incorrect user name")
                .isEqualTo(expectedUserName);
        softly.assertAll();
    }

    @When("I clear elements status")
    public void refresh_page(){
        driver.navigate().refresh();
    }

    @When ("I click on {string} button in Header")
    public void iClickOnButtonInHeader(String headerButton) {
        anyPage.getHeader().clickHeaderButton(headerButton);
    }

    @When ("I click on {string} button in Service dropdown")
    public void iClickOnServiceDropdown(String serviceDropdown) {
        anyPage.getHeader().clickServiceDropDownUserTable(serviceDropdown);
    }

}
