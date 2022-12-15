package com.epam.tc.hw3.try1.testcases;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw3.try1.library.pages.HomePage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


public class Ex1 extends BaseTest {


    String userName = "Roman";
    String password = "Jdi1234";



    @Test

    public void login() {

        SoftAssertions softly = new SoftAssertions();

        //1. Open test site by URL
        HomePage homePage = new HomePage(testDriver);

        //2. Assert Browser title
        String browserTitle = testDriver.getTitle();
        softly.assertThat(browserTitle).as("Incorrect browser title").isEqualTo("Home Page");

        //3. Perform login
        homePage.login(userName, password);
        assertThat(testDriver.getCurrentUrl()).as("Incorrect page opened").isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");

        //4. Assert Username is loggined
        softly.assertThat(homePage.getUserNameText()).as("Incorrect user name").isEqualTo("ROMAN IOVLEV");


        //5. Assert that there are 4 items on the header section are displayed and they have proper texts

        softly.assertThat(homePage.getHomeButtonText()).as("Incorrect Home button name").isEqualTo("HOME");
        softly.assertThat(homePage.getContactFormButtonText())
                .as("Incorrect Contacts button name")
                .isEqualTo("CONTACT FORM");

        softly.assertThat(homePage.getServiceButtonText()).as("Incorrect Service button name").isEqualTo("SERVICE");

        softly.assertThat(homePage.getMetalsColorsButtonText())
                .as("Incorrect METALS & COLORS button name").isEqualTo("METALS & COLORS");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        softly.assertThat(homePage.numberOfBenefitImages()).as("Number of images are " + homePage.numberOfBenefitImages() + " not 4").isEqualTo(4);
        softly.assertThat(homePage.getBenefitImages()).as("One or more image not displayed").isNotEmpty();


        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text

        softly.assertThat(homePage.numberOfBenefitImagesText())
                .as("Number of texts are " + homePage.numberOfBenefitImagesText() + " not 4").isEqualTo(4);
        softly.assertThat(homePage.getBenefitImagesText().get(0).getText())
                .as("To include good...text differs")
                .isEqualTo("To include good practices\nand ideas from successful\nEPAM project");
        softly.assertThat(homePage.getBenefitImagesText().get(1).getText())
                .as("To be flexible...text differs").isEqualTo("To be flexible and\ncustomizable");
        softly.assertThat(homePage.getBenefitImagesText().get(2).getText())
                .as("To be multiplatform").isEqualTo("To be multiplatform");
        softly.assertThat(homePage.getBenefitImagesText().get(3).getText())
                .as("Already have good base...text differs")
                .isEqualTo("Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\nwish to get more…");
//
        //8. Assert that there is the iframe with “Frame Button” exist
        int size = homePage.getIframes().size();
        System.out.println(size);
        int buttonInCurrentFrame = 0; //count buttons “Frame Button” in current frame
        int totalButtonsInFrames = 0; //counter of frames with button “Frame Button”
        for (int i = 0; i < size; i++) {

            //9. Switch to the iframe and check that there is “Frame Button” in the iframe
            testDriver.switchTo().frame(i);
            buttonInCurrentFrame = testDriver.findElements(By.cssSelector("input#frame-button")).size();

            if (buttonInCurrentFrame > 0) {
                totalButtonsInFrames = 0 + buttonInCurrentFrame;
                WebElement frameButton = testDriver
                        .findElement(By.cssSelector("input#frame-button"));
                softly.assertThat(frameButton.getAttribute("value"))
                        .as("Frame Button text differs")
                        .isEqualTo("Frame Button");
            }

            System.out.println(buttonInCurrentFrame);
            //softly.assertThat(buttonInCurrentFrame).as("No button “Frame Button”").isNotZero();

        }













//
//            testDriver.switchTo().frame(i);
//            buttonInCurrentFrame = homePage.getFrameButtons().size();
//
//            if (buttonInCurrentFrame > 0) {
//                totalButtonsInFrames = 0 + buttonInCurrentFrame;
//                softly.assertThat(homePage.getCurrentFrameButton().getAttribute("value"))
//                        .as("Frame Button text differs")
//                        .isEqualTo("Frame Button");
//            }}
//
//            System.out.println(totalButtonsInFrames);
//            softly.assertThat(totalButtonsInFrames).as("No button “Frame Button”").isNotZero();
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
        softly.assertAll();
//
//        //12. Close Browser
//        driver.quit();
//
//    }

    }

}













