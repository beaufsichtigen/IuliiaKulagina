package com.epam.tc.hw3.try1.testcases;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw3.try1.library.pages.HomePage;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.*;


public class Ex1 extends BaseTest {


    String userName = "Roman";
    String password = "Jdi1234";

    @Test

    public void ex1() {
        //SoftAssertions softly = new SoftAssertions();

        //1. Open test site by URL
        HomePage homePage = new HomePage(testDriver);

        //2. Assert Browser title
        String browserTitle = testDriver.getTitle();
       // softly.assertThat(browserTitle).as("Incorrect browser title").isEqualTo("Home Page");

        //3. Perform login
        homePage.login(userName, password);
        //assertThat(testDriver.getCurrentUrl()).as("Incorrect page opened").isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");

        //4. Assert Username is loggined

//        WebElement userName = driver.findElement(By.id("user-name"));
//        System.out.println(userName.getText());
//        softly.assertThat(userName.getText()).as("Incorrect user name").isEqualTo("ROMAN IOVLEV");
//
//        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
//        WebElement homeButton = driver.findElement(By.cssSelector("a[href='index.html']"));
//        System.out.println(homeButton.getText());
//        assertThat(homeButton.getText()).as("Incorrect Home button name").isEqualTo("HOME");
//
//        WebElement contactFormButton = driver.findElement(By.cssSelector("a[href='contacts.html']"));
//        softly.assertThat(contactFormButton.getText())
//                .as("Incorrect Contacts button name")
//                .isEqualTo("CONTACT FORM");
//
//        WebElement serviceButton = driver.findElement(By.cssSelector("a.dropdown-toggle"));
//        softly.assertThat(serviceButton.getText()).as("Incorrect Service button name").isEqualTo("SERVICE");
//
//        WebElement metalsColorsButton = driver.findElement(By.cssSelector("a[href='metals-colors.html']"));
//        softly.assertThat(metalsColorsButton.getText())
//                .as("Incorrect METALS & COLORS button name").isEqualTo("METALS & COLORS");
//
//        //6. Assert that there are 4 images on the Index Page and they are displayed
//        List<WebElement> icons = driver.findElements(By.cssSelector(".benefit-icon"));
//        softly.assertThat(icons.size()).as("Number of images are " + icons.size() + " not 4").isEqualTo(4);
//        softly.assertThat(icons).as("One or more image not displayed").isNotEmpty();
//        //other way: assertTrue(isImageDisplayed);
//
//        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
//        List<WebElement> iconTexts = driver.findElements(By.cssSelector(".benefit-txt"));
//        softly.assertThat(iconTexts.size())
//                .as("Number of texts are " + iconTexts.size() + " not 4").isEqualTo(4);
//        softly.assertThat(iconTexts.get(0).getText())
//                .as("To include good...text differs")
//                .isEqualTo("To include good practices\nand ideas from successful\nEPAM project");
//        softly.assertThat(iconTexts.get(1).getText())
//                .as("To be flexible...text differs").isEqualTo("To be flexible and\ncustomizable");
//        softly.assertThat(iconTexts.get(2).getText())
//                .as("To be multiplatform").isEqualTo("To be multiplatform");
//        softly.assertThat(iconTexts.get(3).getText())
//                .as("Already have good base...text differs")
//                .isEqualTo("Already have good base\n"
//                        + "(about 20 internal and\n"
//                        + "some external projects),\nwish to get more…");
//
//        //8. Assert that there is the iframe with “Frame Button” exist
//        int size = driver.findElements(By.tagName("iframe")).size();
//        System.out.println(size);
//        int buttonInCurrentFrame = 0; //count buttons “Frame Button” in current frame
//        int totalButtonsInFrames = 0; //counter of frames with button “Frame Button”
//        for (int i = 0; i < size; i++) {
//
//            //9. Switch to the iframe and check that there is “Frame Button” in the iframe
//            driver.switchTo().frame(i);
//            buttonInCurrentFrame = driver.findElements(By.cssSelector("input#frame-button")).size();
//
//            if (buttonInCurrentFrame > 0) {
//                totalButtonsInFrames = 0 + buttonInCurrentFrame;
//                WebElement frameButton = driver
//                        .findElement(By.cssSelector("input#frame-button"));
//                softly.assertThat(frameButton.getAttribute("value"))
//                        .as("Frame Button text differs")
//                        .isEqualTo("Frame Button");
//            }
//
//            System.out.println(buttonInCurrentFrame);
//            //softly.assertThat(buttonInCurrentFrame).as("No button “Frame Button”").isNotZero();
//
//            //10. Switch to original window back
//            driver.switchTo().defaultContent();
//        }
//        softly.assertThat(totalButtonsInFrames).as("Button not found").isNotZero();
//
//        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
//        List<WebElement> sidebarItems = driver.findElements(By.cssSelector(".sidebar-menu > li"));
//        softly.assertThat(sidebarItems.size())
//                .as("Number of menu items " + sidebarItems.size() + " not 5").isEqualTo(5);
//        softly.assertThat(sidebarItems.get(0)
//                .getText()).as("Home menu text differs").isEqualTo("Home");
//        softly.assertThat(sidebarItems.get(1)
//                .getText()).as("Contact form text differs").isEqualTo("Contact form");
//        softly.assertThat(sidebarItems.get(2)
//                .getText()).as("Service text differs").isEqualTo("Service");
//        softly.assertThat(sidebarItems.get(3)
//                .getText()).as("Metals & Colors text differs").isEqualTo("Metals & Colors");
//        softly.assertThat(sidebarItems.get(4)
//                .getText()).as("Elements text packs").isEqualTo("Elements packs");
//
//        softly.assertAll();
//
//        //12. Close Browser
//        driver.quit();
//
//    }

    }

}













