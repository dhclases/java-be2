package com.pluralsight.functionaltechniquesjava.m7handlingerrors.after;

import com.pluralsight.functionaltechniquesjava.m7handlingerrors.GiftRewardLoyaltyProgram;

public class LoyaltyProgramRepository {
    public GiftRewardLoyaltyProgram getGiftRewardLoyaltyProgram() {
        // Get loyalty program from the database
        return new GiftRewardLoyaltyProgram(1L, 100);
    }

    public GiftRewardLoyaltyProgram save(GiftRewardLoyaltyProgram lp) {
        // For testing if neededPoints == 1000 we'll return a failure
        if(lp.getNeededPoints() == 1000) {
            throw new RuntimeException("Database error");
        }
        // Save loyalty program to the database
        return lp;
    }
}
