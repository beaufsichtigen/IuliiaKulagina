package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.utils.DriverManagerUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    @Before
    public static void setUp() {
        DriverManagerUtil.setupDriver();
    }

    @After
    public static void tearDownDriver() {
        DriverManagerUtil.tearDownDriver();
    }
}
