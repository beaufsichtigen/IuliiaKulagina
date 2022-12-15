package com.epam.tc.hw3.try1.library.data;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

public class DataProviders {
        @DataProvider(name = "headerData")
        public static Object[][] logIn() {
            return new Object[][]{

                    //selector //description //expected result
                    {"a[href='index.html']", "To include good...text differs", "To include good practices\nand ideas from successful\nEPAM project"},
                    {"a[href='contacts.html']", "To be flexible...text differs", "To be flexible and\ncustomizable"},
                    {"a.dropdown-toggle", "To be multiplatform...text differs", "To be multiplatform"},
                    {"a[href='metals-colors.html']", "Already have good base...text differs", "Already have good base\n"
                            + "(about 20 internal and\n"
                            + "some external projects),\nwish to get more…"}
            };
        }
//    @FindBy(css = "a[href='index.html']")
//    private WebElement homeButton;
//    @FindBy(css = "a[href='contacts.html']")
//    private WebElement contactFormButton;
//    @FindBy(css = "a.dropdown-toggle")
//    private WebElement serviceButton;
//    @FindBy(css = "a[href='metals-colors.html']")
//    private WebElement metalsColorsButton;
}
