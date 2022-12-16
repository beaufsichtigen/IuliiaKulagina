package com.epam.tc.hw3.try1.library.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class SideBar {


    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> sidebarItems;


    public SideBar(WebDriver webDriver1) {
        PageFactory.initElements(webDriver1, this);
        //waitActions = new WaitActions(webDriver1);
    }


    public List<WebElement> getSidebarItems() {
        return sidebarItems;
    }

}

