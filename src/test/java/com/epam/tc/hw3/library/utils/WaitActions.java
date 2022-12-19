package com.epam.tc.hw3.library.utils;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitActions {

    private final WebDriverWait webDriverWait;

    public WaitActions(WebDriver webDriver) {
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public Boolean waitUntilCondition(Function<WebDriver, Boolean> p) {
        return webDriverWait.ignoring(NoSuchElementException.class)
                .until(p);
    }

}