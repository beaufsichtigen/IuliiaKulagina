package com.epam.tc.hw3.library.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifElementsPage {

    //Checkboxes
    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Water')]")
    private WebElement checkboxWater;

    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Wind')]")
    private WebElement checkboxWind;

    //RadioButtons
    @FindBy(className = "label-radio")
    private List<WebElement> radiobuttons;

    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Selen')]")
    private WebElement radioBtnSelen;

    //DropDowns
    @FindBy(css = ".colors>select>option")
    private List<WebElement> dropDown;

    @FindBy(className = "colors")
    private WebElement dropDownColors;

    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement dropDownYellow;

    //Log
    @FindBy(css = ".logs :first-child")
    private WebElement lastLog;

    public DifElementsPage(WebDriver webDriver1) {
        PageFactory.initElements(webDriver1, this);
    }

    //Checkboxes

    public List<WebElement> getAllCheckboxes() {
        return checkboxes;
    }

    public WebElement getCheckboxWind() {
        return checkboxWind;
    }

    public WebElement getCheckboxWater() {
        return checkboxWater;
    }

    public void clickWebElement(WebElement element) {
        element.click();
    }

    //RadioButtons
    public List<WebElement> getAllradiobuttons() {
        return radiobuttons;
    }

    public WebElement getRadioBtnSelen() {
        return radioBtnSelen;
    }

    public WebElement getDropDownYellow() {
        return dropDownYellow;
    }

    //DropDowns
    public List<WebElement> getAlldropDown() {
        return dropDown;
    }

    public void chooseFromClosedDropdown(WebElement dropDownElement) {
        dropDownColors.click();
        dropDownElement.click();
    }

    public WebElement getLastLog() {
        return lastLog;
    }
}


