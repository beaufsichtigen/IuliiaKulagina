package com.epam.tc.hw4.testcases;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class Exercise2 extends BaseTest {

    //1. Open test site by URL - in parent class
    @Test
    @Feature("Exercise2: checking Different Elements Page")
    @Story("Story UE-5555556")
    public void exercise2() {

        //2. Assert Browser title
        step.accertBrowserTitle();

        //3. Perform login
        step.performLogin();

        //4. Assert Username is loggined
        step.assertUsernameLoggedIn();

        //5. Open through the header menu Service -> Different Elements Page
        step.assertDifferentElementsPageOpens();

        //6. Select checkboxes Water, Wind
        step.assertCheckboxesWaterWindSelected();

        //7. Select radio Selen
        step.assertRadioSelenSelected();

        //8. Select in dropdown Yellow
        step.assertDropdownYellowSelected();

        //9. Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        step.assertLogForEveryCheckbox();

        //• for radio button there is a log row and value is corresponded to the status of radio button
        step.assertLogForEveryRadiobutton();

        //• for dropdown there is a log row and value is corresponded to the selected value.
        step.assertLogForEveryDropdownValue();
    }
    //10. Close Browser in parent class
}
