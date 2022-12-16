package com.epam.tc.hw3.try1.library.pages;

import com.epam.tc.hw3.try1.library.utils.GetProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {
    //WaitActions waitActions;
    WebDriver webDriver;

    //Properties testProperties = new Properties();

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



    public Header(WebDriver webDriver1) {
        PageFactory.initElements(webDriver1, this);
        //waitActions = new WaitActions(webDriver1);
    }

    public void login() {

        GetProperties getProperties = new GetProperties();
        userIcon.click();
        usernameField.sendKeys(getProperties.getUsernameProp());
        passwordField.sendKeys(getProperties.getPasswordProp());
        loginButton.click();

    }

    public String getUserNameText() {
        String userNameText = userNameElement.getText();
        return userNameText;
    }

    public WebElement getUsernameElement() {
        return userNameElement;
    }


    public WebElement getHomeButton() {
        return homeButton;
    }

    public String getHomeButtonText() {
        String homeButtonText = homeButton.getText();
        return homeButtonText;
    }

    public WebElement getContactFormButton() {
        return contactFormButton;
    }

    public String getContactFormButtonText() {
        String homeContactFormButton = contactFormButton.getText();
        return homeContactFormButton;
    }

    public WebElement getServiceButton() {
        return serviceButton;
    }

    public String getServiceButtonText() {
        String homeServiceButton = serviceButton.getText();
        return homeServiceButton;
    }

    public WebElement getMetalsColorsButton() {
        return metalsColorsButton;
    }

    public String getMetalsColorsButtonText() {
        String homeMetalsColorsButton = metalsColorsButton.getText();
        return homeMetalsColorsButton;
    }

    public WebElement getDifElements() {
        return difElements;
    }







}

