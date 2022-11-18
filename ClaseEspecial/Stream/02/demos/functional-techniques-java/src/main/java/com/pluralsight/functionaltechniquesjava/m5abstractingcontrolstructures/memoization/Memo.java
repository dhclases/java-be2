package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.memoization;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Memo<T, U> {
    private final Map<T, U> cache = new ConcurrentHashMap<>();

    private Memo() { }

    public static <T, U> Function<T, U> memoize(Function<T, U> f) {
        return new Memo<T, U>()._memoize(f);
    }

    private Function<T, U> _memoize(Function<T, U> f) {
        return param -> cache.computeIfAbsent(param, f::apply);
    }
}

