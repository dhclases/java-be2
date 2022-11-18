package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.tailcalloptimization;

import java.util.ArrayList;
import java.util.List;

import static com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.ListUtils.*;
import static com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.tailcalloptimization.TailCall.*;

public class CalculateSum {
    public static void main(String args[]) {
        //List<Integer> list = Arrays.asList(2, 1, 3);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i+1);
        }

        int total = sum(list);
        System.out.println(total);
    }

    public static int sum(List<Integer> list) {
        return sumTail(list, 0).eval();
    }

    private static TailCall<Integer> sumTail(List<Integer> list, int acc) {
        return list.isEmpty()
                ? done(acc)
                : suspend(() -> sumTail(tail(list), acc + head(list)));
    }
}
