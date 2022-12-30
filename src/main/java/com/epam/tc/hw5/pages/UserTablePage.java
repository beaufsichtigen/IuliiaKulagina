package com.epam.tc.hw5.pages;

import com.epam.tc.hw4.pages.Header;
import com.epam.tc.hw4.pages.SideBar;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTablePage {

    private WebDriver driver;
    private Header header;
    private SideBar sideBar;
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

    @FindBy(css = ".logs > *")
    private List<WebElement> allLog;

    private String userTablePageURL = "https://jdi-testing.github.io/jdi-light/user-table.html";

    public UserTablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.header = new Header(driver);
        this.sideBar = new SideBar(driver);
    }

    public String getUserTablePageURL() {
        return userTablePageURL;
    }

    public int getNumberTypeDropdownsSize() {
        return numberTypeDropdowns.size();
    }

    public int getUserNamesNumber() {
        return userNames.size();
    }

    public int getDescriptionTextsNumber() {
        return descriptionTexts.size();
    }

    public int getNumberOfCheckboxes() {
        return checkboxes.size();
    }

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

    public List<String> getDroplistValues(String userName) {
        List<WebElement> dropdownValues = driver
                .findElements(By.xpath(".//a[contains(text(),'" + userName + "')]/ancestor::tr//option"));
        return dropdownValues.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickVipCheckbox(String userName) {
        driver.findElement(By.xpath(".//*[contains(text(),'" + userName + "')]/../..//input"))
                .click();
    }

    public List<String> getAllLogsText() {
        return allLog.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
