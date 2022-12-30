package com.epam.tc.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions(
            features = "src/test/resources/cucumber_features",
            glue = {"com.epam.tc.hw5.steps"},
            publish = true
            //stepNotifications = true
    )
    public class RunCucumberTest extends AbstractTestNGCucumberTests {}
