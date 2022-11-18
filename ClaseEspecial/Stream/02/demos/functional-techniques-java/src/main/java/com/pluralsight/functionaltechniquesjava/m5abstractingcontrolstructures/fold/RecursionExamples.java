package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.fold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.ListUtils.*;

public class RecursionExamples {
    public static void main(String args[]) {
        List<Integer> order = Arrays.asList(1, 2, 3, 4);

        int total = sum(order, 0);
        System.out.println(total);

        total = length(order, 0);
        System.out.println(total);

        List<Integer> reversedList = reverse(order, new ArrayList<>());
        System.out.println(reversedList);

        Function<Integer, Function<Integer, Integer>> sum = x -> y -> x + y;
        total = generic(order, 0, sum);
        System.out.println(total);
    }

    static Integer sum(List<Integer> list, int acc) {
        return list.isEmpty()
                ? acc
                : sum(tail(list), head(list) + acc);
    }

    static Integer length(List<Integer> list, int acc) {
        return list.isEmpty()
                ? acc
                : length(tail(list), 1 + acc);
    }

    static List<Integer> reverse(List<Integer> list, List<Integer> acc) {
        return list.isEmpty()
                ? acc
                : reverse(tail(list), concat(Arrays.asList(head(list)), acc));
    }

    static Integer generic(List<Integer> list, int acc, Function<Integer, Function<Integer, Integer>> f) {
        return list.isEmpty()
                ? acc
                : generic(tail(list), f.apply(head(list)).apply(acc), f);
    }
}
