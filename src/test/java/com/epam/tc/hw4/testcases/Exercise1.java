package com.epam.tc.hw4.testcases;

import com.epam.tc.hw4.utils.GetProperties;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class Exercise1 extends BaseTest {

    //1. Open test site by URL - in parent class
    @Test
    @Feature("Exercise1: checking Index page, Sidebar, Frames")
    @Story("Story UE-5555555")

    public void exercise1() {

        //2. Assert Browser title
        step.accertBrowserTitle("Home Page");

        //3. Perform login
        GetProperties getProperties = new GetProperties();
        step.performLogin(getProperties.getUsernameProp(), getProperties.getPasswordProp());

        //4. Assert Username is loggined

        step.assertUsernameLoggedIn(getProperties.getUsernameTextProp());
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        step.assertHeaderItems();

        //6. Assert that there are 4 images on the Index Page and they are displayed
        step.assertIndexPageImages();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        step.assertIndexPageTextsUnderImages();

        //8. Assert that there is the iframe with “Frame Button” exist
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        step.assertIframesFrameButtonExistAndHaveButton();

        //10. Switch to original window back
        step.switchToOriginalWindowFromIframe();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        step.assertItemsInSidebar();

        //12. Close Browser (in Parent class)
    }
}
