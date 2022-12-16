package com.epam.tc.hw3.try1.library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


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

