package com.epam.tc.hw5.steps;

import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UserTableSteps extends AbstractStep {

    @Then("\"User Table\" page should be opened")
    public void userTableIsOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));
        softly.assertThat(driver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo(userTablePage.getUserTablePageURL());
        softly.assertAll();
    }

    @Then("{string} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberOfTypeDropdownsIsDisplayed(String number) {
        softly.assertThat(userTablePage.getNumberTypeDropdownsSize())
                .as("Incorrect number of Type Dropdowns")
                .isEqualTo(Integer.parseInt(number));
        softly.assertAll();
    }

    @Then("{string} Usernames should be displayed on Users Table on User Table Page")
    public void numberOfUsernamesIsDisplayed(String number) {
        softly.assertThat(userTablePage.getUserNamesNumber())
                .as("Incorrect number of Type Dropdowns")
                .isEqualTo(Integer.parseInt(number));
        softly.assertAll();
    }

    @Then("{string} Description texts under images should be displayed on Users Table on User Table Page")
    public void numberOfDescriptionTextsIsDisplayed(String number) {
        softly.assertThat(userTablePage.getDescriptionTextsNumber())
                .as("Incorrect number of Type Dropdowns")
                .isEqualTo(Integer.parseInt(number));
        softly.assertAll();
    }

    @Then("{string} checkboxes should be displayed on Users Table on User Table Page")
    public void numberOfCheckboxesIsDisplayed(String number) {
        softly.assertThat(userTablePage.getNumberOfCheckboxes())
                .as("Incorrect number of Type Dropdowns")
                .isEqualTo(Integer.parseInt(number));
        softly.assertAll();
    }

    @Then("User table should contain following values:")
    public void user_table_should_contain_following_values(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> userTable = dataTable.cells().subList(1, 7);
        List<String> number = new ArrayList<>();
        List<String> user = new ArrayList<>();
        List<String> description = new ArrayList<>();
        for (List<String> element : userTable) {
            number.add(element.get(0));
            user.add(element.get(1));
            description.add(element.get(2));

        }
        ;
        softly.assertThat(userTablePage.getNumberFromTable()).isEqualTo(number);
        softly.assertThat(userTablePage.getUserFromTable()).isEqualTo(user);
        softly.assertThat(userTablePage.getDescriptionFromTable()).isEqualTo(description);
        softly.assertAll();
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistContainValuesInColumnTypeForUserRoman(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> valuesTable = dataTable.cells().subList(1, 3);
        List<String> values = new ArrayList<>();
        for (List<String> element : valuesTable) {
            values.add(element.get(0));
        }
        softly.assertThat(userTablePage.getDroplistValues()).isEqualTo(values);
        softly.assertAll();

    }
}
