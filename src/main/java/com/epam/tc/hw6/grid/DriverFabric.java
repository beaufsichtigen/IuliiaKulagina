package com.epam.tc.hw6.grid;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.opera.OperaOptions;
//import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;


@UtilityClass
public class DriverFabric {

    public WebDriver getWebDriver(final boolean isLocal, final String hub, @NonNull final String browser) {

        if (isLocal) {
            return WebDriverManager.getInstance(browser).create();
        } else {
            Capabilities caps = getCapabilities(browser);
            URL hubAddress = getUrl(hub);
            return new RemoteWebDriver(hubAddress, caps);
        }
    }

    private URL getUrl(String hub) {
        try {
            return new URL(hub);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Hub URL looks malformed", e);
        }
    }

    private MutableCapabilities getCapabilities(String browserName) {
        switch (browserName.toLowerCase(Locale.ROOT)) {
//            case BrowserType.FIREFOX:
//                return new FirefoxOptions();
//            case BrowserType.OPERA_BLINK:
//                return new OperaOptions();
//            case BrowserType.CHROME:
//                return new ChromeOptions();
            default:
                String errorMessage = String.format(
                        "The browser name '%s' is not recognized", browserName);
                throw new WebDriverManagerException(errorMessage);
        }
    }
}

