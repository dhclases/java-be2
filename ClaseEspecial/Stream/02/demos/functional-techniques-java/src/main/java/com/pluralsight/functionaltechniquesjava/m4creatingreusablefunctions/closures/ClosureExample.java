package com.pluralsight.functionaltechniquesjava.m4creatingreusablefunctions.closures;

import java.util.function.Function;

public class ClosureExample {

    public static void main(String args[]) {
        Integer a = 2; //Integer.parseInt(args[0]);

        /*Function<Integer, Integer> f = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer t) {
                return t * a;
            }
        };*/
        Function<Integer, Integer> f = t -> t * a;
        System.out.println(f.apply(2));
    }
}
