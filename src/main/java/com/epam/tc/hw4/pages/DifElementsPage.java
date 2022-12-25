package com.epam.tc.hw4.pages;

import java.util.List;
import lombok.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifElementsPage {

    //Checkboxes
    public enum CheckboxElement {
        Water,
        Earth,
        Wind,
        Fire
    }

    @FindBy(css = "input[type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Water')]")
    private WebElement checkboxWater;

    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Wind')]")
    private WebElement checkboxWind;

    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Earth')]")
    private WebElement checkboxEarth;

    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Fire')]")
    private WebElement checkboxFire;


    //RadioButtons

    public enum Metal {
        Gold,
        Silver,
        Bronze,
        Selen
    }

    @FindBy(className = "label-radio")
    private List<WebElement> radiobuttons;

    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Gold')]")
    private WebElement radioBtnGold;

    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Silver')]")
    private WebElement radioBtnSilver;

    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Bronze')]")
    private WebElement radioBtnBronze;

    @FindBy(xpath = "//*[contains(text()[normalize-space(.)],'Selen')]")
    private WebElement radioBtnSelen;

    //DropDowns
    public enum Color {
        Red,
        Green,
        Blue,
        Yellow
    }

    @FindBy(css = ".colors>select>option")
    private List<WebElement> dropDown;

    @FindBy(className = "colors")
    private WebElement dropDownColors;

    @FindBy(xpath = "//option[text()='Red']")
    private WebElement dropDownRed;

    @FindBy(xpath = "//option[text()='Green']")
    private WebElement dropDownGreen;

    @FindBy(xpath = "//option[text()='Blue']")
    private WebElement dropDownBlue;

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

    public WebElement getCheckbox(@NonNull CheckboxElement element) {
        WebElement checkbox = null;
        switch (element) {
            case Water:
                checkbox = checkboxWater;
                break;
            case Wind:
                checkbox = checkboxWind;
                break;
            case Earth:
                checkbox = checkboxEarth;
                break;
            case Fire:
                checkbox = checkboxFire;
                break;
            default:
                System.out.println("incorrect element choosen");
        }
        return checkbox;
    }

    public void clickWebElement(WebElement element) {
        element.click();
    }

    public void clickCheckbox(CheckboxElement element) {
        switch (element) {
            case Water:
                checkboxWater.click();
                break;
            case Wind:
                checkboxWind.click();
                break;
            case Earth:
                checkboxEarth.click();
                break;
            case Fire:
                checkboxFire.click();
                break;
            default:
                System.out.println("incorrect element choosen");
        }
    }

    //RadioButtons
    public List<WebElement> getAllradiobuttons() {
        return radiobuttons;
    }

    public WebElement getRadioBtn(Metal metal) {
        WebElement radioBtn = null;
        switch (metal) {
            case Gold:
                radioBtn = radioBtnGold;
                break;
            case Silver:
                radioBtn = radioBtnSilver;
                break;
            case Bronze:
                radioBtn = radioBtnBronze;
                break;
            case Selen:
                radioBtn = radioBtnSelen;
                break;
            default:
                System.out.println("incorrect metal choosen");
        }
        return radioBtn;
    }

    public void clickMetal(Metal metal) {
        switch (metal) {
            case Gold:
                radioBtnGold.click();
                break;
            case Silver:
                radioBtnSilver.click();
                break;
            case Bronze:
                radioBtnBronze.click();
                break;
            case Selen:
                radioBtnSelen.click();
                break;
            default:
                System.out.println("incorrect metal choosen");
        }
    }

    //DropDowns
    public List<WebElement> getAlldropDown() {
        return dropDown;
    }

    public WebElement getDropDown(@NonNull Color color) {
        WebElement dropDown = null;
        switch (color) {
            case Red:
                dropDown = dropDownRed;
                break;
            case Green:
                dropDown = dropDownGreen;
                break;
            case Blue:
                dropDown = dropDownBlue;
                break;
            case Yellow:
                dropDown = dropDownYellow;
                break;
            default:
                System.out.println("incorrect color choosen");
        }
        return dropDown;
    }

    public void chooseFromClosedDropdown(Color color) {
        dropDownColors.click();
        switch (color) {
            case Red:
                dropDownRed.click();
                break;
            case Green:
                dropDownGreen.click();
                break;
            case Blue:
                dropDownBlue.click();
                break;
            case Yellow:
                dropDownYellow.click();
                break;
            default:
                System.out.println("incorrect color choosen");
        }
    }

    public WebElement getLastLog() {
        return lastLog;
    }

    public String getLastLogText() {
        return lastLog.getText();
    }
}
