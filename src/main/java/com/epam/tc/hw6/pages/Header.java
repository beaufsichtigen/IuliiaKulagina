package com.epam.tc.hw6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    @FindBy(css = "a[href='different-elements.html']")
    private WebElement difElements;

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
}

