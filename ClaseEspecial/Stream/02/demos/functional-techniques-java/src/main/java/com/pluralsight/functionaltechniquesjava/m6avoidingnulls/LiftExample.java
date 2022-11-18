package com.pluralsight.functionaltechniquesjava.m6avoidingnulls;

import java.util.Optional;
import java.util.function.Function;

public class LiftExample {

    public static <T, U> Function<Optional<T>, Optional<U>> lift(Function<T, U> f) {
        return optional -> optional.map(f);
    }

    /*public static <T, U> Function<T, Optional<U>> liftOne(Function<T, U> f) {
        return Optional.ofNullable(val).map(f);
    }*/

    public static <T, U> Function<T, Optional<U>> liftOne(Function<T, U> f) {
        return val -> {
            try {
                return Optional.ofNullable(val).map(f);
            } catch(Exception e) {
                return Optional.empty();
            }
        };
    }

    public static void main(String args[]) {
        Function<Integer, Integer> doubler = x -> x * 2;

        Function<Optional<Integer>, Optional<Integer>> doublerOptional =
                lift(doubler);

        System.out.println( doublerOptional.apply(Optional.of(1)) );
        System.out.println( doublerOptional.apply(Optional.empty()) );

        Function<Integer, Optional<Integer>> doublerOptional2 =
                liftOne(doubler);

        System.out.println( doublerOptional2.apply(2) );
        System.out.println( doublerOptional2.apply(null) );
    }
}
