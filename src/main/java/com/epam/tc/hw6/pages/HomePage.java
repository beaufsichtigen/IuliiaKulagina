package com.epam.tc.hw6.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

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

    public HomePage(WebDriver driver) {
        super(driver);
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

