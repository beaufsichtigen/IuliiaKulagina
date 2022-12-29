package com.epam.tc.hw5.steps;


import com.epam.tc.hw4.utils.GetProperties;
import com.epam.tc.hw5.steps.AbstractStep;
import cucumber.api.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

public class HomePageSteps extends AbstractStep {


    @When("I see Anauthenticated Home page opens")
    public void i_see_home_page_opens() {
        homePage.openHomePage(driver);
    }

    @When("I login with login and password")
    public void i_login_as_user() {
        homePage.openHomePage(driver);
        GetProperties getProperties = new GetProperties();
        String username = getProperties.getUsernameProp();
        String password = getProperties.getPasswordProp();
        anyPage.getHeader().login(username, password);
    }
}


