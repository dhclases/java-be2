package com.pluralsight.functionaltechniquesjava.m8buildingcontainers.monads;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static CompletableFuture<String> trim(String s) {
        return CompletableFuture.completedFuture(s.trim());
    }

    public static CompletableFuture<String> upperCase(String s) {
        return CompletableFuture.completedFuture(s.toUpperCase());
    }

    public static CompletableFuture<String> exclamation(String s) {
        return CompletableFuture.completedFuture(s + "!");
    }

    public static CompletableFuture<String> format(String s) {
        return CompletableFuture.completedFuture(s)
                .thenCompose(n -> trim(n))
                .thenCompose(n -> upperCase(n))
                .thenCompose(n -> exclamation(n));
    }

    public static void main(String args[]) {
        format(" hello ").thenAccept(System.out::println);
    }
}
