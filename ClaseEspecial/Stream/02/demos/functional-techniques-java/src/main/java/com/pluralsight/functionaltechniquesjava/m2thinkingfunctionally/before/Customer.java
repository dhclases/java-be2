package com.pluralsight.functionaltechniquesjava.m2thinkingfunctionally.before;

public class Customer {
    private Integer rewardBalance;

    public void addToRewardBalance(Integer rewardBalance) {
        this.rewardBalance += rewardBalance;
    }

    public Integer getRewardBalance() {
        return rewardBalance;
    }

    public void setRewardBalance(Integer rewardBalance) {
        this.rewardBalance = rewardBalance;
    }
}
