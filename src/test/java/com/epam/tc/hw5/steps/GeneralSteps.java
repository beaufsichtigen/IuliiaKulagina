package com.epam.tc.hw5.steps;

import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;

public class GeneralSteps extends AbstractStep {

    @Then("I see {string} Browser title")
    public void i_see_browser_title(String expectedTitle) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(driver.getTitle()).as("Incorrect browser title").isEqualTo(expectedTitle);
        softly.assertAll();
    }

    @Then("I see page URL {string}")
    public void i_see_page_url(String URL) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(driver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo(URL);
        softly.assertAll();
    }

    @Then("I see {string} name is displayed in the left-top side of screen")
    public void i_see_user_name_is_displayed_in_the_left_top_side_of_screen(String expectedUserName) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(anyPage.getHeader().getUserNameText())
                .as("Incorrect user name")
                .isEqualTo(expectedUserName);
        softly.assertAll();
    }
}
