package com.bsu;

import java.util.Scanner;

public class TailorSeriesCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter k: ");
            int k = scanner.nextInt();
            if (k <= 0) {
                throw new InvalidParameterException("k is not natural");
            }
            System.out.println("Enter x: ");
            double x = scanner.nextDouble();
            double accuracy = Math.pow(10, -k);
            double actualValue = calculateActualValue(x);
            double calculatedValue = calculateTailorSeries(accuracy, x);

            System.out.println("Actual value: " + formattedValue(actualValue));
            System.out.println("Calculated value: " + formattedValue(calculatedValue));
        } catch (InvalidParameterException ex) {
            System.out.println("Error while reading value: " + ex);
        } catch (Exception ex) {
            System.out.println("Error while calculating: " + ex);
        }
    }

    static double calculateActualValue(double x) {
        if (x == 0.0) {
            throw new ArithmeticException("Division by 0");
        } else {
            return Math.sin(x) / x;
        }
    }

    static double calculateTailorSeries(double accuracy, double x) {
        double elem = 1;
        double calculatedValue = 0;
        int n = 0;
        while (Math.abs(elem) > Math.abs(accuracy)) {
            //elem = Math.pow(x, 2 * n) / calculateFactorial(2 * n + 1);
            calculatedValue += elem;
            n++;
            elem = -1.0 * elem * Math.pow(x, 2) / (2 * n * (2 * n + 1));
        }
        return calculatedValue;
    }

    static int calculateFactorial(int n) {
        int actualValue = 1;
        for (int counter = 1; counter <= n; ++counter) {
            actualValue *= counter;
        }
        return actualValue;
    }

    private static String formattedValue(double value) {
        return String.format("%.3f", value);
    }
}
