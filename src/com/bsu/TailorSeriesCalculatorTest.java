package com.bsu;

import static org.junit.Assert.*;

public class TailorSeriesCalculatorTest {
      @org.junit.Test
    public void testCalculateTailorSeries() {
        double lowerBoundOfTheRange = -10;
        double higherBoundOfTheRange = 10;
        double x = 0;
        double eps = Math.pow(10, -10);
        double expected = 0;
        double actual = 0;

        for (int counter = 0; counter < 5; counter++) {
            x = lowerBoundOfTheRange + Math.random() * higherBoundOfTheRange;
            expected = TailorSeriesCalculator.calculateActualValue(x);
            actual = TailorSeriesCalculator.calculateTailorSeries(eps, x);
            assertEquals(expected, actual, eps);
        }
    }
}
