package com.pluralsight.functionaltechniquesjava.m6avoidingnulls.before;

import java.math.BigDecimal;

public class DiscountService {
    public BigDecimal calculateDiscount(Order order, Customer customer) {
        BigDecimal discount = getDiscountPercentage(customer.getRewardPoints());
        if (discount != null) {
            return order.getTotal().multiply(discount);
        } else {
            return BigDecimal.ZERO;
        }
    }

    private BigDecimal getDiscountPercentage(RewardPoints rewardPoints) {
        if (rewardPoints != null) {
            if (rewardPoints.getPoints() >= 100) {
                return new BigDecimal("10.0");
            }
            else if (rewardPoints.getPoints() >= 50) {
                return new BigDecimal("5.0");
            }
        }
        return null;
    }
}
