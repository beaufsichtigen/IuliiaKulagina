package com.epam.tc.hw4.library.steps;

import static com.epam.tc.hw4.pages.DifElementsPage.Color.Yellow;

import com.epam.tc.hw4.pages.DifElementsPage;
import com.epam.tc.hw4.pages.HomePage;
import io.qameta.allure.Step;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Steps extends AbstractStep {

    private HomePage homePage;
    private DifElementsPage difElementsPage;

    public Steps(WebDriver driver) {
        super(driver);
        homePage = new HomePage(driver);
        difElementsPage = new DifElementsPage(driver);
    }

    @Step("2. Assert Browser title")
    public void accertBrowserTitle(String expectedTitle) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(driver.getTitle()).as("Incorrect browser title").isEqualTo(expectedTitle);
        softly.assertAll();
    }

    @Step("3. Perform login")
    public void performLogin(String username, String login) {
        SoftAssertions softly = new SoftAssertions();
        anyPage.getHeader().login(username, login);
        softly.assertThat(driver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/index.html");
        softly.assertAll();
    }

    @Step("4. Assert Username is loggined")
    public void assertUsernameLoggedIn(String expectedUserName) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(anyPage.getHeader().getUserNameText())
                .as("Incorrect user name")
                .isEqualTo(expectedUserName);
        softly.assertAll();
    }

    @Step("5. Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertHeaderItems() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(anyPage.getHeader().getHomeButtonText())
                .as("Incorrect Home button name")
                .isEqualTo("HOME");

        softly.assertThat(anyPage.getHeader().getContactFormButtonText())
                .as("Incorrect Contacts button name")
                .isEqualTo("CONTACT FORM");

        softly.assertThat(anyPage.getHeader().getServiceButtonText())
                .as("Incorrect Service button name").isEqualTo("SERVICE");

        softly.assertThat(anyPage.getHeader().getMetalsColorsButtonText())
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
        softly.assertThat(anyPage.getSideBar().getSidebarItems().size())
                .as("Number of menu items " + anyPage.getSideBar().getSidebarItems().size() + " not 5")
                .isEqualTo(5);

        List<String> sidebarItemsTextExpected = Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors",
                "Elements packs"
        );

        List<String> sidebarItemsTextActual = anyPage.getSideBar().getSidebarItems().stream().map(WebElement::getText)
                .collect(Collectors.toList());
        softly.assertThat(sidebarItemsTextActual).as("Sidebar items text differs").isEqualTo(sidebarItemsTextExpected);

        softly.assertAll();
    }

    @Step("5. Open through the header menu Service -> Different Elements Page")
    public void assertDifferentElementsPageOpens() {
        anyPage.getHeader().getServiceButton().click();
        anyPage.getHeader().getDifElements().click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("uui-main-container")));
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(driver.getCurrentUrl())
                .as("Incorrect page opened")
                .isEqualTo("https://jdi-testing.github.io/jdi-light/different-elements.html");
        softly.assertAll();
    }

    @Step("6. Select checkboxes {element}")
    public void assertCheckboxesSelected(com.epam.tc.hw4.pages.DifElementsPage.CheckboxElement element) {
        SoftAssertions softly = new SoftAssertions();
        difElementsPage.clickCheckbox(element);
        softly.assertThat(difElementsPage.getCheckbox(element).isEnabled())
                .as("Check box " + element + " was not enabled")
                .isTrue();
        softly.assertAll();
    }

    @Step("7. Select radio {metal}")
    public void assertRadioSelected(DifElementsPage.Metal metal) {
        SoftAssertions softly = new SoftAssertions();
        difElementsPage.clickWebElement(difElementsPage.getRadioBtn(metal));
        softly.assertThat(difElementsPage.getRadioBtn(metal)
                .isEnabled()).as("Incorrect radio button state").isTrue();
        softly.assertAll();
    }

    @Step("8. Select in dropdown {color}")
    public void assertDropdownSelected(DifElementsPage.Color color) {
        SoftAssertions softly = new SoftAssertions();
        difElementsPage.chooseFromClosedDropdown(color);
        softly.assertThat(difElementsPage.getDropDown(color)
                .isSelected()).as("Incorrect drop down state").isTrue();
        softly.assertAll();
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

        difElementsPage.chooseFromClosedDropdown(Yellow);
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
