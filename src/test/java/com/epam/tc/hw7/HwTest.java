package com.epam.tc.hw7;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;

import com.epam.tc.hw7.entities.User;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.tc.hw7.JdiSite.jdiHomePage;
import static com.epam.tc.hw7.entities.User.ROMAN;

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
 //       JdiSite.login(ROMAN);
        String actualName = jdiHomePage.getUserName();
        //jdiHomePage.checkUserLoggedIn(ROMAN);
        jdiHomePage.userName.is().text(ROMAN.getFullName());
    }
}
