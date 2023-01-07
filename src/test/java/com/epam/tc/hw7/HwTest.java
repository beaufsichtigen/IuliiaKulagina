package com.epam.tc.hw7;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.tc.hw7.JdiSite.jdiHomePage;
import static com.epam.tc.hw7.entities.User.ROMAN;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.forms.LoginForm;
import com.epam.tc.hw7.pages.JdiHomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class HwTest {
    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
    public void loginTest() throws InterruptedException {
        JdiSite.open();
        JdiSite.login(ROMAN);
        jdiHomePage.checkUserLoggedIn(ROMAN);
//        Open Metals & Colors page by Header menu		Metals & Colors page is opened

//        Fill form Metals & Colors by data below:		Form Metals & Colors form is filled
//        Submit form Metals & Colors		Form Metals & Colors was submitted


        Thread.sleep(3000);
    }
}
