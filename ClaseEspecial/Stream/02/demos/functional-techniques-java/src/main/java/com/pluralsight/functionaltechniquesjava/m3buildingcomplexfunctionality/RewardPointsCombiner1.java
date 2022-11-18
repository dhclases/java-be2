package com.pluralsight.functionaltechniquesjava.m3buildingcomplexfunctionality;

public class RewardPointsCombiner1 {

    public static RewardPoints combine(RewardPoints rp1, RewardPoints rp2) {
        return new RewardPoints(rp1.points + rp2.points);
    }

    public static void main(String args[]) {
        RewardPoints reward1 = new RewardPoints(5);
        RewardPoints reward2 = new RewardPoints(10);
        RewardPoints reward3 = new RewardPoints(20);

        RewardPoints totalRewardPoints = combine(combine(reward1, reward2), reward3);

        System.out.println(totalRewardPoints);
    }
}
