package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;

public class SubsTest extends AbstractTest {
    @Test(dataProvider = "subsDataLong", dataProviderClass = DataProviders.class)
    public void subsLongTest(long a, long b, long expected) {
        long resultLong = calculator.sub(a, b);
        assertThat(resultLong).as("Subtraction calculated incorrectly (long)").isEqualTo(expected);
    }

    @Test(dataProvider = "subsDataDouble", dataProviderClass = DataProviders.class)
    public void subsDoubleTest(double a, double b, double expected) {
        double resultDouble = calculator.sub(a, b);
        assertThat(resultDouble).as("Subtraction calculated incorrectly (double)").isEqualTo(expected);
    }
}
