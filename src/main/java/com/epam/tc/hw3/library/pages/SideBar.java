package com.epam.tc.hw3.library.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBar {

    private WebDriver driver;

    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> sidebarItems;

    public SideBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getSidebarItems() {
        return sidebarItems;
    }
}

