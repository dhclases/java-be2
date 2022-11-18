package com.pluralsight.functionaltechniquesjava.m8buildingcontainers.monads;


import java.util.stream.Stream;

public class StreamExample {
    public static Stream<String> trim(String s) {
        return Stream.of(s.trim());
    }

    public static Stream<String> upperCase(String s) {
        return Stream.of(s.toUpperCase());
    }

    public static Stream<String> exclamation(String s) {
        return Stream.of(s + "!");
    }

    public static Stream<String> format(String s) {
        return Stream.of(s)
                .flatMap(n -> trim(n))
                .flatMap(n -> upperCase(n))
                .flatMap(n -> exclamation(n));
    }

    public static void main(String args[]) {
        format(" hello ").forEach(System.out::println);
    }
}
