package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.memoization;

import java.util.function.Function;
import java.util.stream.IntStream;

public class MemoizeFunction {

    public static void main(String args[]) {
        Function<Integer, Double> avg = MemoizeFunction::average;
        Function<Integer, Double> avgMemoized = Memo.memoize(avg);
        Function<Integer, Double> avgMemoized2 = Memo.memoize(avg);

        int n = 1_000_000_000;

        long startTime = System.currentTimeMillis();
        System.out.println(avgMemoized.apply(n));
        System.out.println("Total execution time avgMemoized: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(avgMemoized.apply(n));
        System.out.println("Total execution time avgMemoized: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(avgMemoized2.apply(n));
        System.out.println("Total execution time avgMemoized2: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static Double average(int number) {
        return IntStream.rangeClosed(1, number)
                .average()
                .orElse(0.0);
    }
}
