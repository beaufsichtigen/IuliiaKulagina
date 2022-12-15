package com.epam.tc.hw3.try1.library.pages;

//import com.epam.tc.hw3.try1.library.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class HomePage {

        //WaitActions waitActions;
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

//        @FindBy(id = "user-name")
//        private WebElement userNameElement;

//        @FindBy(css = "a[href='index.html']")
//        private WebElement homeButton;
//        @FindBy(css = "a[href='contacts.html']")
//        private WebElement contactFormButton;
//        @FindBy(css = "a.dropdown-toggle")
//        private WebElement serviceButton;
//        @FindBy(css = "a[href='metals-colors.html']")
//        private WebElement metalsColorsButton;

        public HomePage(WebDriver webDriver1) {
            PageFactory.initElements(webDriver1, this);
            //waitActions = new WaitActions(webDriver1);
        }

        public void login(String userNameData, String passwordData) {
            userNameData = userName;
            passwordData = password;
            userIcon.click();
            usernameField.sendKeys(userNameData);
            passwordField.sendKeys(passwordData);
            loginButton.click();

        }

//        public String getUserNameText() {
//            String userNameText = userNameElement.getText();
//            return userNameText;
//        }
//
////        public WebElement getUsername() {
////            return username;
////        }
//
//        public WebElement getHomeButton() {
//            return homeButton;
//        }
//
//        public WebElement getContactFormButton() {
//            return contactFormButton;
//        }
//
//        public WebElement getServiceButton() {
//            return serviceButton;
//        }
//
//        public WebElement getMetalsColorsButton() {
//            return metalsColorsButton;
//        }
//
//


    }

