package com.pluralsight.functionaltechniquesjava.m2thinkingfunctionally.before;

public class Order {
    private Customer customer = new Customer();
    private OrderStatus orderStatus;
    private Integer orderRewards;

    public void issueRewards() {
        this.orderStatus = OrderStatus.REWARDS_ISSUED;
        if(this.getOrderRewards() != null) {
            customer.addToRewardBalance(this.getOrderRewards());
        }
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderRewards() {
        return orderRewards;
    }

    public void setOrderRewards(Integer orderRewards) {
        this.orderRewards = orderRewards;
    }
}
