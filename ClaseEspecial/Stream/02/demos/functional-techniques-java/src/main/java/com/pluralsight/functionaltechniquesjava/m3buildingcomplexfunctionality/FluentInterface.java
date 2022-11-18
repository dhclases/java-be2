package com.pluralsight.functionaltechniquesjava.m3buildingcomplexfunctionality;

public class FluentInterface {

    public static void main(String args[]) {
        RewardPoints reward1 = new RewardPoints(5);
        RewardPoints reward2 = new RewardPoints(10);
        RewardPoints reward3 = new RewardPoints(20);

        RewardPoints totalRewardPoints = reward1
                                            .combine(reward2)
                                            .combine(reward3);

        System.out.println(totalRewardPoints);
    }
}
