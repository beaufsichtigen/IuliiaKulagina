package com.epam.tc.hw6.testcases;

import static com.epam.tc.hw4.pages.DifElementsPage.CheckboxElement.Water;
import static com.epam.tc.hw4.pages.DifElementsPage.CheckboxElement.Wind;
import static com.epam.tc.hw4.pages.DifElementsPage.Color.Yellow;
import static com.epam.tc.hw4.pages.DifElementsPage.Metal.Selen;

import com.epam.tc.hw3.library.utils.GetProperties;
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
        step.accertBrowserTitle("Home Page");

        //3. Perform login
        GetProperties getProperties = new GetProperties();
        step.performLogin(getProperties.getUsernameProp(), getProperties.getPasswordProp());

        //4. Assert Username is loggined
        step.assertUsernameLoggedIn(getProperties.getUsernameTextProp());

        //5. Open through the header menu Service -> Different Elements Page
        step.assertDifferentElementsPageOpens();

        //6. Select checkboxes Water, Wind
        step.assertCheckboxesSelected(Water);
        step.assertCheckboxesSelected(Wind);

        //7. Select radio Selen
        step.assertRadioSelected(Selen);

        //8. Select in dropdown Yellow
        step.assertDropdownSelected(Yellow);

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
