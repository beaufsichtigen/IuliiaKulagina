//package com.epam.tc.hw3.try1.library.pages;
//
//import com.epam.tc.hw3.try1.library.utils.WaitActions;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class Header {
//
//    WaitActions waitActions;
//    WebDriver webDriver;
//
//    @FindBy(id = "user-name")
//    private WebElement userNameText;
//    @FindBy(id = "name")
//    private WebElement username;
//    @FindBy(css = "a[href='index.html']")
//    private WebElement homeButton;
//    @FindBy(css = "a[href='contacts.html']")
//    private WebElement contactFormButton;
//    @FindBy(css = "a.dropdown-toggle")
//    private WebElement serviceButton;
//    @FindBy(css = "a[href='metals-colors.html']")
//    private WebElement metalsColorsButton;
//
//
//
//    public Header (WebDriver webDriver1) {
//        PageFactory.initElements(webDriver1, this);
//        waitActions = new WaitActions(webDriver1);}
//
//    public WebElement getUserNameText() {
//        return userNameText;
//    }
//
//    public WebElement getUsername() {
//        return username;
//    }
//
//    public WebElement getHomeButton() {
//        return homeButton;
//    }
//
//    public WebElement getContactFormButton() {
//        return contactFormButton;
//    }
//
//    public WebElement getServiceButton() {
//        return serviceButton;
//    }
//
//    public WebElement getMetalsColorsButton() {
//        return metalsColorsButton;
//    }
//}


