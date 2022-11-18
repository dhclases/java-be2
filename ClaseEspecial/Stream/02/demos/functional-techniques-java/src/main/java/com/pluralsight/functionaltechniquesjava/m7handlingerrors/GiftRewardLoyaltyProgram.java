package com.pluralsight.functionaltechniquesjava.m7handlingerrors;

public class GiftRewardLoyaltyProgram {

    private Long productId;
    private Integer neededPoints;

    public GiftRewardLoyaltyProgram() {}

    public GiftRewardLoyaltyProgram(Long productId, Integer neededPoints) {
        this.productId = productId;
        this.neededPoints = neededPoints;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getNeededPoints() {
        return neededPoints;
    }

    public void setNeededPoints(Integer neededPoints) {
        this.neededPoints = neededPoints;
    }

    @Override
    public String toString() {
        return "GiftRewardLoyaltyProgram{" +
                "productId=" + productId +
                ", neededPoints=" + neededPoints +
                '}';
    }
}
