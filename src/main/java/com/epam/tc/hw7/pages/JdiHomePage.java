package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.forms.HeaderForm;

public class JdiHomePage extends WebPage {

    @UI("header")
    public HeaderForm headerHomeForm;

    public void login(User user) {
        headerHomeForm.login(user);
    }

    public void checkUserLoggedIn(User user) {
        headerHomeForm.checkUserLoggedIn(user);
    }

    public void clickHeaderLink(String buttonName) {
        headerHomeForm.clickHeaderLink(buttonName);
    }
}
