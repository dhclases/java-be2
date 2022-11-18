package com.pluralsight.functionaltechniquesjava.m3buildingcomplexfunctionality.predicates;

import com.pluralsight.functionaltechniquesjava.m3buildingcomplexfunctionality.RewardPoints;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ComposePredicates1 {

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
                .filter(morethan40points.and(lessthan100points))
                .collect(Collectors.toList());
        /*List<RewardPoints> filteredRewardPointsAnd = list.stream()
                                                        .filter(rp -> rp.points > 40 && rp.points < 100)
                                                        .collect(Collectors.toList());*/
        /*List<RewardPoints> filteredRewardPointsAnd = list.stream()
                                                        .filter(morethan40points)
                                                        .filter(lessthan100points)
                                                        .collect(Collectors.toList());*/
        System.out.println("And: " + filteredRewardPointsAnd);

        List<RewardPoints> filteredRewardPointsOr = list.stream()
                .filter(morethan40points.or(lessthan100points))
                .collect(Collectors.toList());
        /*List<RewardPoints> filteredRewardPointsOr = list.stream()
                                                        .filter(rp -> rp.points > 40 || rp.points < 100)
                                                        .collect(Collectors.toList());*/
        System.out.println("Or: " + filteredRewardPointsOr);
    }
}
