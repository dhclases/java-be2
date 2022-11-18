package com.pluralsight.functionaltechniquesjava.m3buildingcomplexfunctionality.predicates;

import com.pluralsight.functionaltechniquesjava.m3buildingcomplexfunctionality.RewardPoints;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ComposePredicates2 {

    public static void main(String args[]) {
        List<RewardPoints> list = Arrays.asList(
                new RewardPoints(10),
                new RewardPoints(20),
                new RewardPoints(45),
                new RewardPoints(90),
                new RewardPoints(120)
        );

        Predicate<RewardPoints> morethan40points = rp -> rp.points > 40;
        Predicate<RewardPoints> lessthan100points = rp -> rp.points < 100;

        List<RewardPoints> filteredRewardPointsAnd = list.stream()
                .filter(
                        andPredicates(
                                morethan40points,
                                lessthan100points
                        )
                )
                .collect(Collectors.toList());
        System.out.println("And: " + filteredRewardPointsAnd);

        List<RewardPoints> filteredRewardPointsOr = list.stream()
                .filter(
                        orPredicates(
                                morethan40points,
                                lessthan100points
                        )
                )
                .collect(Collectors.toList());
        System.out.println("Or: " + filteredRewardPointsOr);
    }

    private static <T> Predicate<T> andPredicates(Predicate<T>... predicates) {
        Predicate<T> p = x -> true; // Identity

        /*for (int i = 0; i < predicates.length; i++) {
            p = p.and(predicates[i]);
        };

        return p;*/
        return Arrays.stream(predicates).reduce(p, Predicate::and);
    }

    private static <T> Predicate<T> orPredicates(Predicate<T>... predicates) {
        Predicate<T> p = x -> false; // Identity

        /*for (int i = 0; i < predicates.length; i++) {
            p = p.or(predicates[i]);
        };

        return p;*/
        return Arrays.stream(predicates).reduce(p, Predicate::or);
    }
}
