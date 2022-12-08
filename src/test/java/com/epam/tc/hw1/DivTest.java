package com.epam.tc.hw1;

import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DivTest extends AbstractTest {
    @Test(dataProvider = "divDataLong", dataProviderClass = DataProviders.class)
    public void calcTest(long a, long b, long expected) {
        long resultLong = calculator.div(a, b);
        assertThat(resultLong).as("Divide calculated incorrectly (long)").isEqualTo(expected);
    }

    @Test(dataProvider = "divDataDouble", dataProviderClass = DataProviders.class)
    public void calcTest(double a, double b, double expected) {
        double resultDouble = calculator.div(a, b);
        assertThat(resultDouble).as("Divide calculated incorrectly (double)").isEqualTo(expected);
    }
}
