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


    @DataProvider(name = "DiffElementsCheckboxes")
    public static Object[][] diffElementsCheckboxes() {
        return new Object[][]{

                //item //parametr //isSelected
                {0, "Water", true},
                {1, "Earth", true},
                {2, "Wind", true},
                {3, "Fire", true}

        };
    }


}

