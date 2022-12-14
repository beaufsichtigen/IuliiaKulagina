package com.epam.tc.hw3.pages;

import com.epam.tc.hw3.driverutils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WaitActions waitActions;
    WebDriver webDriver;

    String userName = "Roman";
    String password = "Jdi1234";

    @FindBy(id = "user-icon")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        waitActions = new WaitActions(webDriver);
    }

    public void login(String userNameData, String passwordData) {
        userNameData = userName;
        passwordData = password;
        userIcon.click();
        usernameField.sendKeys(userNameData);
        passwordField.sendKeys(passwordData);
        loginButton.click();


    }
}
