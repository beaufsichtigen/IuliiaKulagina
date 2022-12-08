package com.epam.tc.hw1;

import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddTest extends AbstractTest {
    @Test(dataProvider = "sumDataLong", dataProviderClass = DataProviders.class)
    public void calcTestLong(long a, long b, long expected) {
        long resultLong = calculator.sum(a, b);
        assertThat(resultLong).as("Addition calculated incorrectly (long)").isEqualTo(expected);
    }

    @Test(dataProvider = "sumDataDouble", dataProviderClass = DataProviders.class)
    public void calcTestDouble(double a, double b, double expected) {
        double resultDouble = calculator.sum(a, b);
        assertThat(resultDouble).as("Addition calculated incorrectly (double)").isEqualTo(expected);
    }
}
