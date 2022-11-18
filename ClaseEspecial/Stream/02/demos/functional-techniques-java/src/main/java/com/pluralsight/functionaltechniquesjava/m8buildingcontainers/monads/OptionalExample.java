package com.pluralsight.functionaltechniquesjava.m8buildingcontainers.monads;

import java.util.Optional;

public class OptionalExample {
    public static Optional<String> trim(String s) {
        return Optional.of(s.trim());
    }

    public static Optional<String> upperCase(String s) {
        return Optional.of(s.toUpperCase());
    }

    public static Optional<String> exclamation(String s) {
        return Optional.of(s + "!");
    }

    public static Optional<String> format(String s) {
        return Optional.of(s)
                .flatMap(n -> trim(n))
                .flatMap(n -> upperCase(n))
                .flatMap(n -> exclamation(n));
    }

    public static void main(String args[]) {
        System.out.println(format(" hello ").orElse(""));
    }
}
