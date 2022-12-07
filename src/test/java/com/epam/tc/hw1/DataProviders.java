package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "sumData")
    public static Object[][] sumData() {
        return new Object[][]{
                {1, 2, 3},
                {0, 10, 10},
                {20, 20, 40}
        };
    }

    @DataProvider(name = "subsData")
    public static Object[][] subsData() {
        return new Object[][]{
                {1, 2, -1},
                {20, 0, 20},
                {8, 5, 3}
        };
    }

    @DataProvider(name = "divData")
    public static Object[][] divData() {
        return new Object[][]{
                {50, 2, 25},
                {7, 7, 1},
                {30, 10, 3}};
    }

    @DataProvider(name = "multData")
    public static Object[][] multData() {
        return new Object[][]{
                {0, 100, 0},
                {10, 20, 200},
                {7, 7, 49}};
    }


}
