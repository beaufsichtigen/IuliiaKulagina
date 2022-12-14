package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    @FindBy(id = "user-name")
    private WebElement userNameText;
    @FindBy(id = "name")
    private WebElement username;
    @FindBy(css = "a[href='index.html']")
    private WebElement homeButton;
    @FindBy(css = "a[href='contacts.html']")
    private WebElement contactFormButton;
    @FindBy(css = "a.dropdown-toggle")
    private WebElement serviceButton;
    @FindBy(css = "a[href='metals-colors.html']")
    private WebElement metalsColorsButton;

    public WebElement getUserNameText() {
        return userNameText;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getContactFormButton() {
        return contactFormButton;
    }

    public WebElement getServiceButton() {
        return serviceButton;
    }

    public WebElement getMetalsColorsButton() {
        return metalsColorsButton;
    }
}


