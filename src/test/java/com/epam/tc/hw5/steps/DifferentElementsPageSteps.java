package com.epam.tc.hw5.steps;

import com.epam.tc.hw4.pages.DifElementsPage;
import com.epam.tc.hw4.utils.GetProperties;
//import cucumber.api.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.epam.tc.hw4.pages.DifElementsPage.Color.Yellow;

public class DifferentElementsPageSteps extends AbstractStep {
    @When("I open through the header menu Service -> Different Elements Page")
    public void i_open_through_the_header_menu_service_different_elements_page() {
        anyPage.getHeader().getServiceButton().click();
        anyPage.getHeader().getDifElements().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));
    }

    @When("Select checkbox {string}")
    public void select_checkbox(String element){
        difElementsPage.clickCheckbox(element);
    }
    @When("Select radio {string}")
    public void select_radio(String metal) {
        difElementsPage.clickWebElement(difElementsPage.getRadioBtn(metal));
                }

    @When("Select in dropdown {string}")
    public void select_in_dropdown_yellow(String color) {
        difElementsPage.chooseFromClosedDropdown(color);
    }

    @Then("I see {string} element is checked")
    public void i_see_water_wind_elements_are_checked(String element) {
        softly.assertThat(difElementsPage.getCheckbox(element).isEnabled())
                .as("Check box " + element + " was not enabled")
                .isTrue();
        softly.assertAll();
    }
    @Then("I see {string} metal is checked")
    public void i_see_selen_metal_is_checked(String metal) {
        softly.assertThat(difElementsPage.getRadioBtn(metal)
                .isEnabled()).as("Incorrect radio button state").isTrue();
        softly.assertAll();
    }
    @Then("I see {string} color is selected")
    public void i_see_yellow_color_is_selected(String color) {
        softly.assertThat(difElementsPage.getDropDown(color)
                    .isSelected()).as("Incorrect drop down state").isTrue();
            softly.assertAll();
    }

    @Then("I see log line of checkbox {string} with {string}")
    public void iSeeLogLine(String checkboxName, String value) throws InterruptedException {
        Thread.sleep(3000);
        //WebElement checkbox = difElementsPage.getCheckbox(checkboxName);
        //String log = difElementsPage.getLastLogText();
        softly.assertThat(difElementsPage.getLastLogText())
                .as("Incorrect log text")
                .endsWith(checkboxName + ": condition changed to " + value);
        softly.assertAll();
    }

    @Then("I see an individual log row and value is corresponded to the status of checkbox")
    public void iSeeCheckboxLogLine() {
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
        public void iSeeRadioButtonLogLine() {
            for (WebElement radiobutton : difElementsPage.getAllradiobuttons()) {
                radiobutton.click();
                System.out.println(difElementsPage.getLastLogText());
                softly.assertThat(difElementsPage.getLastLogText())
                        .as("Incorrect log text").endsWith("metal: value changed to " + radiobutton.getText());
            }
            softly.assertAll();
        }

    @Then("I see an individual log row and value is corresponded to the selected value for dropdown")
    public void iSeeDropdownLogLine() {
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



//    @Then("I see log line of checkbox {string} with {string}")
//    public void iSeeLogLineOfCheckbox(String checkboxName, String checkboxName) {
//        SoftAssertions softly = new SoftAssertions();
//        //WebElement checkbox = difElementsPage.getCheckbox(checkboxName);
//        String log = difElementsPage.getLastLogText();
//        softly.assertThat(difElementsPage.getLastLogText())
//                .as("Incorrect log text")
//                .endsWith(checkboxName + ": condition changed to " + difElementsPage.getCheckbox(checkboxName).isSelected());
//        softly.assertAll();
//    }
}
