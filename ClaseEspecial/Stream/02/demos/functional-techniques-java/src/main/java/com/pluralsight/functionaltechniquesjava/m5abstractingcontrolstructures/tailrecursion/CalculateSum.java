package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.tailrecursion;

import java.util.Arrays;
import java.util.List;

import static com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.ListUtils.head;
import static com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.ListUtils.tail;

public class CalculateSum {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        /*
            Unfortunately, Java doesn’t do TCO automatically
            so a big list can still cause a stack overflow
         */
        /*List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i+1);
        }*/

        int total = sum(list);
        System.out.println(total);
    }

    public static int sum(List<Integer> list) {
        return sumTail(list, 0);
    }

    private static int sumTail(List<Integer> list, int acc) {
        return list.isEmpty()
                ? acc
                : sumTail(tail(list), head(list) + acc);
    }
}
