package com.epam.tc.hw3.testcases;

import com.epam.tc.hw3.library.pages.Header;
import com.epam.tc.hw3.library.pages.HomePage;
import com.epam.tc.hw3.library.pages.SideBar;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;


public class Ex1v2 extends BaseTest {



    //1. Open test site by URL - in parent class

    @Test(priority = 0)
    public void titleAssert() {
        //2. Assert Browser title
        SoftAssertions softly = new SoftAssertions();
        String browserTitle = testDriver.getTitle();
        softly.assertThat(browserTitle).as("Incorrect browser title").isEqualTo("Home Page");
        softly.assertAll();
    }

    @Test(priority = 1)
    public void loginAssert() {
        SoftAssertions softly = new SoftAssertions();
        Header header = new Header(testDriver);

        //3. Perform login
        header.login();
        softly.assertThat(testDriver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");

        //4. Assert Username is loggined
        softly.assertThat(header.getUserNameText())
                .as("Incorrect user name")
                .isEqualTo("ROMAN IOVLEV");

        softly.assertAll();
    }

    @Test(priority = 2)
    public void headerAssert() {
        SoftAssertions softly = new SoftAssertions();
        Header header = new Header(testDriver);

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts

        softly.assertThat(header.getHomeButtonText())
                .as("Incorrect Home button name")
                .isEqualTo("HOME");
        softly.assertThat(header.getContactFormButtonText())
                .as("Incorrect Contacts button name")
                .isEqualTo("CONTACT FORM");

        softly.assertThat(header.getServiceButtonText())
                .as("Incorrect Service button name").isEqualTo("SERVICE");

        softly.assertThat(header.getMetalsColorsButtonText())
                .as("Incorrect METALS & COLORS button name").isEqualTo("METALS & COLORS");

        softly.assertAll();
    }

    @Test(priority = 2)
    public void iconsAssert() {
        SoftAssertions softly = new SoftAssertions();

        //6. Assert that there are 4 images on the Index Page and they are displayed
        HomePage homePage = new HomePage(testDriver);
        softly.assertThat(homePage.numberOfBenefitImages())
                .as("Number of images are " + homePage.numberOfBenefitImages() + " not 4")
                .isEqualTo(4);
        softly.assertThat(homePage.getBenefitImages())
                .as("One or more image not displayed").isNotEmpty();

        softly.assertAll();
    }

    @Test(priority = 2)
    public void iconsTextAssert() {
        SoftAssertions softly = new SoftAssertions();
        HomePage homePage = new HomePage(testDriver);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softly.assertThat(homePage.numberOfBenefitImagesText())
                .as("Number of texts are " + homePage.numberOfBenefitImagesText() + " not 4")
                .isEqualTo(4);
        softly.assertThat(homePage.getBenefitImagesText().get(0).getText())
                .as("To include good...text differs")
                .isEqualTo("To include good practices\nand ideas from successful\nEPAM project");
        softly.assertThat(homePage.getBenefitImagesText().get(1).getText())
                .as("To be flexible...text differs")
                .isEqualTo("To be flexible and\ncustomizable");
        softly.assertThat(homePage.getBenefitImagesText().get(2).getText())
                .as("To be multiplatform")
                .isEqualTo("To be multiplatform");
        softly.assertThat(homePage.getBenefitImagesText().get(3).getText())
                .as("Already have good base...text differs")
                .isEqualTo("Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\nwish to get more…");

        softly.assertAll();
    }

    @Test(priority = 2)
    public void framesAssert() {
        SoftAssertions softly = new SoftAssertions();
        HomePage homePage = new HomePage(testDriver);

        //8. Assert that there is the iframe with “Frame Button” exist
        int size = homePage.getIframes().size();
        System.out.println(size);
        int buttonInCurrentFrame = 0; //count buttons “Frame Button” in current frame
        int totalButtonsInFrames = 0; //counter of frames with button “Frame Button”
        for (int i = 0; i < size; i++) {

            //9. Switch to the iframe and check that there is “Frame Button” in the iframe
            testDriver.switchTo().frame(i);
            buttonInCurrentFrame = homePage.getFrameButtons().size();

            if (buttonInCurrentFrame > 0) {
                totalButtonsInFrames = buttonInCurrentFrame;
                softly.assertThat(homePage.getCurrentFrameButton().getAttribute("value"))
                        .as("Frame Button text differs")
                        .isEqualTo("Frame Button");
            }

            System.out.println(buttonInCurrentFrame);

            //10. Switch to original window back
            testDriver.switchTo().defaultContent();
        }
        softly.assertThat(totalButtonsInFrames).as("Button not found").isNotZero();

        softly.assertAll();
    }

    @Test(priority = 2)
    public void leftMenuAssert() {
        SoftAssertions softly = new SoftAssertions();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        SideBar sideBar = new SideBar(testDriver);
        softly.assertThat(sideBar.getSidebarItems().size())
                .as("Number of menu items " + sideBar.getSidebarItems().size() + " not 5")
                .isEqualTo(5);
        softly.assertThat(sideBar.getSidebarItems().get(0)
                        .getText())
                .as("Home menu text differs")
                .isEqualTo("Home");
        softly.assertThat(sideBar.getSidebarItems().get(1)
                        .getText())
                .as("Contact form text differs")
                .isEqualTo("Contact form");
        softly.assertThat(sideBar.getSidebarItems().get(2)
                        .getText())
                .as("Service text differs")
                .isEqualTo("Service");
        softly.assertThat(sideBar.getSidebarItems().get(3)
                        .getText())
                .as("Metals & Colors text differs")
                .isEqualTo("Metals & Colors");
        softly.assertThat(sideBar.getSidebarItems().get(4)
                        .getText())
                .as("Elements text packs")
                .isEqualTo("Elements packs");

        softly.assertAll();
    }

    //12. Close Browser (in Parent class)

}













