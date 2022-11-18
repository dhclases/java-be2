package com.pluralsight.functionaltechniquesjava.m3buildingcomplexfunctionality;

import java.util.function.Function;

public class RewardPointsCombiner2 {

    public static void main(String args[]) {
        Order order = new Order();

        Function<Order, RewardPoints> totalBasedRewardPoints = RewardPointsCombiner2::calculateRewardPoints;
        Function<RewardPoints, RewardPoints> roundRewardPoints = RewardPointsCombiner2::roundRewardPoints;

        RewardPoints totalRewardPoints = roundRewardPoints.apply(totalBasedRewardPoints.apply(order));

        System.out.println(totalRewardPoints);
    }

    private static RewardPoints calculateRewardPoints(Order order) {
        return new RewardPoints(19);
    }

    private static RewardPoints roundRewardPoints(RewardPoints rewardPoints) {
        return new RewardPoints((int) (Math.round(rewardPoints.points/10.0) * 10));
    }
}
