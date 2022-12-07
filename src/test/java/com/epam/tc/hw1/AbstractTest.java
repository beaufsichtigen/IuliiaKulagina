package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;


public abstract class AbstractTest {

    Calculator calculator = new Calculator();

//    @Test(dataProvider = "ExampleProvider")
//    public void calcTest(int a, int b, int expected) {
//        long result = calculator.sum(a,b);
//        assertThat(result).as("Sum calculated incorrectly").isEqualTo(expected);
//    }
//
//        @DataProvider
//        public static Object [][] ExampleProvider() {
//            return new Object[][]{
//                    {5, 6, 11},
//                    {12, 12, 24}};
//        }

}
