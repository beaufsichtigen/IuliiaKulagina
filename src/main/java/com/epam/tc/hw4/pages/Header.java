package com.epam.tc.hw4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Locale;

public class Header {

    private WebDriver driver;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement userNameElement;

    @FindBy(css = "a[href='index.html']")
    private WebElement homeButton;

    @FindBy(css = "a[href='contacts.html']")
    private WebElement contactFormButton;

    @FindBy(css = "a.dropdown-toggle")
    private WebElement serviceButton;

    @FindBy(css = "a[href='metals-colors.html']")
    private WebElement metalsColorsButton;

    //Items in Service drop down:
    @FindBy(css = "a[href='.dropdown.open>ul>li>a']")
    public List<WebElement> allDropDownElements;
    @FindBy(css = "a[href='different-elements.html']")
    private WebElement difElements;

    @FindBy(css = "a[href='user-table.html']")
    private WebElement userTable;



    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        userIcon.click();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getUserNameText() {
        return userNameElement.getText();
    }

    public WebElement getUsernameElement() {
        return userNameElement;
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public String getHomeButtonText() {
        return homeButton.getText();
    }

    public WebElement getContactFormButton() {
        return contactFormButton;
    }

    public String getContactFormButtonText() {
        return contactFormButton.getText();
    }

    public WebElement getServiceButton() {
        return serviceButton;
    }

    public String getServiceButtonText() {
        return serviceButton.getText();
    }

    public WebElement getMetalsColorsButton() {
        return metalsColorsButton;
    }

    public String getMetalsColorsButtonText() {
        return metalsColorsButton.getText();
    }

    public WebElement getDifElements() {
        return difElements;
    }

    public void clickHeaderButton(String buttonName) {
        switch (buttonName.toUpperCase(Locale.ROOT)) {
            case "HOME":
                homeButton.click();
                break;
            case "CONTACT FORM":
                contactFormButton.click();
                break;
            case "SERVICE":
                serviceButton.click();
                break;
            case "METALS&COLORS":
                metalsColorsButton.click();
                break;
            default:
                System.out.println("No such button choosen");
        }
    }

//    public void clickServiceDropDownByName(String buttonName) {
//        for (WebElement dropDownItem : allDropDownElements) {
//            if (dropDownItem.getText().equalsIgnoreCase(buttonName))
//                System.out.println(dropDownItem.getText());
//                dropDownItem.click();
//        }
//    }

    public void clickServiceDropDownUserTable(String buttonName) {
        WebElement element = driver.findElement(By.xpath("//*[contains(text()[normalize-space(.)],'" + buttonName + "')]"));
        element.click();
    }

}

