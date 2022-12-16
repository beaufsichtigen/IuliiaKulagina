package com.epam.tc.hw3.try1.library.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class DifElementsPage {


        @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Water')]")
        private WebElement checkboxWater;



    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Wind')]")
    private WebElement checkboxWind;



    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Selen')]")
    private WebElement radioBtnSelen;



//    @FindBy(css = "//*[contains(text()[normalize-space(.)],'Water')]")
//    private List<WebElement> checkboxWater;





        public DifElementsPage(WebDriver webDriver1) {
            PageFactory.initElements(webDriver1, this);
            //waitActions = new WaitActions(webDriver1);
        }

    public WebElement getCheckboxWind() {
        return checkboxWind;
    }

    public void clickWind() {
        checkboxWind.click();
}


    //fluent page object:


    public WebElement getCheckboxWater() {
        return checkboxWater;
    }

    public void clickWater() {
        checkboxWater.click();
    }


    public WebElement getRadioBtnSelen() {
        return radioBtnSelen;
    }

    public void clickSelen() {
        radioBtnSelen.click();
    }

    }

