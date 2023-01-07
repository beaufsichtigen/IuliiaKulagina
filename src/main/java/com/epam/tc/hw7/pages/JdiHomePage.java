package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.forms.LoginForm;

import static com.epam.tc.hw7.JdiSite.jdiHomePage;


public class JdiHomePage extends WebPage {

//    @FindBy(css = ".benefit")
//    public WebList benefit;

    @FindBy(id = "user-name")
    public Label userName;

    @FindBy(id = "user-icon")
    public Label userIcon;

    public LoginForm loginForm;


    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void checkUserLoggedIn(User user) {
        jdiHomePage.userName.is().text(user.getFullName());
    }
}





