package com.epam.tc.hw4.library.data;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "DiffElementsCheckboxesTrue")
    public static Object[][] diffElementsCheckboxesTrue() {
        return new Object[][]{

                //item //parameter //isSelected
                {0, "Water", true},
                {1, "Earth", true},
                {2, "Wind", true},
                {3, "Fire", true}

        };
    }

    @DataProvider(name = "DiffElementsCheckboxesFalse")
    public static Object[][] diffElementsCheckboxesFalse() {
        return new Object[][]{

                //item //parameter //isSelected
                {0, "Water", false},
                {1, "Earth", false},
                {2, "Wind", false},
                {3, "Fire", false}

        };
    }

    @DataProvider(name = "DiffElementsRadiobutton")
    public static Object[][] diffElementsRadiobutton() {
        return new Object[][]{

                //item //parameter
                {0, "Gold"},
                {1, "Silver"},
                {2, "Bronze"},
                {3, "Selen"}

        };
    }

    @DataProvider(name = "DiffElementsDropdown")
    public static Object[][] diffElementsDropdown() {
        return new Object[][]{

                //item //parameter
                {1, "Green"},
                {2, "Blue"},
                {3, "Yellow"},
                {0, "Red"}

        };
    }



}

