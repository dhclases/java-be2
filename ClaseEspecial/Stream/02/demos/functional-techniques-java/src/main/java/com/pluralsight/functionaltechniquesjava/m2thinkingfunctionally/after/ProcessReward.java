package com.pluralsight.functionaltechniquesjava.m2thinkingfunctionally.after;

public class ProcessReward {
    public static Order issueRewards(Order order) {
        return new Order(OrderStatus.REWARDS_ISSUED, order.orderRewards);
    }

    public static Customer updateBalanceReward(Order order, Customer customer) {
        if(order.orderRewards != null) {
            Customer newCustomer = new Customer(
                    customer.rewardBalance + order.orderRewards);
            return newCustomer;
        }

        return customer;
    }
}
