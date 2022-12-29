package com.epam.tc.hw5.steps;

import com.epam.tc.hw4.pages.DifElementsPage;
import com.epam.tc.hw4.utils.GetProperties;
import cucumber.api.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DifferentElementsPageSteps extends AbstractStep {
    @When("I open through the header menu Service -> Different Elements Page")
    public void i_open_through_the_header_menu_service_different_elements_page() {
        homePage.openHomePage(driver);
        GetProperties getProperties = new GetProperties();
        anyPage.getHeader().login(getProperties.getUsernameProp(), getProperties.getPasswordProp());
        anyPage.getHeader().getServiceButton().click();
        anyPage.getHeader().getDifElements().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));
    }

    @When("Select checkbox {string}")
    public void select_checkbox(String elementString) {
        com.epam.tc.hw4.pages.DifElementsPage.CheckboxElement element = DifElementsPage.CheckboxElement.valueOf(elementString);
        difElementsPage.clickCheckbox(element);
    }
    @When("Select radio {string}")
    public void select_radio(String metalString) {
        DifElementsPage.Metal metal = DifElementsPage.Metal.valueOf(metalString);
        difElementsPage.clickWebElement(difElementsPage.getRadioBtn(metal));
                }

    @When("Select in dropdown {string}")
    public void select_in_dropdown_yellow(String colorString) {
        DifElementsPage.Color color = DifElementsPage.Color.valueOf(colorString);
        difElementsPage.chooseFromClosedDropdown(color);
    }

    @When("Click on each checkbox, radio button, dropdown value")
    public void click_on_each_checkbox_radio_button_dropdown_value() {
        driver.navigate().refresh(); //clean all elements state

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
    @Then("I see {string} element is checked")
    public void i_see_water_wind_elements_are_checked(String elementString) {

        com.epam.tc.hw4.pages.DifElementsPage.CheckboxElement element = DifElementsPage.CheckboxElement.valueOf(elementString);
        softly.assertThat(difElementsPage.getCheckbox(element).isEnabled())
                .as("Check box " + element + " was not enabled")
                .isTrue();
        softly.assertAll();
    }
    @Then("I see {string} metal is checked")
    public void i_see_selen_metal_is_checked(String metalString) {
        DifElementsPage.Metal metal = DifElementsPage.Metal.valueOf(metalString);

        softly.assertThat(difElementsPage.getRadioBtn(metal)
                .isEnabled()).as("Incorrect radio button state").isTrue();
        softly.assertAll();
    }
    @Then("I see {string} color is selected")
    public void i_see_yellow_color_is_selected(String colorString) {
        DifElementsPage.Color color = DifElementsPage.Color.valueOf(colorString);
        softly.assertThat(difElementsPage.getDropDown(color)
                    .isSelected()).as("Incorrect drop down state").isTrue();
            softly.assertAll();
    }

    @Then("There is individual log row and value is corresponded to the status of checkbox, radio button, dropdown value.")
    public void there_is_individual_log_row_and_value_is_corresponded_to_the_status_of_checkbox_radio_button_dropdown_value() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
