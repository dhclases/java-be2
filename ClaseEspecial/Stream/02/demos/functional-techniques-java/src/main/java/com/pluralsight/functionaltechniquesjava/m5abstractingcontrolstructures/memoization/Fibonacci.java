package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.memoization;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Fibonacci {
    private static final Map<Integer,BigInteger> cache = new ConcurrentHashMap<Integer,BigInteger>();

    static {
        cache.put(0, BigInteger.ZERO);
        cache.put(1, BigInteger.ONE);
    }

    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();

        //System.out.println(fibonacci(40));
        System.out.println(fibonacciTail(40, BigInteger.ZERO, BigInteger.ONE));

        System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    private static BigInteger fibonacciTail(int number, BigInteger acc1, BigInteger acc2) {
        if (number == 0) {
            return acc1;
        } else if (number == 1) {
            return acc2;
        }
        return fibonacciTail(number - 1, acc2, acc1.add(acc2));
    }

    public static BigInteger fibonacciMem(int number) {
        if (number > 1 && cache.get(number) == null) {
            cache.put(number, fibonacciMem(number - 1).add(fibonacciMem(number - 2)));
        }

        return cache.get(number);
    }

    public static BigInteger fibonacci(int number) {
        if (number == 0 || number == 1) {
            return BigInteger.valueOf(number);
        }
        return fibonacci(number - 1).add(fibonacci(number - 2));
    }
}
