package com.pluralsight.functionaltechniquesjava.m4creatingreusablefunctions;

import java.util.function.Function;

public class CurryingFunctionExample {
    public static void main(String args[]) {
        CurriedFunction3 f =
                s -> i -> l -> s + i + l;

        System.out.println(f.apply((short)1).apply(2).apply(3L));
    }
}

interface CurriedFunction3 extends
        Function<Short, Function<Integer, Function<Long, Long>>> {}
