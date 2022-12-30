package com.epam.tc.hw5.steps;

import com.epam.tc.hw4.utils.GetProperties;
import io.cucumber.java.en.When;

public class HomePageSteps extends AbstractStep {

    @When("I see Anauthenticated Home page opens")
    public void homePageOpens() {
        homePage.openHomePage(driver);
    }

    @When("I login as user {string}")
    public void login(String userName) {
        homePage.openHomePage(driver);
        GetProperties getProperties = new GetProperties();
        String username = getProperties.getUsernameProp();
        String password = getProperties.getPasswordProp();
        anyPage.getHeader().login(username, password);
    }
}
