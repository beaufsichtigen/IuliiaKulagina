package com.epam.tc.hw1;

import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SubsTest extends AbstractTest {
    @Test(dataProvider = "subsDataLong", dataProviderClass = DataProviders.class)
    public void calcTest(long a, long b, long expected) {
        long resultLong = calculator.sub(a, b);
        assertThat(resultLong).as("Subtraction calculated incorrectly (long)").isEqualTo(expected);
    }

    @Test(dataProvider = "subsDataLong", dataProviderClass = DataProviders.class)
    public void calcTest(double a, double b, double expected) {
        double resultDouble = calculator.sub(a, b);
        assertThat(resultDouble).as("Subtraction calculated incorrectly (double)").isEqualTo(expected);
    }
}
