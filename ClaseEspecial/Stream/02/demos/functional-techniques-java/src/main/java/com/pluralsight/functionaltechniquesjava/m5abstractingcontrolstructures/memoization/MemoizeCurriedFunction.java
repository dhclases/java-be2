package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.memoization;

import java.util.function.Function;

public class MemoizeCurriedFunction {

    public static void main(String args[]) {
        Function<Integer, Function<Integer, Function<Integer, Integer>>> curriedFunction =
                x -> y -> z -> x + y + z;

        Function<Integer, Function<Integer, Function<Integer, Integer>>> curriedFunctionMemoized =
                Memo.memoize(x ->
                        Memo.memoize(y ->
                                Memo.memoize(z -> x + y + z)
                        )
                );

        long startTime = System.currentTimeMillis();
        System.out.println(curriedFunctionMemoized.apply(1).apply(2).apply(3));
        System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(curriedFunctionMemoized.apply(1).apply(2).apply(3));
        System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
