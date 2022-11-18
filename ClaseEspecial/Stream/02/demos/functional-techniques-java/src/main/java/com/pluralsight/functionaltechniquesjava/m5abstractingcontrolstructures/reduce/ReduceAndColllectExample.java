package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ReduceAndColllectExample {
    public static void main(String args[]) {
        String result = null;

        // Bad usage
        List<String> letters = Arrays.asList("a", "b", "c");
        StringBuilder identity = new StringBuilder();
        result = letters
                .stream()
                .reduce(identity, StringBuilder::append, StringBuilder::append)
                .toString();
        System.out.println("Identity: " + identity);
        System.out.println("Result: " + result);

        // Correct usage
        Supplier<StringBuilder> supplier = () -> new StringBuilder();
        result = letters
                .stream()
                .collect(supplier, StringBuilder::append, StringBuilder::append)
                .toString();
        System.out.println("Result: " + result);

        // They are not completely equivalent to foldLeft
    }
}
