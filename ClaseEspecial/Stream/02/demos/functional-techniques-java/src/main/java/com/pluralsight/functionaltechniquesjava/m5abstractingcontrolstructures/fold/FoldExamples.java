package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.fold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.ListUtils.*;

public class FoldExamples {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        Function<Integer, Function<Integer, Integer>> sum = x -> y -> x + y;
        int total = foldLeft(list, 0, sum);
        System.out.println(total);

        Function<Integer, Function<Integer, Integer>> length = x -> y -> x + 1;
        total = foldLeft(list, 0, length);
        System.out.println(total);

        Function<List<Integer>, Function<Integer, List<Integer>>> reverse = x -> y -> concat(Arrays.asList(y), x);
        List<Integer> reversedList = foldLeft(list, new ArrayList<>(), reverse);
        System.out.println(reversedList);
    }
}
