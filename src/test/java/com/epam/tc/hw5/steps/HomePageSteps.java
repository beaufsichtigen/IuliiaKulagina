package com.epam.tc.hw5.steps;

import com.epam.tc.hw4.utils.GetProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageSteps extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openJdiGitHubSite() {
        homePage.openHomePage(driver);
    }

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
        homePage.getHeader().login(username, password);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));
    }
}
