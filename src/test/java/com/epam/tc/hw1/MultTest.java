package com.epam.tc.hw1;

import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MultTest extends AbstractTest {
    @Test(dataProvider = "multDataLong", dataProviderClass = DataProviders.class)
    public void calcTest(long a, long b, long expected) {
        long resultLong = calculator.mult(a, b);
        assertThat(resultLong).as("Multiplication calculated incorrectly (long)").isEqualTo(expected);
    }

    @Test(dataProvider = "multDataDouble", dataProviderClass = DataProviders.class)
    public void calcTest(double a, double b, double expected) {
        double resultDouble = calculator.mult(a, b);
        assertThat(resultDouble).as("Multiplication calculated incorrectly (double)").isEqualTo(expected);
    }
}