package com.epam.tc.hw5.steps;


import com.epam.tc.hw4.pages.BasePage;
import com.epam.tc.hw4.pages.DifElementsPage;
import com.epam.tc.hw4.pages.HomePage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import com.epam.tc.hw5.utils.DriverManagerUtil;

public abstract class AbstractStep {

    //protected PageObjectDifferentElements pageObjectDifferentElements;
    protected HomePage homePage;
    protected BasePage anyPage;
    protected DifElementsPage difElementsPage;

    protected WebDriver driver;

    protected SoftAssertions softly;

    protected AbstractStep() {
        softly = new SoftAssertions();
        driver = DriverManagerUtil.setupDriver();
        homePage = new HomePage(driver);
        anyPage = new BasePage(driver);
        difElementsPage = new DifElementsPage(driver);

    }


}
