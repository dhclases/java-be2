package com.pluralsight.functionaltechniquesjava.m6avoidingnulls.after;

public class RewardPoints {
    public final Integer points;

    public RewardPoints(Integer points) {
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }

    public RewardPoints combine(RewardPoints rewardPoints) {
        return new RewardPoints(this.points + rewardPoints.points);
    }

    @Override
    public String toString() {
        return "RewardPoints{" +
                "points=" + points +
                '}';
    }
}
