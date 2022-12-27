package com.epam.tc.hw3.library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private WebDriver driver;
    private Header header;
    private SideBar sideBar;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.header = new Header(driver);
        this.sideBar = new SideBar(driver);
    }

    public Header getHeader() {
        return header;
    }

    public SideBar getSideBar() {
        return sideBar;
    }
}
