package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    String userNameData = "Roman";
    String passwordData = "Jdi1234";

    @FindBy(id = "user-icon")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void login(String userNameData, String passwordData) {
        userIcon.click();
        username.sendKeys(userNameData);
        password.sendKeys(passwordData);
        loginButton.click();


    }
}
