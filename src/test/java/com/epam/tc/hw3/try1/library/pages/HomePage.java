package com.epam.tc.hw3.try1.library.pages;

//import com.epam.tc.hw3.try1.library.utils.WaitActions;
import com.epam.tc.hw3.try1.library.utils.WaitActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

        @FindBy(css = ".benefit-icon")
        private List<WebElement> benefitImages;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefitImagesText;



    @FindBy(tagName = "iframe")
    private List<WebElement> iframes;



    @FindBy(css = "input#frame-button")
    private List<WebElement> frameButtons;

    @FindBy(css = "input#frame-button")
    private WebElement currentFrameButton;



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

    public List<WebElement> getBenefitImages() {
        return benefitImages;
    }

    public int numberOfBenefitImages() {
        return benefitImages.size();
    }

    public List<WebElement> getBenefitImagesText() {
        return benefitImagesText;
    }

    public int numberOfBenefitImagesText() {
        return benefitImagesText.size();
    }

    public List<WebElement> getIframes() {
        return iframes;
    }

    public List<WebElement> getFrameButtons() {
        return frameButtons;
    }
    public WebElement getCurrentFrameButton() {
        return currentFrameButton;
    }

    }

