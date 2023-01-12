package com.epam.tc.hw7;

import static com.epam.tc.hw7.JdiSite.jdiHomePage;
import static com.epam.tc.hw7.JdiSite.jdiMetalsPage;
import static com.epam.tc.hw7.entities.User.ROMAN;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.data.DataProviderJson;
import com.epam.tc.hw7.entities.MetalsInfo;
import org.assertj.core.api.Assertions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExerciseTest {
    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
    public void loginTest() {
        jdiHomePage.open();
        jdiHomePage.jdiHeader.login(ROMAN);
        jdiHomePage.jdiHeader.checkUserLoggedIn(ROMAN);
        jdiHomePage.jdiHeader.clickHeaderLink("METALS&COLORS");
        jdiMetalsPage.checkOpened();
    }

    @Test(dataProvider = "JsonProvider", dataProviderClass = DataProviderJson.class)
    public void testTest(MetalsInfo metalsFormData) {
        jdiMetalsPage.fillMetalColorForm(metalsFormData);
        Assertions.assertThat(jdiMetalsPage.getActualLogFromPage())
                .hasSameElementsAs(metalsFormData.getExpectedLogFromJson());
    }
}
