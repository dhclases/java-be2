package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.memoization;

import java.util.Objects;

public class Tuple3<T, U, V> {
    public final T _1;
    public final U _2;
    public final V _3;

    public Tuple3(T t, U u, V v) {
        _1 = Objects.requireNonNull(t);
        _2 = Objects.requireNonNull(u);
        _3 = Objects.requireNonNull(v);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;
        return Objects.equals(_1, tuple3._1) &&
                Objects.equals(_2, tuple3._2) &&
                Objects.equals(_3, tuple3._3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2, _3);
    }
}
