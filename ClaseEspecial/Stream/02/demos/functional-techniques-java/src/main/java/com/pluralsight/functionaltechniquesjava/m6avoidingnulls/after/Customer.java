package com.pluralsight.functionaltechniquesjava.m6avoidingnulls.after;

import java.util.Optional;

public class Customer {
    private RewardPoints rewardPoints;

    public void setRewardPoints(RewardPoints rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public Optional<RewardPoints> getRewardPoints() {
        return Optional.ofNullable(rewardPoints);
    }
}
