package com.pluralsight.functionaltechniquesjava.m6avoidingnulls.after;

import java.math.BigDecimal;
import java.util.Optional;

public class DiscountService {
    public BigDecimal calculateDiscount(Order order, Customer customer) {
        /*BigDecimal discount = getDiscountPercentage(customer.getRewardPoints());
        if (discount != null) {
            return order.getTotal().multiply(discount);
        } else {
            return BigDecimal.ZERO;
        }*/
        return customer.getRewardPoints()
                .flatMap(rp -> getDiscountPercentage(rp))
                .map(discount -> order.getTotal().multiply(discount))
                .orElse(BigDecimal.ZERO);
    }

    private Optional<BigDecimal> getDiscountPercentage(RewardPoints rewardPoints) {
        if (rewardPoints.getPoints() >= 100) {
            return Optional.of(new BigDecimal("10.0"));
        }
        else if (rewardPoints.getPoints() >= 50) {
            return Optional.of(new BigDecimal("5.0"));
        }
        return Optional.empty();
    }
}
