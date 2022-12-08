package com.epam.tc.hw1;

import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddTest extends AbstractTest {
    @Test(dataProvider = "sumData", dataProviderClass = DataProviders.class)
        public void calcTest(long a, long b, long expected) {
        long result = calculator.sum(a, b);
        assertThat(result).as("Addition calculated incorrectly").isEqualTo(expected);
    }
}
