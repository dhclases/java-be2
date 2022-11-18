package com.pluralsight.functionaltechniquesjava.m7handlingerrors.after;

import com.pluralsight.functionaltechniquesjava.m7handlingerrors.GiftRewardLoyaltyProgram;
import com.pluralsight.functionaltechniquesjava.m7handlingerrors.Result;

public class LoyaltyProgramService {
    private ProductRepository productRepository = new ProductRepository();
    private LoyaltyProgramRepository lpRepository = new LoyaltyProgramRepository();

    public Result<GiftRewardLoyaltyProgram> updateGiftReward(GiftRewardLoyaltyProgram newLoyaltyProgram){
//        if(!isNumberOfPointsValid(newLoyaltyProgram)) {
//            throw new RuntimeException("Invalid points");
//        }
//        if(isProductValid(newLoyaltyProgram)) {
//            throw new RuntimeException("Invalid product");
//        }
//        GiftRewardLoyaltyProgram lp = lpRepository.getGiftRewardLoyaltyProgram();
//        if(lp == null) {
//            throw new RuntimeException("The loyalty program was not found");
//        }
//
//        lp.setNeededPoints(newLoyaltyProgram.getNeededPoints());
//        lp.setProductId(newLoyaltyProgram.getProductId());
//
//        try {
//            lpRepository.save(lp);
//        } catch(Exception e) {
//            throw new RuntimeException("Error when saving to the database");
//        }

        return Result.ofNullable(newLoyaltyProgram)
                .flatMap(this::isNumberOfPointsValid)
                .flatMap(this::isProductValid)
                .flatMap(lp -> Result.of(lpRepository.getGiftRewardLoyaltyProgram()))
                .map(lp -> updateLoyaltyProgram(lp, newLoyaltyProgram))
                .map(lpRepository::save);
    }

    private GiftRewardLoyaltyProgram updateLoyaltyProgram(GiftRewardLoyaltyProgram oldLoyaltyProgram,
                                                          GiftRewardLoyaltyProgram newLoyaltyProgram) {
        oldLoyaltyProgram.setNeededPoints(newLoyaltyProgram.getNeededPoints());
        oldLoyaltyProgram.setProductId(newLoyaltyProgram.getProductId());

        return oldLoyaltyProgram;
    }

    private Result<GiftRewardLoyaltyProgram> isNumberOfPointsValid(GiftRewardLoyaltyProgram lp) {
        Result<GiftRewardLoyaltyProgram> result = null;

        if(lp.getNeededPoints() != null && lp.getNeededPoints() > 0) {
            result = Result.success(lp);
        } else {
            result = Result.failure("Invalid points");
        }

        return result;
    }

    private Result<GiftRewardLoyaltyProgram> isProductValid(GiftRewardLoyaltyProgram lp) {
        return Result.of(lp)
                .filter(newLp -> productRepository.getProductById(newLp.getProductId()) != null,
                        "Invalid product");
    }

    public static void main(String args[]) {
        LoyaltyProgramService service = new LoyaltyProgramService();

        // Null
        System.out.println(service.updateGiftReward(null));

        // Invalid points
        System.out.println(service.updateGiftReward(new GiftRewardLoyaltyProgram(2L, 0)));

        // Invalid product
        System.out.println(service.updateGiftReward(new GiftRewardLoyaltyProgram(99L, 100)));

        // Database error
        System.out.println(service.updateGiftReward(new GiftRewardLoyaltyProgram(2L, 1000)));

        // Success
        System.out.println(service.updateGiftReward(new GiftRewardLoyaltyProgram(2L, 100)));
    }
}
