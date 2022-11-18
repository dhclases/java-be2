package com.pluralsight.functionaltechniquesjava.m3buildingcomplexfunctionality;

import java.util.function.Function;

public class RewardPointsCombiner3 {

    public static void main(String args[]) {
        Order order = new Order();

        Function<Order, RewardPoints> totalBasedRewardPoints = RewardPointsCombiner3::calculateRewardPoints;
        Function<RewardPoints, RewardPoints> roundRewardPoints = RewardPointsCombiner3::roundRewardPoints;

        //Function<Order, RewardPoints> f = compose(roundRewardPoints, totalBasedRewardPoints);
        //Function<Order, RewardPoints> f = roundRewardPoints.compose(totalBasedRewardPoints);
        Function<Order, RewardPoints> f = totalBasedRewardPoints.andThen(roundRewardPoints);

        System.out.println(f.apply(order));
    }

    private static RewardPoints calculateRewardPoints(Order order) {
        return new RewardPoints(19);
    }

    private static RewardPoints roundRewardPoints(RewardPoints rewardPoints) {
        return new RewardPoints((int) (Math.round(rewardPoints.points/10.0) * 10));
    }

    private static Function<Order, RewardPoints> compose(Function<RewardPoints, RewardPoints> f1,
                                                         Function<Order, RewardPoints> f2) {
        return arg -> f1.apply(f2.apply(arg));
    }
}
