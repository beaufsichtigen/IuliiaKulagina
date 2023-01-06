package com.epam.tc.hw7;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.tc.hw7.JdiSite.jdiHomePage;
import static com.epam.tc.hw7.entities.User.ROMAN;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;

public class HwTest {
    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        //openSite(JdiSite.class);
        //logger.info("Run Tests");
        initElements(JdiSite.class);

    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        killAllSeleniumDrivers();
    }

    @Test
    public void loginTest() {
        JdiSite.open();
        JdiSite.login(ROMAN);
        //jdiHomePage.checkUserLoggedIn(ROMAN);
        jdiHomePage.username.is().text(ROMAN.getFullName());
    }
}
