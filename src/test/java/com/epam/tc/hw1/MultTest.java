package com.epam.tc.hw1;

import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MultTest extends AbstractTest {
    @Test(dataProvider = "multData", dataProviderClass = DataProviders.class)
    public void calcTest(long a, long b, long expected) {
        long result = calculator.mult(a, b);
        assertThat(result).as("Multiplication calculated incorrectly").isEqualTo(expected);
    }
}