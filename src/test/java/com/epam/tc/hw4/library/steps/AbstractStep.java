package com.epam.tc.hw4.library.steps;

import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected WebDriver driver;

    protected AbstractStep(WebDriver driver) {
        this.driver = driver;
    }
}
