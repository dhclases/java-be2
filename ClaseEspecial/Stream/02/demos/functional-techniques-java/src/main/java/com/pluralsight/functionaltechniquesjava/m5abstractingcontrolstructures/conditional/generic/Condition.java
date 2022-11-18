package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.conditional.generic;

import com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.conditional.Product;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Condition {

    public static <T> Statement<T> _if(Supplier<Boolean> condition, T action) {
        return new Statement<>(condition, action);
    }

    public static <T> Optional<T> match(Statement<T>... statements) {
        return Stream.of(statements)
                .filter(s -> s.condition.get())
                .findFirst()
                .map(s -> s.action);
    }

    public static void main(String args[]) {
        Function<Product, Supplier<Double>> calculateDiscount = p ->
                Condition.<Supplier<Double>>match(
                        Condition._if(() -> p.price < 10.0, () -> p.price * 0.1),
                        Condition._if(() -> p.price >= 10.0 && p.price < 100.0, () -> p.price * 0.2),
                        Condition._if(() -> p.price >= 100.0, () -> p.price * 0.3)
                ).orElse(() -> 0.0);


        Supplier<Double> result = calculateDiscount.apply(new Product(10.0));
        System.out.println(result.get());

        Function<Integer, Consumer<Integer>> rangeChecker = n ->
                Condition.<Consumer<Integer>>match(
                        Condition._if(() -> n < 10, (Integer i) -> {
                            System.out.println("Executed " + i); }),
                        Condition._if(() -> n > 10 && n < 100, (Integer i) -> {
                            System.out.println("Executed " + i); })
                ).orElse((Integer i) -> {
                    System.out.println("Executed " + i);});

        rangeChecker.apply(6).accept(7);
    }
}
