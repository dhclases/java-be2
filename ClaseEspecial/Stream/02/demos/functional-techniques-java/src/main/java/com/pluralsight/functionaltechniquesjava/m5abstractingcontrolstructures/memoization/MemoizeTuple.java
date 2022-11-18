package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.memoization;

import java.util.function.Function;

public class MemoizeTuple {

    public static void main(String args[]) {
        Function<Tuple3<Integer, Integer, Integer>, Integer> functionWithTuple =
                tuple -> tuple._1 + tuple._2 + tuple._3;

        Function<Tuple3<Integer, Integer, Integer>, Integer> functionWithTupleMemoized =
                Memo.memoize(functionWithTuple);

        long startTime = System.currentTimeMillis();
        System.out.println(functionWithTupleMemoized.apply(new Tuple3<>(10,20,30)));
        System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        System.out.println(functionWithTupleMemoized.apply(new Tuple3<>(10,20,30)));
        System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
