package com.epam.tc.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.testng.annotations.Test;


public class AddTest extends AbstractTest {
    @Test(dataProvider = "sumDataLong", dataProviderClass = DataProviders.class)
    public void sumLongTest(long a, long b, long expected) {
        long resultLong = calculator.sum(a, b);
        assertThat(resultLong).as("Addition calculated incorrectly (long)").isEqualTo(expected);
    }

    @Test(dataProvider = "sumDataDouble", dataProviderClass = DataProviders.class)
    public void sumDoubleTest(double a, double b, double expected) {
        double resultDouble = calculator.sum(a, b);
        assertThat(resultDouble).as("Addition calculated incorrectly (double)").isEqualTo(expected);
    }
}
