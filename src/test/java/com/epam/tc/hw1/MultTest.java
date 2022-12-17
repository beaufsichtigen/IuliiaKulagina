package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class MultTest extends AbstractTest {
    @Test(dataProvider = "multDataLong", dataProviderClass = DataProviders.class)
    public void multLongTest(long a, long b, long expected) {
        long resultLong = calculator.mult(a, b);
        assertThat(resultLong).as("Multiplication calculated incorrectly (long)").isEqualTo(expected);
    }

    @Test(dataProvider = "multDataDouble", dataProviderClass = DataProviders.class)
    public void multDoubleTest(double a, double b, double expected) {
        double resultDouble = calculator.mult(a, b);
        assertThat(resultDouble).as("Multiplication calculated incorrectly (double)").isEqualTo(expected);
    }
}
