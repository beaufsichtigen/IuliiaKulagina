package com.epam.tc.hw3.try1.library.pages;
import java.util.Properties;

import com.epam.tc.hw3.try1.library.utils.GetProperties;
import jdk.jshell.execution.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;


public class HomePage {


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


//
//    @FindBy(css = ".sidebar-menu > li")
//    private List<WebElement> sidebarItems;


        public HomePage(WebDriver webDriver1) {
            PageFactory.initElements(webDriver1, this);
            //waitActions = new WaitActions(webDriver1);
        }
//
//        public void login() {
//
//            GetProperties getProperties = new GetProperties();
//            userIcon.click();
//            usernameField.sendKeys(getProperties.getUsernameProp());
//            passwordField.sendKeys(getProperties.getPasswordProp());
//            loginButton.click();
//
//        }



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

//    public List<WebElement> getSidebarItems() {
//        return sidebarItems;
//    }

    }

