package com.epam.tc.hw6.steps;

import com.epam.tc.hw4.pages.BasePage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected WebDriver driver;
    protected BasePage anyPage;

    protected AbstractStep(WebDriver driver) {
        this.driver = driver;
        this.anyPage = new BasePage(driver);
    }
}
