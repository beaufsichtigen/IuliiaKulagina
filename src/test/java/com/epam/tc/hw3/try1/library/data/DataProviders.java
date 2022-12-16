package com.epam.tc.hw3.try1.library.data;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "headerData")
    public static Object[][] headerData() {
        return new Object[][]{

                //selector //description //expected result
                {"a[href='index.html']", "To include good...text differs", "To include good practices\nand ideas from successful\nEPAM project"},
                {"a[href='contacts.html']", "To be flexible...text differs", "To be flexible and\ncustomizable"},
                {"a.dropdown-toggle", "To be multiplatform...text differs", "To be multiplatform"},
                {"a[href='metals-colors.html']", "Already have good base...text differs", "Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\nwish to get more…"}
        };
    }


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

