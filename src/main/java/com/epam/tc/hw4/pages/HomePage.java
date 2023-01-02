package com.epam.tc.hw4.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public void openHomePage(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
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
