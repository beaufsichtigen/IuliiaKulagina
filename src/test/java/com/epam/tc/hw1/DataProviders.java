package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "sumDataLong")
    public static Object[][] sumDataLong() {
        return new Object[][]{
                {1, 2, 3},
                {0, 10, 10},
                {20, 20, 40},
                {-20, 20, 0},
                {4611686018427387903L, 4611686018427387903L, 9223372036854775806L}
        };
    }

    @DataProvider(name = "sumDataDouble")
    public static Object[][] sumDataDouble() {
        return new Object[][]{
                {1, 2, 3},
                {0, 10, 10},
                {20, 20, 40},
                {-20, 20, 0},
                {922337203685477580666D, 1D, 922337203685477580667D}
        };
    }

    @DataProvider(name = "subsDataLong")
    public static Object[][] subsDataLong() {
        return new Object[][]{
                {1L, 2L, -1L},
                {20, 0, 20},
                {8, 5, 3},
                {8, -5, 13},
                {9223372036854775806L, 4611686018427387903L, 4611686018427387903L}
        };
    }

    @DataProvider(name = "subsDataDouble")
    public static Object[][] subsDataDouble() {
        return new Object[][]{
                {1L, 2L, -1L},
                {20, 0, 20},
                {8, 5, 3},
                {8, -5, 13},
                {9223372036854775806L, 4611686018427387903L, 4611686018427387903L},
                {922337203685477580666D, 1D, 922337203685477580665D}
        };
    }

    @DataProvider(name = "divDataLong")
    public static Object[][] divDataLong() {
        return new Object[][]{
                {-50, -2, 25},
                {7, 7, 1},
                {30, -10L, -3},
                {0, -10, 0},
                {999999999L, 9, 111111111L},
                {9223372036854775806L, 2L, 4611686018427387903L}};
    }

    @DataProvider(name = "divDataDouble")
    public static Object[][] divDataDouble() {
        return new Object[][]{
                {-50, -2, 25},
                {7, 7, 1},
                {30, -10L, -3},
                {0, -10, 0},
                {999999999L, 9, 111111111L},
                {9223372036854775806L, 2L, 4611686018427387903L},
                {922337203685477580666D, 2D, 461168601842738790333D}};
    }

    @DataProvider(name = "multDataLong")
    public static Object[][] multDataLong() {
        return new Object[][]{
                {0, 100, 0},
                {10L, -20L, -200L},
                {-7, -7, 49},
                {898989L, 1000L, 898989000L},
                {4611686018427387903L, 2, 9223372036854775806L}};
    }

    @DataProvider(name = "multDataDouble")
    public static Object[][] multDataDouble() {
        return new Object[][]{
                {0, 100, 0},
                {10L, -20L, -200L},
                {-7, -7, 49},
                {898989L, 1000L, 898989000L},
                {4611686018427387903L, 2, 9223372036854775806L},
                {461168601842738790333D, 2D, 922337203685477580666D}};
    }

}
