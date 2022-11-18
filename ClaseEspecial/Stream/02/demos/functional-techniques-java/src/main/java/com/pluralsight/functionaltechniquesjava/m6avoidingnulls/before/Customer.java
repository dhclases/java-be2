package com.pluralsight.functionaltechniquesjava.m6avoidingnulls.before;

public class Customer {
    private RewardPoints rewardPoints;

    public void setRewardPoints(RewardPoints rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public RewardPoints getRewardPoints() {
        return rewardPoints;
    }
}
