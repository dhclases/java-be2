package com.pluralsight.functionaltechniquesjava.m3buildingcomplexfunctionality;

import java.util.Collections;
import java.util.function.Function;

public class Identity {

    public static void main(String args[]) {
        int n = 10;

        Function<Integer, Integer> g = x -> x; // Or Function.identity()
        Function<Integer, Integer> f = x -> x + 1;

        /*for (int i = 0; i < n; i++) {
            g = g.compose(f);
        };*/

        g = Collections.nCopies(n, f)
                .stream()
                .reduce(g, Function::compose);

        System.out.println(g.apply(0));
    }
}
