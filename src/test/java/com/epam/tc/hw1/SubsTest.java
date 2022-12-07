package com.epam.tc.hw1;

import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SubsTest extends AbstractTest {
    @Test(dataProvider = "subsData", dataProviderClass = DataProviders.class)
    public void calcTest(int a, int b, int expected) {
        long result = calculator.sub(a, b);
        assertThat(result).as("Subtraction calculated incorrectly").isEqualTo(expected);
    }
}
