package com.epam.tc.hw3.testcases;

import com.epam.tc.hw3.library.pages.HomePage;
import com.epam.tc.hw3.library.utils.GetProperties;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Exercise1 extends BaseTest {

    //1. Open test site by URL - in parent class
    @Test
    public void exercise1() {
        //2. Assert Browser title
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(testDriver.getTitle()).as("Incorrect browser title").isEqualTo("Home Page");
        HomePage homePage = new HomePage(testDriver);

        //3. Perform login
        GetProperties getProperties = new GetProperties();
        homePage.getHeader().login(getProperties.getUsernameProp(), getProperties.getPasswordProp());
        softly.assertThat(testDriver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");

        //4. Assert Username is loggined
        softly.assertThat(homePage.getHeader().getUserNameText())
                .as("Incorrect user name")
                .isEqualTo(getProperties.getUsernameTextProp());

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        softly.assertThat(homePage.getHeader().getHomeButtonText())
                .as("Incorrect Home button name")
                .isEqualTo("HOME");

        softly.assertThat(homePage.getHeader().getContactFormButtonText())
                .as("Incorrect Contacts button name")
                .isEqualTo("CONTACT FORM");

        softly.assertThat(homePage.getHeader().getServiceButtonText())
                .as("Incorrect Service button name").isEqualTo("SERVICE");

        softly.assertThat(homePage.getHeader().getMetalsColorsButtonText())
                .as("Incorrect METALS & COLORS button name").isEqualTo("METALS & COLORS");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        softly.assertThat(homePage.numberOfBenefitImages())
                .as("Number of images are " + homePage.numberOfBenefitImages() + " not 4")
                .isEqualTo(4);
        for (WebElement icon : homePage.getBenefitImages()) {
            softly.assertThat(icon.isDisplayed()).as("One or more image not displayed").isTrue();
        }

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        softly.assertThat(homePage.numberOfBenefitImagesText())
                .as("Number of texts are " + homePage.numberOfBenefitImagesText() + " not 4")
                .isEqualTo(4);

        List<String> textUnderImagesExpected = Arrays.asList(
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\nwish to get more…"
        );

        List<String> textUnderImagesActual = homePage.getBenefitImagesText().stream().map(WebElement::getText)
                .collect(Collectors.toList());
        softly.assertThat(textUnderImagesActual).as("Text under icon differs").isEqualTo(textUnderImagesExpected);

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
                totalButtonsInFrames = totalButtonsInFrames + buttonInCurrentFrame;
                softly.assertThat(homePage.getCurrentFrameButton().getAttribute("value"))
                        .as("Frame Button text differs")
                        .isEqualTo("Frame Button");
            }

            System.out.println(buttonInCurrentFrame);

            //10. Switch to original window back
            testDriver.switchTo().defaultContent();
        }
        softly.assertThat(totalButtonsInFrames).as("Button not found").isNotZero();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        softly.assertThat(homePage.getSideBar().getSidebarItems().size())
                .as("Number of menu items " + homePage.getSideBar().getSidebarItems().size() + " not 5")
                .isEqualTo(5);

        List<String> sidebarItemsTextExpected = Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors",
                "Elements packs"
        );

        List<String> sidebarItemsTextActual = homePage.getSideBar().getSidebarItems().stream().map(WebElement::getText)
                .collect(Collectors.toList());
        softly.assertThat(sidebarItemsTextActual).as("Sidebar items text differs").isEqualTo(sidebarItemsTextExpected);

        softly.assertAll();
    }
    //12. Close Browser (in Parent class)
}

