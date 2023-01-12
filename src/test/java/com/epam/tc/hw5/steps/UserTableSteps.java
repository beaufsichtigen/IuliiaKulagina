package com.epam.tc.hw5.steps;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserTableSteps extends AbstractStep {

    @Then("\"User Table\" page should be opened")
    public void userTableIsOpened() {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));
        assertThat(driver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo(userTablePage.getUserTablePageURL());
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberOfTypeDropdownsIsDisplayed(int number) {
        assertThat(userTablePage.getNumberTypeDropdownsSize())
                .as("Incorrect number of Type Dropdowns")
                .isEqualTo(number);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void numberOfUsernamesIsDisplayed(int number) {
        assertThat(userTablePage.getUserNamesNumber())
                .as("Incorrect number of Type Dropdowns")
                .isEqualTo(number);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void numberOfDescriptionTextsIsDisplayed(int number) {
        assertThat(userTablePage.getDescriptionTextsNumber())
                .as("Incorrect number of Type Dropdowns")
                .isEqualTo(number);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void numberOfCheckboxesIsDisplayed(int number) {
        assertThat(userTablePage.getNumberOfCheckboxes())
                .as("Incorrect number of Type Dropdowns")
                .isEqualTo(number);
    }

    @Then("User table should contain following values:")
    public void userTableContainValues(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> userTable = dataTable.rows(1).cells();
        List<String> number = new ArrayList<>();
        List<String> user = new ArrayList<>();
        List<String> description = new ArrayList<>();
        for (List<String> element : userTable) {
            number.add(element.get(0));
            user.add(element.get(1));
            description.add(element.get(2));
        }
        softly.assertThat(userTablePage.getNumberFromTable())
                .as("Incorrect numbers")
                .isEqualTo(number);
        softly.assertThat(userTablePage.getUserFromTable())
                .as("Incorrect users")
                .isEqualTo(user);
        softly.assertThat(userTablePage.getDescriptionFromTable())
                .as("Incorrect description")
                .isEqualTo(description);
        softly.assertAll();
    }

    @Then("droplist should contain values in column Type for user {string}")
    public void droplistContainValuesInColumn(String userName, io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> valuesTable = dataTable.rows(1).cells();
        List<String> values = new ArrayList<>();
        for (List<String> element : valuesTable) {
            values.add(element.get(0));
        }
        softly.assertThat(userTablePage.getDroplistValues(userName))
                .as("Incorrect values in dropdown")
                .isEqualTo(values);
        softly.assertAll();
    }

    @When("I select 'vip' checkbox for {string}")
    public void selectVipCheckbox(String userName) {
        userTablePage.clickVipCheckbox(userName);
    }

    @When("1 log row has {string} text in log section")
    public void logRowHasExpectedText(String log) {
        softly.assertThat(userTablePage.getAllLogsText().size())
                .as("More than 1 or Null log text")
                .isEqualTo(1);

        softly.assertThat(userTablePage.getAllLogsText().get(0))
                .as("Incorrect log text")
                .endsWith(log);

        softly.assertAll();
    }
}
