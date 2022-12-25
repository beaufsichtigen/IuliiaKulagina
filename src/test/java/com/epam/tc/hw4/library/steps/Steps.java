package com.epam.tc.hw4.library.steps;

import com.epam.tc.hw3.library.pages.DifElementsPage;
import com.epam.tc.hw3.library.pages.Header;
import com.epam.tc.hw3.library.pages.HomePage;
import com.epam.tc.hw3.library.pages.SideBar;
import com.epam.tc.hw3.library.utils.GetProperties;
import io.qameta.allure.Step;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Steps extends AbstractStep {

    private Header header;
    private SideBar sideBar;
    private HomePage homePage;
    private DifElementsPage difElementsPage;

    public Steps(WebDriver driver) {
        super(driver);
        header = new Header(driver);
        homePage = new HomePage(driver);
        sideBar = new SideBar(driver);
        difElementsPage = new DifElementsPage(driver);
    }

    @Step("2. Assert Browser title")
    public void accertBrowserTitle() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(driver.getTitle()).as("Incorrect browser title").isEqualTo("Home Page");
        softly.assertAll();
    }

    @Step("3. Perform login")
    public void performLogin() {
        SoftAssertions softly = new SoftAssertions();
        GetProperties getProperties = new GetProperties();
        header.login(getProperties.getUsernameProp(), getProperties.getPasswordProp());
        softly.assertThat(driver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");
        softly.assertAll();
    }

    @Step("4. Assert Username is loggined")
    public void assertUsernameLoggedIn() {
        SoftAssertions softly = new SoftAssertions();
        GetProperties getProperties = new GetProperties();
        softly.assertThat(header.getUserNameText())
                .as("Incorrect user name")
                .isEqualTo(getProperties.getUsernameTextProp());
        softly.assertAll();
    }

    @Step("5. Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertHeaderItems() {
        SoftAssertions softly = new SoftAssertions();
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

    @Step("6. Assert that there are 4 images on the Index Page and they are displayed")
    public void assertIndexPageImages() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(homePage.numberOfBenefitImages())
                .as("Number of images are " + homePage.numberOfBenefitImages() + " not 4")
                .isEqualTo(4);
        for (WebElement icon : homePage.getBenefitImages()) {
            softly.assertThat(icon.isDisplayed()).as("One or more image not displayed").isTrue();
        }
        softly.assertAll();

    }

    @Step("7. Assert that there are 4 texts on the Index Page under icons and they have proper text")

    public void assertIndexPageTextsUnderImages() {
        SoftAssertions softly = new SoftAssertions();
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
        softly.assertAll();
    }

    @Step("8. Assert that there is the iframe with “Frame Button” exist and  "
            + "9. Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void assertIframesFrameButtonExistAndHaveButton() {
        SoftAssertions softly = new SoftAssertions();
        int size = homePage.getIframes().size();
        System.out.println(size);
        int buttonInCurrentFrame = 0; //count buttons “Frame Button” in current frame
        int totalButtonsInFrames = 0; //counter of frames with button “Frame Button”
        for (int i = 0; i < size; i++) {

            //9. Switch to the iframe and check that there is “Frame Button” in the iframe
            driver.switchTo().frame(i);
            buttonInCurrentFrame = homePage.getFrameButtons().size();

            if (buttonInCurrentFrame > 0) {
                totalButtonsInFrames = totalButtonsInFrames + buttonInCurrentFrame;
                softly.assertThat(homePage.getCurrentFrameButton().getAttribute("value"))
                        .as("Frame Button text differs")
                        .isEqualTo("Frame Button");
            }

            System.out.println(buttonInCurrentFrame);
            driver.switchTo().defaultContent();
        }
        softly.assertAll();
    }

    @Step("10. Switch to original window back")
    public void switchToOriginalWindowFromIframe() {
        driver.switchTo().defaultContent();
    }

    @Step("11. Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void assertItemsInSidebar() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(sideBar.getSidebarItems().size())
                .as("Number of menu items " + sideBar.getSidebarItems().size() + " not 5")
                .isEqualTo(5);

        List<String> sidebarItemsTextExpected = Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors",
                "Elements packs"
        );

        List<String> sidebarItemsTextActual = sideBar.getSidebarItems().stream().map(WebElement::getText)
                .collect(Collectors.toList());
        softly.assertThat(sidebarItemsTextActual).as("Sidebar items text differs").isEqualTo(sidebarItemsTextExpected);

        softly.assertAll();
    }

    @Step("5. Open through the header menu Service -> Different Elements Page")
    public void assertDifferentElementsPageOpens() {
        header.getServiceButton().click();
        header.getDifElements().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(driver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");
    }

    @Step("6. Select checkboxes Water, Wind")
    public void assertCheckboxesWaterWindSelected() {
        SoftAssertions softly = new SoftAssertions();
        DifElementsPage difElementsPage = PageFactory.initElements(driver, DifElementsPage.class);
        difElementsPage.clickWebElement(difElementsPage.getCheckboxWater());
        difElementsPage.clickWebElement(difElementsPage.getCheckboxWater());
        softly.assertThat(difElementsPage.getCheckboxWater()
                        .isEnabled()).as("Check box 'Water' was not enabled")
                .isTrue();
        softly.assertThat(difElementsPage.getCheckboxWater()
                        .isEnabled()).as("Check box 'Wind' was not enabled")
                .isTrue();
    }

    @Step("7. Select radio Selen")
    public void assertRadioSelenSelected() {
        SoftAssertions softly = new SoftAssertions();
        difElementsPage.clickWebElement(difElementsPage.getRadioBtnSelen());
        softly.assertThat(difElementsPage.getRadioBtnSelen()
                .isEnabled()).as("Incorrect radio button state").isTrue();
    }

    @Step("8. Select in dropdown Yellow")
    public void assertDropdownYellowSelected() {
        SoftAssertions softly = new SoftAssertions();
        difElementsPage.chooseFromClosedDropdown(difElementsPage.getDropDownYellow());
        softly.assertThat(difElementsPage.getDropDownYellow()
                .isSelected()).as("Incorrect drop down state").isTrue();
    }

    //9. Assert that
    @Step("9.1. for each checkbox there is an individual log row and value is corresponded to the status of checkbox")
    public void assertLogForEveryCheckbox() {
        SoftAssertions softly = new SoftAssertions();
        driver.navigate().refresh(); //clean all elements state

        for (WebElement checkbox : difElementsPage.getAllCheckboxes()) {
            checkbox.click();
            String checkboxName = checkbox.getText();
            System.out.println(difElementsPage.getLastLogText());
            softly.assertThat(difElementsPage.getLastLogText())
                    .as("Incorrect log text")
                    .endsWith(checkboxName + ": condition changed to " + checkbox.isSelected());

            checkbox.click();
            System.out.println(difElementsPage.getLastLogText());
            softly.assertThat(difElementsPage.getLastLogText())
                    .as("Incorrect log text")
                    .endsWith(checkboxName + ": condition changed to " + checkbox.isSelected());
        }
        softly.assertAll();
    }


    @Step("9.2. for radio button there is a log row and value is corresponded to the status of radio button")
    public void assertLogForEveryRadiobutton() {
        SoftAssertions softly = new SoftAssertions();
        driver.navigate().refresh(); //clean all elements state

        for (WebElement radiobutton : difElementsPage.getAllradiobuttons()) {
            radiobutton.click();
            System.out.println(difElementsPage.getLastLogText());
            softly.assertThat(difElementsPage.getLastLogText())
                    .as("Incorrect log text").endsWith("metal: value changed to " + radiobutton.getText());
        }
        softly.assertAll();
    }

    @Step("9.3. for dropdown there is a log row and value is corresponded to the selected value.")
    public void assertLogForEveryDropdownValue() {
        SoftAssertions softly = new SoftAssertions();
        driver.navigate().refresh(); //clean all elements state

        difElementsPage.chooseFromClosedDropdown(difElementsPage.getDropDownYellow());
        for (WebElement dropDownElement : difElementsPage.getAlldropDown()) {
            dropDownElement.click();
            System.out.println(difElementsPage.getLastLogText());
            softly.assertThat(difElementsPage.getLastLogText())
                    .as("Incorrect log text")
                    .endsWith("Colors: value changed to " + dropDownElement.getText());
        }
        softly.assertAll();
    }
}
