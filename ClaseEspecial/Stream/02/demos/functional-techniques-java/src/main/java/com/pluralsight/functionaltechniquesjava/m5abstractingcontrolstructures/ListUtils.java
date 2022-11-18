package com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures;

import com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.tailcalloptimization.TailCall;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.pluralsight.functionaltechniquesjava.m5abstractingcontrolstructures.tailcalloptimization.TailCall.*;

public class ListUtils {
    public static <T> T head(List<T> list) {
        return list.get(0);
    }

    public static <T> List<T> tail(List<T> list) {
        List<T> newList = new ArrayList<>(list);
        newList.remove(0);

        return newList;
    }

    public static <T> List<T> concat(List<T> list1, List<T> list2) {
        List<T> newList = new ArrayList<T>(list1);
        newList.addAll(list2);

        return newList;
    }

    public static <T, U> U foldLeft(List<T> list, U identity,
                                    Function<U, Function<T, U>> f) {
        return foldLeftTail(list, identity, f).eval();
    }

    private static <T, U> TailCall<U> foldLeftTail(List<T> list, U identity,
                                                   Function<U, Function<T, U>> f) {
        return list.isEmpty()
                ? done(identity)
                : suspend(() -> foldLeftTail(tail(list),
                                                f.apply(identity).apply(head(list)), f));
    }

    // Tail recursive version
    /*public static <T, U> U foldLeft(List<T> ts, U identity,
                                    Function<U, Function<T, U>> f) {
        return ts.isEmpty()
                ? identity
                : foldLeft(tail(ts), f.apply(identity).apply(head(ts)), f);
    }*/

    // Imperative equivalent (not completely)
    /*public static <T, U> U foldLeft(List<T> list, U identity,
                                    Function<U, Function<T, U>> f) {
        U result = identity;
        for (T t : list) {
            result = f.apply(result).apply(t);
        }
        return result;
    }*/
}
