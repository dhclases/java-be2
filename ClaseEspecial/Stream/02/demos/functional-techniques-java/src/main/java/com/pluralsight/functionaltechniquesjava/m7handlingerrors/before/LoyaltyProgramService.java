package com.pluralsight.functionaltechniquesjava.m7handlingerrors.before;

import com.pluralsight.functionaltechniquesjava.m7handlingerrors.GiftRewardLoyaltyProgram;

public class LoyaltyProgramService {
    private ProductRepository productRepository = new ProductRepository();
    private LoyaltyProgramRepository lpRepository = new LoyaltyProgramRepository();

    public void updateGiftReward(GiftRewardLoyaltyProgram newLoyaltyProgram){
        if(!isNumberOfPointsValid(newLoyaltyProgram)) {
            throw new RuntimeException("Invalid points");
        }
        if(isProductValid(newLoyaltyProgram)) {
            throw new RuntimeException("Invalid product");
        }
        GiftRewardLoyaltyProgram lp = lpRepository.getGiftRewardLoyaltyProgram();
        if(lp == null) {
            throw new RuntimeException("The loyalty program was not found");
        }

        lp.setNeededPoints(newLoyaltyProgram.getNeededPoints());
        lp.setProductId(newLoyaltyProgram.getProductId());

        try {
            lpRepository.save(lp);
        } catch(Exception e) {
            throw new RuntimeException("Error when saving to the database");
        }
    }

    private boolean isNumberOfPointsValid(GiftRewardLoyaltyProgram lp) {
        boolean valid = false;

        if(lp.getNeededPoints() != null || lp.getNeededPoints() > 0) {
            valid = true;
        }

        return valid;
    }

    private boolean isProductValid(GiftRewardLoyaltyProgram lp) {
        return productRepository.getProductById(lp.getProductId()) != null;
    }
}
