package com.epam.tc.hw7.forms;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.tc.hw7.entities.User;
import java.util.Locale;

public class HeaderForm extends Section {

    @FindBy(id = "user-name")
    public Label userName;

    @FindBy(id = "user-icon")
    public Label userIcon;

    @UI("form.login")
    public LoginForm loginForm;

    @FindBy(css = "a[href='metals-colors.html']")
    private Link metalsColorsLink;

    @FindBy(css = "a[href='index.html']")
    private Link homeLink;

    @FindBy(css = "a[href='contacts.html']")
    private Link contactFormLink;

    @FindBy(css = "a.dropdown-toggle")
    private Link serviceLink;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void checkUserLoggedIn(User user) {
        userName.is().text(user.getFullName());
    }

    public void clickHeaderLink(String buttonName) {
        switch (buttonName.toUpperCase(Locale.ROOT)) {
            case "HOME":
                homeLink.click();
                break;
            case "CONTACT FORM":
                contactFormLink.click();
                break;
            case "SERVICE":
                serviceLink.click();
                break;
            case "METALS&COLORS":
                metalsColorsLink.click();
                break;
            default:
                System.out.println("No such button choosen");
        }
    }
}
