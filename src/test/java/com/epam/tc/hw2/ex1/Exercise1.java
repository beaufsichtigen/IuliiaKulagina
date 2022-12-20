package com.epam.tc.hw2.ex1;


import com.epam.tc.hw2.BaseTest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;




public class Exercise1 extends BaseTest {



    @Test
    //1. Open test site by URL
    public void checkHomePage() {

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(driver.getCurrentUrl()).as("Incorrect page opened").isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Browser title
        String browserTitle = driver.getTitle();
        softly.assertThat(browserTitle).as("Incorrect browser title").isEqualTo("Home Page");

        //3. Perform login
        WebElement userIcon = driver.findElement(By.id("user-icon"));
        userIcon.click();
        WebElement login = driver.findElement(By.id("name"));
        login.sendKeys("Roman");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Jdi1234");
        WebElement enterButton = driver.findElement(By.id("login-button"));
        enterButton.click();

        //4. Assert Username is loggined
        WebElement userName = driver.findElement(By.id("user-name"));
        System.out.println(userName.getText());
        softly.assertThat(userName.getText()).as("Incorrect user name").isEqualTo("ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement homeButton = driver.findElement(By.cssSelector("a[href='index.html']"));
        System.out.println(homeButton.getText());
        softly.assertThat(homeButton.getText()).as("Incorrect Home button name").isEqualTo("HOME");

        WebElement contactFormButton = driver.findElement(By.cssSelector("a[href='contacts.html']"));
        softly.assertThat(contactFormButton.getText())
                .as("Incorrect Contacts button name")
                .isEqualTo("CONTACT FORM");

        WebElement serviceButton = driver.findElement(By.cssSelector("a.dropdown-toggle"));
        softly.assertThat(serviceButton.getText()).as("Incorrect Service button name").isEqualTo("SERVICE");

        WebElement metalsColorsButton = driver.findElement(By.cssSelector("a[href='metals-colors.html']"));
        softly.assertThat(metalsColorsButton.getText())
                .as("Incorrect METALS & COLORS button name").isEqualTo("METALS & COLORS");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> icons = driver.findElements(By.cssSelector(".benefit-icon"));


        softly.assertThat(icons.size()).as("Number of images are " + icons.size() + " not 4").isEqualTo(4);
        for (WebElement icon : icons) {
            softly.assertThat(icon.isDisplayed()).as("One or more image not displayed").isTrue();
        }

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text

        List<WebElement> iconTexts = driver.findElements(By.cssSelector(".benefit-txt"));
        softly.assertThat(iconTexts.size()).as("Number of images are " + iconTexts.size() + " not 4").isEqualTo(4);
        List<String> textUnderImagesExpected = Arrays.asList(
                "To include good practices\nand ideas from successful\nEPAM project",
                "To be flexible and\ncustomizable",
                "To be multiplatform",
                "Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\nwish to get more…"
        );

        List<String> textUnderImagesActual = iconTexts.stream()
                .map(WebElement::getText).collect(Collectors.toList());
        //или iconTexts.stream().map(WebElement::getText).forEach(textUnderImagesActual::add);
        softly.assertThat(textUnderImagesActual).as("Text under icon differs").isEqualTo(textUnderImagesExpected);


        //8. Assert that there is the iframe with “Frame Button” exist
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);
        int buttonInCurrentFrame = 0; //count buttons “Frame Button” in current frame
        int totalButtonsInFrames = 0; //counter of frames with button “Frame Button”
        for (int i = 0; i < size; i++) {

            //9. Switch to the iframe and check that there is “Frame Button” in the iframe
            driver.switchTo().frame(i);
            buttonInCurrentFrame = driver.findElements(By.cssSelector("input#frame-button")).size();
            if (buttonInCurrentFrame > 0) {
                totalButtonsInFrames = totalButtonsInFrames + buttonInCurrentFrame;
                WebElement frameButton = driver
                        .findElement(By.cssSelector("input#frame-button"));
                softly.assertThat(frameButton.getAttribute("value"))
                        .as("Frame Button text differs")
                        .isEqualTo("Frame Button");
            }

            System.out.println("frame " + i + ". Number of buttons = " + buttonInCurrentFrame);

            //10. Switch to original window back
            driver.switchTo().defaultContent();
        }
        System.out.println("totalButtonsInFrames = " + totalButtonsInFrames);
        softly.assertThat(totalButtonsInFrames).as("Button not found").isNotZero();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sidebarItems = driver.findElements(By.cssSelector(".sidebar-menu > li"));
        softly.assertThat(sidebarItems.size())
                .as("Number of menu items " + sidebarItems.size() + " not 5").isEqualTo(5);
        List<String> sidebarItemsTextExpected = Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors",
                "Elements packs"
        );


        List<String> sidebarItemsTextActual = sidebarItems
                .stream().map(WebElement::getText).collect(Collectors.toList());

        //List<String> sidebarItemsTextActual = new ArrayList<>();
        //sidebarItems.stream().map(WebElement::getText).forEach(sidebarItemsTextActual::add);

        softly.assertThat(sidebarItemsTextActual)
                .as("Sidebar items text differs").isEqualTo(sidebarItemsTextExpected);
        

        softly.assertAll();

    }

}

