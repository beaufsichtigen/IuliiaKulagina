package com.epam.tc.hw5.pages;

import com.epam.tc.hw4.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class UserTablePage extends BasePage {

    @FindBy(css = "tbody > tr")
    private List<WebElement> numberTypeDropdowns;

    @FindBy(css = "td > a")
    private List<WebElement> userNames;

    @FindBy(css = ".user-descr > span")
    private List<WebElement> descriptionTexts;

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//td[1]")
    private List<WebElement> numberInTable;


    private String userTablePageURL = "https://jdi-testing.github.io/jdi-light/user-table.html";

    public UserTablePage(WebDriver driver) {
        super(driver);
    }

    public String getUserTablePageURL() {
        return userTablePageURL;
    }

    public int getNumberTypeDropdownsSize() { return numberTypeDropdowns.size(); }

    public int getUserNamesNumber() { return userNames.size(); }

    public int getDescriptionTextsNumber() { return descriptionTexts.size(); }

    public int getNumberOfCheckboxes() { return checkboxes.size(); }

    public List<String> getUserFromTable() {
        return userNames.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getNumberFromTable() {
        return numberInTable.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getDescriptionFromTable() {
        return descriptionTexts.stream()
                .map(WebElement::getText)
                .map(n -> n.replaceAll("\\s", " "))
                .collect(Collectors.toList());
    }




    getDroplistValues()
}
