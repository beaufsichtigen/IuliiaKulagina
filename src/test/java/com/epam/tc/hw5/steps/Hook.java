package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.utils.DriverManagerUtil;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hook {

    @BeforeAll
    public static void setUp() {
        DriverManagerUtil.setupDriver();
    }

    @AfterAll
    public static void tearDownDriver() {
        DriverManagerUtil.tearDownDriver();
    }
}
