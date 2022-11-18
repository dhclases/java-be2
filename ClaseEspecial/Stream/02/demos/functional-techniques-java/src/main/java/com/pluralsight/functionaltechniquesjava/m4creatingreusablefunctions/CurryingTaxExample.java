package com.pluralsight.functionaltechniquesjava.m4creatingreusablefunctions;

import java.util.function.Function;

public class CurryingTaxExample {
    public static void main(String args[]) {
        Function<Double, Function<Double, Double>> calculateTax = rate -> amount -> amount * rate;

        Function<Double, Double> calculateNationalTax = calculateTax.apply(0.2);
        Function<Double, Double> calculateInternationalTax = calculateTax.apply(0.3);

        System.out.println( calculateNationalTax.apply(100.0) );
        System.out.println( calculateInternationalTax.apply(100.0) );
    }
}
