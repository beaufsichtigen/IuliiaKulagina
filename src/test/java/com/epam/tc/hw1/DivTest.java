package com.epam.tc.hw1;

import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DivTest extends AbstractTest {
    @Test(dataProvider = "divData", dataProviderClass = DataProviders.class)
    public void calcTest(int a, int b, int expected) {
        long result = calculator.div(a, b);
        assertThat(result).as("Divide calculated incorrectly").isEqualTo(expected);
    }
}
