package com.pluralsight.functionaltechniquesjava.m8buildingcontainers.io;

import java.util.function.Function;

public interface IO<T> {
    T run();

    static <T> IO<T> of(T value) {
        return () -> value;
    }

    default <U> IO<U> map(Function<T, U> f) {
        return () -> f.apply(this.run());
    }

    default <U> IO<U> flatMap(Function<T, IO<U>> f) {
        return () -> f.apply(this.run()).run();
    }
}
