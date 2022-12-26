package com.epam.tc.hw6.testcases;

import com.epam.tc.hw4.library.steps.Steps;
import com.epam.tc.hw6.grid.DriverFabric;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    WebDriver testDriver;

    public static String getBaseURL() {
        return baseURL;
    }

    protected Steps step;

    private static final String baseURL = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeClass
    @Parameters({"isLocal", "hub", "browser"})
    public void setupGridDriver(@Optional("false") final boolean isLocal,
                                final String hub, final String browser) {
        testDriver = DriverFabric.getWebDriver(isLocal, hub, browser);
    }
    //    @Parameters({"browser"})
    //    public void setupGridDriver(final String browser) {
    //        System.out.println("Driver Fabric" + browser);
    //        testDriver = DriverFabric.getWebDriver(browser);
    //    }

    @BeforeMethod
    void setupAll(ITestContext context) {
        //testDriver = new ChromeDriver();
        testDriver.manage().window().maximize();
        context.setAttribute("driver", testDriver);
        testDriver.get(baseURL);
        step = new Steps(testDriver);
    }

    @AfterMethod
    public void tearDownDriver() {
        if (testDriver != null) {
            testDriver.quit();
        }
    }
}
